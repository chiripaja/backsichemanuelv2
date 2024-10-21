package gob.hrhvm.apirest.admision;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import gob.hrhvm.apirest.Publico.Dto.DtoApiSis;
import gob.hrhvm.apirest.Publico.entidad.Respuesta;
import gob.hrhvm.apirest.admision.entidad.AdmisionGuardar;
import gob.hrhvm.apirest.admision.entidad.AdmisionGuardarRpta;
import gob.hrhvm.apirest.admision.entidad.CitadosBloqueados;
import gob.hrhvm.apirest.admision.entidad.CuposLibres;
import gob.hrhvm.apirest.admision.entidad.Departamentos;
import gob.hrhvm.apirest.admision.entidad.FuentesFinanciamiento;
import gob.hrhvm.apirest.admision.entidad.Pacientes;
import gob.hrhvm.apirest.admision.entidad.Repro;
import gob.hrhvm.apirest.admision.entidad.ReproAtencion;
import gob.hrhvm.apirest.admision.entidad.ReproDispone;
import gob.hrhvm.apirest.admision.entidad.ReproProg;
import gob.hrhvm.apirest.admision.entidad.ReproSet;
import gob.hrhvm.apirest.admision.entidad.Servicios;
import gob.hrhvm.apirest.admision.entidad.Ticket;
import gob.hrhvm.apirest.admision.entidad.TiposFinanciamiento;
import gob.hrhvm.apirest.admision.entidad.TriajeNormal;
import gob.hrhvm.apirest.admision.entidad.TriajeSolicitaNuevo;
import gob.hrhvm.apirest.admision.servicio.ServicioAdmision;
import gob.hrhvm.apirest.config.HeaderRequestInterceptor;
import gob.hrhvm.apirest.totem.entidades.TotemEstablecimientos;
import gob.hrhvm.apirest.totem.entidades.TotemPacienteDatos;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

public class ControladorAdmision {
    @Autowired
    private Environment environment;
    @Autowired
    private final ServicioAdmision sv=null;
    
    private Integer timeout=7000;

    private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory  = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        clientHttpRequestFactory.setReadTimeout(timeout);
        return clientHttpRequestFactory;
    }
    
    @Operation(summary = "Lista cupos libres desde hoy a 30 dias", description = "exec ApiRptCuposLibresDetalle")    
    @GetMapping("/Admision/CuposLibres")
    public List <CuposLibres> cuposLibres() {
        return sv.cuposLibres();
    }

    @Operation(summary = "Busca un paciente por IdPaciente", description = "select * from Pacientes")
    @GetMapping("/Pacientes/Id/{id}")
    public Optional<Pacientes> buscarId(@PathVariable Integer id) {
        return sv.buscarId(id);
    }
    
    @Operation(summary = "Busca un paciente por nroDocumento", description = "select * from Pacientes")
    @GetMapping("/Pacientes/Dni/{dni}")
    public Optional<Pacientes> buscarDni(@PathVariable String dni) {
        return sv.buscarDni(dni);
    }

    @Operation(summary = "Lista departamentos", description = "")
    @GetMapping("/Departamentos")
    public List<Departamentos> dptos() {
        return sv.dptos();
    }
    

    @Operation(summary = "Lista departamentos", description = "Si nombre es 0 entonces from DepartamentosHospital where totem='1', caso contrario from DepartamentosHospital where nombre like {nombre%} ")
    @GetMapping("/Departamentos/{nombre}")
    public List<Departamentos> filtrarDepartamentos(@PathVariable String nombre) {
        return sv.filtrarDepartamento(nombre);
    }
    
    @Operation(summary = "Lista especialidades por IdDepartamento", description = "from ApiServicios where IdDepartamento = {id}")
    @GetMapping("/Especialidades/IdDepartamento/{id}")
    public List<Servicios> buscarEspecialidad(@PathVariable String id) {
        return sv.buscarEspecialidades(id);
    }
    
    @Operation(summary = "Valida si es posible registrar triaje.", description = "Exec ApiTriajeSolicitaAgregar idAtencion")
    @GetMapping("/Triaje/SolicitaAgregar/{idCuenta}")
    public TriajeSolicitaNuevo triajeSolicitaAgregar(@PathVariable Integer idCuenta) {
        return sv.triajeSolicitaAgregar(idCuenta);
    }
    @Operation(summary = "Guarda triaje normal, gestante y recien nacido", description = "Inserta registros en SIGH_Externa.AtencionesCE, SIGH.TriajeGestante, SIGH.TriajeNacido")
    @PostMapping("/Triaje/Guardar")
    public Respuesta triajeGuardar(@RequestBody TriajeNormal triaje) {
        return sv.triajeGuardar(triaje);
    }
    
    @Operation(summary = "Buscar Sis para SIHCE escritorio", description = "Si existe guarda en SegurosSis para que SIHCE pueda consumir en citas/admision (1=Dni, 3=Extranjeros)")
    @GetMapping("/SisBuscar")
    public DtoApiSis buscarSis(@RequestParam String dni, @RequestParam(required = false) Integer tipo) {
        RestTemplate rt = new RestTemplate(getClientHttpRequestFactory());
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(new HeaderRequestInterceptor("Authorization","Bearer "+environment.getProperty("env.data.Key")));  
        rt.setInterceptors(interceptors);
        if (tipo==null) tipo=1;
        ResponseEntity<DtoApiSis> r = rt.getForEntity(environment.getProperty("env.data.LocalApi")+"sis/search/"+tipo+"/"+dni+"/",DtoApiSis.class);
        return r.getBody();
    }

    @Operation(summary = "Guardar Sis para SIHCE escritorio", description = "Si existe se borra y se inserta en SegurosSis")
    @GetMapping("/SisGuardar")
    public TotemPacienteDatos solicitaAdmitir(@RequestParam String dni, @RequestParam(required = false) Integer tipo, @RequestParam Integer idUsuario) {
        TotemPacienteDatos rpta = new TotemPacienteDatos();
        DtoApiSis Sis = new DtoApiSis();
        RestTemplate rt = new RestTemplate(getClientHttpRequestFactory());
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(new HeaderRequestInterceptor("Authorization","Bearer "+environment.getProperty("env.data.Key")));  
        rt.setInterceptors(interceptors);
        if (tipo==null) tipo=1;
        ResponseEntity<DtoApiSis> r = rt.getForEntity(environment.getProperty("env.data.LocalApi")+"sis/search/"+tipo+"/"+dni+"/",DtoApiSis.class);
        Sis = r.getBody();
        Respuesta R = new Respuesta();
        R = sv.sisGuardar(Sis, idUsuario);
        rpta.setSis(Sis);
        rpta.setSisRpta(R);
        return rpta;
    }
    
    @Operation(summary = "Todas las fuentes de financiamiento activas")
    @GetMapping("/FuentesFinanciamiento")
    public List<FuentesFinanciamiento> fuentesListar() {
        return sv.fuentesLista();
    }
    

    @Operation(summary = "Tipo de financiamiento por fuente")
    @GetMapping("/TiposFinanciamiento/{idFuente}")
    public List<TiposFinanciamiento> tiposFinanciaLista(@PathVariable Integer idFuente) {
        return sv.tiposFinanciaLista(idFuente);
    }

    @Operation(summary = "Citados y bloqueos por idProgramación. ", description = "From Citas union From CitasBloqueadas")
    @GetMapping("/Citados/{idProgramacion}")
    public List<CitadosBloqueados> listarCitados(@PathVariable Integer idProgramacion) {
        return sv.listarCitadosIdProg(idProgramacion);
    }

    @Operation(summary = "Guardar Admision", description = "")
    @PostMapping("/AdmisionGuardar")
    public AdmisionGuardarRpta admisionWebGuardar(@RequestBody AdmisionGuardar admision) {
        return sv.admisionWebGuardar(admision);
    }
    @Operation(summary = "Busca establecimientos por nombre", description = "Select from Establecimientos like nombre")
    @GetMapping("/Establecimientos/{nombre}")
    public List<TotemEstablecimientos> buscarEstablecimiento(@PathVariable String nombre) {
        return sv.buscarEstablecimiento(nombre);
    }
    @Operation(summary = "Listar todo ordenado por nombre", description = "Select from Establecimientos order by nombre")
    @GetMapping("/EstablecimientosTodo")
    public List<TotemEstablecimientos> listarTodos() {
        return sv.listarTodo();
    }

    @GetMapping("/TicketAdmision/{idCuentaAtencion}")
    public Optional<Ticket> ticket(@PathVariable Integer idCuentaAtencion) {
        return sv.buscarTicketIdCuenta(idCuentaAtencion);
    }

    @GetMapping("/CitaAnula/{idCita}/{idUsuario}")
    public Respuesta supRegs(@PathVariable Integer idCita, @PathVariable Integer idUsuario) {
        return sv.supRegs(idCita, idUsuario);
    }

    @Operation(summary = "Buscar cuenta", description = "buscar datos de cuenta para reprogramacion")
    @GetMapping("/Repro/Buscar/{idCuentaAtencion}")
    public Optional<ReproAtencion> reproBuscar(@PathVariable Integer idCuentaAtencion) {
        return sv.buscarReproAtencion(idCuentaAtencion);
    }

    @PostMapping("/Paciente/nuevo")
    public Respuesta paciente(@RequestBody Pacientes r) {
        return sv.paciente(r);
    }

    @GetMapping("/Repro/Opciones/{servicio}")
    public List<Repro> listarRepo(@PathVariable String servicio) {
        return sv.listarRepro(servicio);
    }
    @PostMapping("/Repro/ReproProg")
    public Respuesta reproRep(@RequestBody ReproProg r) {
        return sv.reproSett(r);
    }
    @GetMapping("/Repro/Medicos")
    public List<Repro> medicos() {
        return sv.listaReprom();
    }

    @GetMapping("/Repro/Dispone/{id}")
    public List<ReproDispone> disp(@PathVariable Integer id) {
        return sv.listarDisp(id);
    }
    @PostMapping("/Repro/Repro")
    public Respuesta reproRep(@RequestBody ReproSet r) {
        return sv.reproSet(r);
    }
    @GetMapping("/Paciente/{NroDoc}/{idDocIdentidad}")
    public Optional<Pacientes> buscaPaciente(@PathVariable String NroDoc, @PathVariable Integer idDocIdentidad) {
        return sv.buscar(NroDoc, idDocIdentidad);
    }   

    @GetMapping("/Servicios/{idEspecialidad}")
    public List<Servicios> servicios(@PathVariable Integer idEspecialidad) {
        return sv.servicios(idEspecialidad);
    }
}