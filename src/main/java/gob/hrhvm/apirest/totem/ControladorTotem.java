package gob.hrhvm.apirest.totem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import gob.hrhvm.apirest.Publico.Dto.PeticionDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import gob.hrhvm.apirest.Publico.Dto.DtoApiDni;
import gob.hrhvm.apirest.Publico.Dto.DtoApiSis;
import gob.hrhvm.apirest.Publico.entidad.Respuesta;
import gob.hrhvm.apirest.Publico.entidad.TiposDocumentos;
import gob.hrhvm.apirest.config.HeaderRequestInterceptor;
import gob.hrhvm.apirest.totem.entidades.TotemCuposFechas;
import gob.hrhvm.apirest.totem.entidades.TotemCuposLibres;
import gob.hrhvm.apirest.totem.entidades.TotemEspecialidades;
import gob.hrhvm.apirest.totem.entidades.TotemEstablecimientos;
import gob.hrhvm.apirest.totem.entidades.TotemGuardar;
import gob.hrhvm.apirest.totem.entidades.TotemGuardarRpta;
import gob.hrhvm.apirest.totem.entidades.TotemPacienteBuscar;
import gob.hrhvm.apirest.totem.entidades.TotemPacienteDatos;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Totem")
public class ControladorTotem {
    @Autowired
    private Environment environment;

    private final ServicioTotem sv;

    @Operation(summary = "Busca establecimientos por codigo", description = "Select from Establecimientos like codigo")
    @GetMapping("/Establecimientos/{codigo}")
    public List<TotemEstablecimientos> buscarEstablecimiento(@PathVariable String codigo) {
        return sv.buscarEstablecimiento(codigo);
    }

    @Operation(summary = "Lista Especialidades", description = "exec ApiTotemEspecialidades :idDepartamento")
    @GetMapping("/Especialidades/{idDepartamento}")
    public List<TotemEspecialidades> listar(@PathVariable Integer idDepartamento) {
        return sv.listaPorId(idDepartamento);
    }

    @Operation(summary = "Lista cupos disponibles para HOY", description = "exec ApiTotemCuposLibres :idDepartamento")
    @GetMapping("/Especialidades/CuposHoy/{idDepartamento}")
    public List<TotemCuposLibres> cuposLibres(@PathVariable Integer idDepartamento) {
        return sv.listaCupos(idDepartamento);
    }

    @Operation(summary = "Verifica Identidad y SIS, del solicitante", description = "Si DNI existe se envia datos FROM Pacientes, sino se guarda en Pacientes los datos obtenidos de RENIEC-Api-Local. Luego se verifica si tiene seguro SIS, si tuviera se guarda en SegurosSIS.")
    @PostMapping("/SolicitaAdmitir")
    public TotemPacienteDatos solicitaAdmitir(@RequestParam String dni, @RequestParam(required = false) Integer idDocIdentidad,  @RequestBody PeticionDto peticion, HttpServletRequest request) {
        TotemPacienteDatos rpta = new TotemPacienteDatos();
        TotemPacienteBuscar Paciente = new TotemPacienteBuscar();
        TiposDocumentos tipo = new TiposDocumentos();
        //if (tipo==null) tipo=1;
        tipo = sv.docId(idDocIdentidad);
        Paciente = sv.buscarPaciente(dni, idDocIdentidad);
        HttpEntity<PeticionDto> httpEntity = null;
        if (Paciente.getExito().equals(0) && tipo.getCodigoSIS().equals(1)) {
            DtoApiDni reniec = new DtoApiDni();
            RestTemplate rt = new RestTemplate();


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + this.environment.getProperty("env.data.Key"));

            peticion.setIp(request.getRemoteAddr());
            peticion.setFechaConsulta(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
            peticion.setNumeroDocumento(dni);
            peticion.setTipoDocumento("1"); // DNI
            peticion.setEndPoint("RENIEC");

            httpEntity = new HttpEntity<>(peticion, headers);

            // servicio de afiliacioon al reciec sustituir metdo de monitoreo y auditoria de las peticiones
            //ResponseEntity<DtoApiDni> r = rt.getForEntity(String.format(environment.getProperty("env.data.LocalApi") +"reniec/search/%s",dni),DtoApiDni.class);


            ResponseEntity<DtoApiDni> r = rt.postForEntity("http://192.168.210.215:8081/api/v1/reniec/searchfull/" + dni, httpEntity, DtoApiDni.class);


            reniec = r.getBody();
            sv.guardarPaciente(reniec);
            Paciente = sv.buscarPaciente(dni, tipo.getCodigoSIS());
        }
        DtoApiSis Sis = new DtoApiSis();
        RestTemplate rt = new RestTemplate();
        /*List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(new HeaderRequestInterceptor("Authorization", "Bearer " + String.format(environment.getProperty("env.data.Key"))));
        rt.setInterceptors(interceptors);*/

        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.APPLICATION_JSON);
        headers1.set("Authorization", "Bearer " + this.environment.getProperty("env.data.Key"));

        peticion.setIp(request.getRemoteAddr());
        peticion.setFechaConsulta(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        peticion.setNumeroDocumento(dni);
        peticion.setTipoDocumento("1"); // DNI
        peticion.setEndPoint("SIS");

        httpEntity = new HttpEntity<>(peticion, headers1);


        //ResponseEntity<DtoApiSis> r = rt.getForEntity(environment.getProperty("env.data.LocalApi")+"sis/search/"+tipo.getCodigoSIS().toString()+"/"+dni+"/",DtoApiSis.class);
        ResponseEntity<DtoApiSis> re = rt.postForEntity("http://192.168.210.215:8081/api/v1/sis/search/"+tipo.getCodigoSIS()+"/"+dni+"/", httpEntity, DtoApiSis.class);

        Sis = re.getBody();
        Respuesta R = new Respuesta();
        R = sv.sisGuardar(Sis);
        rpta.setPaciente(Paciente);
        rpta.setSis(Sis);
        rpta.setSisRpta(R);
        return rpta;
    }

    @Operation(summary = "Admisiona al paciente", description = "")
    @PostMapping("/AdmisionGuardar")
    public TotemGuardarRpta admisionGuardar(@RequestBody TotemGuardar admision) {
        return sv.admisionGuardar(admision);
    }

    @Operation(summary = "Rango de fechas para cupos y admision", description = "")
    @GetMapping("/RangoFechas")
    public Optional<TotemCuposFechas> rangoFechas() {
        return sv.TotemCuposFechas();
    }

}