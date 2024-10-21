package gob.hrhvm.apirest.Publico;
import gob.hrhvm.apirest.Publico.Dto.PeticionDto;
import gob.hrhvm.apirest.Publico.entidad.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import gob.hrhvm.apirest.Publico.Dto.DtoApiDni;
import gob.hrhvm.apirest.Publico.Dto.DtoApiSis;
import gob.hrhvm.apirest.config.HeaderRequestInterceptor;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import jakarta.servlet.http.HttpServletRequest;

//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/Publico")
/*
public class PublicoControlador {
    @Autowired
    private Environment environment;
    
    @Autowired
    private PublicoServicio sv;

    @Operation(summary = "Busca DNI en Reniec-API-Local .210.215", description = "/api/v1/reniec/search/dni")
    @GetMapping("BuscarReniec/{dni}")
    public DtoApiDni buscarReniec(@PathVariable String dni) {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<DtoApiDni> r = rt
            .getForEntity(
                String.format(environment.getProperty("env.data.LocalApi") + "reniec/search/%s",dni),DtoApiDni.class);
        return r.getBody();
    }
    
    @Operation(summary = "Busca si existiera, datos del Sis, por dni y tipo de documento", description = "/api/v1/sis/search/tipo/dni (1 = Dni, 3 = Extranjeros)")
    @GetMapping("BuscarSis")
    public DtoApiSis buscarSis(@RequestParam String dni, @RequestParam(required = false) String tipo) {
        RestTemplate rt = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(new HeaderRequestInterceptor("Authorization","Bearer "+environment.getProperty("env.data.Key")));
        rt.setInterceptors(interceptors);
        if (tipo==null) tipo="1";
        ResponseEntity<DtoApiSis> r = rt.getForEntity(environment.getProperty("env.data.LocalApi")+"/sis/search/"+tipo+"/"+dni+"/",DtoApiSis.class);
        return r.getBody();
    }

    @Operation(summary = "Busca Distrito por nombre", description = "")
    @GetMapping("UbigeoBuscarDistrito/{distrito}")
    public List<Ubigeo> buscarDistrito(@PathVariable String distrito) {
        return sv.buscarDistrito(distrito);
    }

    @Operation(summary = "Tipos documentos", description = "")
    @GetMapping("TiposDocumentos")
    public List<TiposDocumentos> listarTiposDocs() {
        return sv.listarDocumentos();
    }

    @Operation(summary = "Paises", description = "")
    @GetMapping("Paises")
    public List<Paises> listarPaises() {
        return sv.listarPaises();


    }
    
    @GetMapping("Estado")
    public ActualizarCupos estadoCupos() {
        return sv.buscarEstado();
    }
}*/

@RestController
@RequestMapping({"/Publico"})
public class PublicoControlador {
    @Autowired
    private Environment environment;
    @Autowired
    private PublicoServicio sv;
    private Integer timeout = 5000;

    private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(this.timeout);
        clientHttpRequestFactory.setReadTimeout(this.timeout);
        return clientHttpRequestFactory;
    }

    @Operation(
            summary = "Busca DNI en Reniec-API-Local .210.215",
            description = "/api/v1/reniec/search/dni"
    )
    /*@GetMapping({"BuscarReniec/{dni}"})
    public DtoApiDni buscarReniec(@PathVariable String dni, @RequestBody PeticionDto peticion) {
        RestTemplate rt = new RestTemplate(this.getClientHttpRequestFactory());
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList();
        interceptors.add(new HeaderRequestInterceptor("Authorization", "Bearer " + this.environment.getProperty("env.data.Key")));
        rt.setInterceptors(interceptors);
        ResponseEntity<DtoApiDni> r = rt.getForEntity(String.format(this.environment.getProperty("env.data.LocalApi") + "reniec/searchfull/%s", dni), DtoApiDni.class, new Object[0]);
        return (DtoApiDni)r.getBody();
    }*/
    @PostMapping({"BuscarReniec/{dni}"})
    public ResponseEntity<?> buscarReniec(@PathVariable String dni, @RequestBody PeticionDto peticion, HttpServletRequest request) {

        RestTemplate rt = new RestTemplate(this.getClientHttpRequestFactory());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+this.environment.getProperty("env.data.Key"));

        peticion.setIp(request.getRemoteAddr());
        peticion.setFechaConsulta(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        peticion.setNumeroDocumento(dni);
        peticion.setTipoDocumento("1"); // DNI
        peticion.setEndPoint("RENIEC");

        HttpEntity<PeticionDto> httpEntity = new HttpEntity<>(peticion,headers);



        ResponseEntity<String> r = rt.postForEntity("http://192.168.210.215:8081/api/v1/reniec/searchfull/"+dni ,httpEntity,String.class);
        return  r;//(DtoApiDni)r.getBody();

    }

    @Operation(
            summary = "Busca si existiera, datos del Sis, por dni y tipo de documento"
    )

    @PostMapping({"BuscarSis/{tipo}/{dni}"})
    public ResponseEntity<?> buscarSis(@RequestParam String dni, @RequestParam(required = false) String tipo , @RequestBody PeticionDto peticion, HttpServletRequest request) {
        RestTemplate rt = new RestTemplate(this.getClientHttpRequestFactory());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+this.environment.getProperty("env.data.Key"));

        peticion.setIp(request.getRemoteAddr());
        peticion.setFechaConsulta(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        peticion.setNumeroDocumento(dni);
        peticion.setTipoDocumento(tipo);
        peticion.setEndPoint("SIS");

        HttpEntity<PeticionDto> httpEntity = new HttpEntity<>(peticion,headers);

        if (tipo == null) {
            tipo = "1";
        }

        ResponseEntity<String> r = rt.postForEntity("http://192.168.210.215:8081/api/v1/sis/search/"+tipo+"/"+dni ,httpEntity,String.class);
        return r;
    }

    @Operation(
            summary = "Busca Distrito por nombre",
            description = ""
    )
    @GetMapping({"UbigeoBuscarDistritoNombre/{distrito}"})
    public List<Ubigeo> buscarDistrito(@PathVariable String distrito) {
        return this.sv.buscarDistrito(distrito);
    }

    @Operation(
            summary = "Distrito"
    )
    @GetMapping({"UbigeoBuscarDistrito/{id}"})
    public List<Ubigeo> buscarDistrito2(@PathVariable Integer id) {
        return this.sv.idDistrito(id);
    }

    @Operation(
            summary = "Distrito"
    )
    @GetMapping({"UbigeoBuscarReniec/{id}"})
    public List<Ubigeo> buscarDistrito3(@PathVariable Integer id) {
        return this.sv.idDistrito2(id);
    }

    @Operation(
            summary = "Tipos documentos",
            description = ""
    )
    @GetMapping({"TiposDocumentos"})
    public List<TiposDocumentos> listarTiposDocs() {
        return this.sv.listarDocumentos();
    }

    @Operation(
            summary = "Paises",
            description = ""
    )
    @GetMapping({"Paises"})
    public List<Paises> listarPaises() {
        return this.sv.listarPaises();
    }

    @GetMapping({"Estado"})
    public ActualizarCupos estadoCupos() {
        return this.sv.buscarEstado();
    }

    @Operation(
            summary = "Diccionario",
            description = ""
    )
    @GetMapping({"Maestros/{categoria}"})
    public List<Maestros> listaMaestros(@PathVariable String categoria) {
        return this.sv.listaDiccionario(categoria);
    }

    public PublicoControlador() {
    }
}
