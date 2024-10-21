package gob.hrhvm.apirest.admision.servicio;

import java.util.List;
import java.util.Optional;

import gob.hrhvm.apirest.admision.entidad.*;
import gob.hrhvm.apirest.admision.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import gob.hrhvm.apirest.Publico.RepositorioTiposDocumentos;
import gob.hrhvm.apirest.Publico.Dto.DtoApiSis;
import gob.hrhvm.apirest.Publico.entidad.Respuesta;
import gob.hrhvm.apirest.Publico.entidad.TiposDocumentos;
import gob.hrhvm.apirest.totem.entidades.TotemEstablecimientos;
import gob.hrhvm.apirest.totem.repositorio.RepositorioTotemEstablecimientos;

@Service
//@RequiredArgsConstructor
public class ServicioAdmision {

    //@Autowired
     private final AtencionRepository respository;
    private final RepositorioCuposLibres rp;
    private final RepositorioPacientes rp_pac;
    private final RepositorioServicios rp_ser;
    private final RepositorioTriaje rp_tr;
    private final RepositorioDepartamentos rp_dp;
    private final RepositorioTriajeGuarda rp_tg;
    private final RepositorioTriajeVariables rpTv;
    private final RepositorioTriajeGestante rpTgt;
    private final RepositorioTriajeNacido rpTna;
    private final RepositorioFuentesFinanciamiento rpFf;
    private final RepositorioTiposFinanciamiento rptF;
    private final RepositorioDoc rpdo;
    private final RepositorioCitadosBloqueados rpCb;
    private final RepositorioAdmision rpAd;
    private final RepositorioTotemEstablecimientos rpEst;
    private final RepositorioReproAtencion rpRa;
    private final RepositorioRepro rpRe;
    private final RepositorioTriajee rpTr;
    private final RepositorioTicket rpTi;
    private final RepositorioReproDispone rpdi;
    private final RepositorioReproSet rpse;
    private final RepositorioTiposDocumentos rptd;
    private final RepositorioEspecialidades rp_es;
    private final RepositorioMedico rp_me;

    public List<CuposLibres> cuposLibres() {
        return this.rp.cuposLibres();
    }

    public Optional<Pacientes> buscarId(Integer Id) {
        return this.rp_pac.findById(Id);
    }

    public Optional<Pacientes> buscarDni(String NroDocumento) {
        return Optional.ofNullable(this.rp_pac.findByNroDocumento(NroDocumento));
    }

    public List<Servicios> buscarEspecialidades(String IdDepartamento) {
        return this.rp_ser.findByIdDepartamento(IdDepartamento);
    }

    public TriajeSolicitaNuevo triajeSolicitaAgregar(Integer idAtencion) {

       // Triaje triaje = rpTr.findByIdAtencion(idAtencion);
        System.out.println((idAtencion));
        Optional<Atenciones> atenciones=respository.findAtenciones(idAtencion);

        System.out.println(atenciones.get().getIdAtencion());



        TriajeSolicitaNuevo tn = new TriajeSolicitaNuevo();

        tn.setTriaje(this.rpTr.findByIdCuentaAtencion(atenciones.get().getIdCuentaAtencion()));
        tn.setTriajeSolicita(this.rp_tr.triajeSolicitaAgregar(atenciones.get().getIdAtencion()));
        tn.setTriajeVariables(this.rpTv.findByIdAtencion(atenciones.get().getIdAtencion()));
        tn.setTriajeGestante(this.rpTgt.triajeId(atenciones.get().getIdAtencion()));
        tn.setTriajeNacido(this.rpTna.triajeId(atenciones.get().getIdAtencion()));
        return tn;
    }

    public List<Departamentos> filtrarDepartamento(String nombre) {
        return nombre.equals("0") ? this.rp_dp.filtrarTotem() : this.rp_dp.filtrarDepartamento(nombre);
    }

    public List<Departamentos> dptos() {
        return this.rp_dp.lista();
    }

    public Respuesta triajeGuardar(TriajeNormal t) {
        return this.rp_tg.triajeGuardar(t.getIdAtencion(), t.getTriajePulso(), t.getTriajeTemperatura(), t.getPresionSist(), t.getPresionDiast(), t.getTriajeFrecCardiaca(), t.getTriajePerimetro(), t.getTriajeFrecRespiratoria(), t.getTriajePeso(), t.getTriajeTalla(), t.getTriajePerimCefalico(), t.getTriajeSaturacion(), t.getTriajeIdUsuario(), t.getObservaciones(), t.getGestante().getIdAtencion(), t.getGestante().getAlturaUterina(), t.getGestante().getFrecCardiaca(), t.getGestante().getEdadGestacional(), t.getGestante().getFechaParto(), t.getNacido().getIdAtencion(), t.getNacido().getApariencia(), t.getNacido().getCirculatorio(), t.getNacido().getRespiratorio());
    }

    public Respuesta sisGuardar(DtoApiSis t, Integer idUsuario) {
        return this.rp_tg.sisGuardar(t.getApeMaterno(), t.getApePaterno(), t.getContrato(), t.getDescEESS(), t.getCorrelativo(), t.getDescTipoSeguro(), t.getDisa(), t.getEess(), t.getEstado(), t.getFecAfiliacion(), t.getFecCaducidad(), t.getFecNacimiento(), t.getGenero(), t.getIdGrupoPoblacional(), t.getIdNumReg(), t.getIdPlan(), t.getIdUbigeo(), t.getNombres(), t.getNroContrato(), t.getNroDocumento(), t.getRegimen(), t.getTabla(), t.getTipoDocumento(), t.getTipoFormato(), t.getTipoSeguro(), idUsuario);
    }

    public List<FuentesFinanciamiento> fuentesLista() {
        return this.rpFf.findAll();
    }

    public List<TiposFinanciamiento> tiposFinanciaLista(Integer ff) {
        return this.rptF.findByIdFuenteFinanciamiento(ff);
    }

    public List<CitadosBloqueados> listarCitadosIdProg(Integer id) {
        return this.rpCb.findByIdProgramacion(id);
    }

    public AdmisionGuardarRpta admisionWebGuardar(AdmisionGuardar t) {
        return this.rpAd.admisionWebGuardar(t.getIdPaciente(), t.getIdProgramacion(), t.getIdIafa(), t.getReferenciaCodigo(), t.getReferenciaNumero(), t.getEsAdicional(), t.getIdUsuario());
    }

    public List<TotemEstablecimientos> buscarEstablecimiento(String nombre) {
        return this.rpEst.buscarNombre(nombre);
    }

    public List<TotemEstablecimientos> listarTodo() {
        return this.rpEst.listarTodo();
    }

    public Respuesta supRegs(Integer id, Integer id2) {
        return this.rpse.supRegs(id, id2);
    }

    public Optional<ReproAtencion> buscarReproAtencion(Integer idCuenta) {
        return this.rpRa.findByIdCuentaAtencion(idCuenta);
    }

    public Optional<Ticket> buscarTicketIdCuenta(Integer idCuenta) {
        return this.rpTi.findByIdCuentaAtencion(idCuenta);
    }

    public List<Repro> listarRepro(String s) {
        return this.rpRe.findByServicio(s);
    }

    public List<ReproDispone> listarDisp(Integer id) {
        return this.rpdi.buscar(id);
    }

    public List<TiposDocIdentidad> listad() {
        return this.rpdo.findAll();
    }

    public TiposDocumentos docId(Integer id) {
        return this.rptd.findByIdDocIdentidad(id);
    }

    public Respuesta reproSet(ReproSet r) {
        return this.rpse.reproSet(r.getIdProgramacion(), r.getHoraInicio(), r.getIdCuentaAtencion(), r.getIdUsuario());
    }

    public Respuesta reproSett(ReproProg r) {
        return this.rpse.repro(r.getIdProgramacion(), r.getFecha(), r.getIdMedico());
    }

    public Respuesta paciente(Pacientes r) {
        return this.rpse.paciente(r.getNroDocumento(), r.getPrimerNombre(), r.getSegundoNombre(), r.getTercerNombre(), r.getApellidoPaterno(), r.getApellidoMaterno(), r.getIdDistritoNacimiento(), r.getFechaNacimiento(), r.getTelefono(), r.getEmail(), r.getMadreDocumento(), r.getMadreApellidoPaterno(), r.getMadreApellidoMaterno(), r.getMadrePrimerNombre(), r.getIdDistritoDomicilio(), r.getIdDistritoProcedencia(), r.getIdEtnia(), r.getIdIdioma(), r.getIdGradoInstruccion(), r.getIdEstadoCivil(), r.getIdProcedencia(), r.getIdTipoOcupacion(), r.getIdPaisDomicilio(), r.getIdPaisProcedencia(), r.getIdPaisNacimiento(), r.getIdDocIdentidad(), r.getMadreTipoDocumento(), r.getNroOrdenHijo(), r.getIdTipoSexo(), r.getObservacion(), r.getFoto().getFoto());
    }

    public List<Repro> listaReprom() {
        return this.rpRe.findByMedico();
    }

    public Optional<Pacientes> buscar(String n, Integer t) {
        return this.rp_pac.buscar(n, t);
    }

    public List<Servicios> servicios(Integer id) {
        return this.rp_ser.servicios(id);
    }

    public List<Especialidades> listEspecialidad() {
        return this.rp_es.findAll();
    }

    public List<Medico> listMedico(Integer id) {
        return this.rp_me.findByIdEspecialidad(id);
    }

    public List<CitadosBloqueados> listarCitadosIdProg_(String f, Integer id) {
        return this.rpCb.listaCitas(f, id);
    }

    public List<CitadosBloqueados> listarCitadosIdProgg_(String d, String h, Integer de, Integer esp, Integer id) {
        if (de.equals(0) && esp.equals(0) && id.equals(0)) {
            return this.rpCb.listaCitas0(d, h);
        } else if (esp.equals(0) && id.equals(0)) {
            return this.rpCb.listaCitas1(d, h, de);
        } else {
            return id.equals(0) ? this.rpCb.listaCitas2(d, h, de, esp) : this.rpCb.listaCitas3(d, h, de, esp, id);
        }
    }

    public ServicioAdmision(final RepositorioCuposLibres rp, final RepositorioPacientes rp_pac, final RepositorioServicios rp_ser, final RepositorioTriaje rp_tr, final RepositorioDepartamentos rp_dp, final RepositorioTriajeGuarda rp_tg, final RepositorioTriajeVariables rpTv, final RepositorioTriajeGestante rpTgt, final RepositorioTriajeNacido rpTna, final RepositorioFuentesFinanciamiento rpFf, final RepositorioTiposFinanciamiento rptF, final RepositorioDoc rpdo, final RepositorioCitadosBloqueados rpCb, final RepositorioAdmision rpAd, final RepositorioTotemEstablecimientos rpEst, final RepositorioReproAtencion rpRa, final RepositorioRepro rpRe, final RepositorioTriajee rpTr, final RepositorioTicket rpTi, final RepositorioReproDispone rpdi, final RepositorioReproSet rpse, final RepositorioTiposDocumentos rptd, final RepositorioEspecialidades rp_es, final RepositorioMedico rp_me, final AtencionRepository repository) {
        this.rp = rp;
        this.rp_pac = rp_pac;
        this.rp_ser = rp_ser;
        this.rp_tr = rp_tr;
        this.rp_dp = rp_dp;
        this.rp_tg = rp_tg;
        this.rpTv = rpTv;
        this.rpTgt = rpTgt;
        this.rpTna = rpTna;
        this.rpFf = rpFf;
        this.rptF = rptF;
        this.rpdo = rpdo;
        this.rpCb = rpCb;
        this.rpAd = rpAd;
        this.rpEst = rpEst;
        this.rpRa = rpRa;
        this.rpRe = rpRe;
        this.rpTr = rpTr;
        this.rpTi = rpTi;
        this.rpdi = rpdi;
        this.rpse = rpse;
        this.rptd = rptd;
        this.rp_es = rp_es;
        this.rp_me = rp_me;
        this.respository=repository;
    }
}
