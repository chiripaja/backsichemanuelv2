package gob.hrhvm.apirest.totem;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gob.hrhvm.apirest.Publico.RepositorioTiposDocumentos;
import gob.hrhvm.apirest.Publico.Dto.DtoApiDni;
import gob.hrhvm.apirest.Publico.Dto.DtoApiSis;
import gob.hrhvm.apirest.Publico.entidad.Respuesta;
import gob.hrhvm.apirest.Publico.entidad.TiposDocumentos;
import gob.hrhvm.apirest.totem.entidades.TotemCuposFechas;
import gob.hrhvm.apirest.totem.entidades.TotemCuposLibres;
import gob.hrhvm.apirest.totem.entidades.TotemEspecialidades;
import gob.hrhvm.apirest.totem.entidades.TotemEstablecimientos;
import gob.hrhvm.apirest.totem.entidades.TotemGuardar;
import gob.hrhvm.apirest.totem.entidades.TotemGuardarRpta;
import gob.hrhvm.apirest.totem.entidades.TotemPacienteBuscar;
import gob.hrhvm.apirest.totem.repositorio.RepositorioTotemCuposFechas;
import gob.hrhvm.apirest.totem.repositorio.RepositorioTotemCuposLibres;
import gob.hrhvm.apirest.totem.repositorio.RepositorioTotemEspecialidades;
import gob.hrhvm.apirest.totem.repositorio.RepositorioTotemEstablecimientos;
import gob.hrhvm.apirest.totem.repositorio.RepositorioTotemGuardarRpta;
import gob.hrhvm.apirest.totem.repositorio.RepositorioTotemPacienteBuscar;
import gob.hrhvm.apirest.totem.repositorio.RepositorioTotemPacienteGuardar;
import gob.hrhvm.apirest.totem.repositorio.RepositorioTotemSis;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioTotem {
    private final RepositorioTotemEspecialidades rp_tt;
    private final RepositorioTotemCuposLibres rpCl;
    private final RepositorioTotemPacienteBuscar rpPb;
    private final RepositorioTotemSis rpSis;
    private final RepositorioTotemPacienteGuardar rpPg;
    private final RepositorioTotemEstablecimientos rpEst;
    private final RepositorioTotemGuardarRpta rpGuarda;
    private final RepositorioTotemCuposFechas rpTcf;
    private final RepositorioTiposDocumentos rptd;
    
    public List<TotemEspecialidades> listaPorId(Integer id){
        return rp_tt.listaPorId(id);
    }
    public List<TotemCuposLibres> listaCupos(Integer idDepartamento){
        return rpCl.cuposLibres(idDepartamento);
    }
    
    public TotemPacienteBuscar buscarPaciente(String dni, Integer tipo){
        return rpPb.buscarDni(dni, tipo);
    }
    public Respuesta guardarPaciente(DtoApiDni d){
        return rpPg.pacienteGuardar(
            d.getApeMaterno(),
            d.getApePaterno(),
            d.getDireccion(),
            d.getFechaNacimiento(),
            d.getNombres(),
            d.getNroDocumento(),
            d.getSexo(),
            d.getUbigeoResidencia(),
            d.getLugarResidencia(),
            d.getFechaEmision()
        );
    }
    public Respuesta sisGuardar(DtoApiSis t){
        return rpSis.sisGuardar(
            t.getApeMaterno(),          t.getApePaterno(),
            t.getContrato(),		    t.getDescEESS(),        t.getCorrelativo(),
            t.getDescTipoSeguro(),	    t.getDisa(),
            t.getEess(),			    t.getEstado(),
            t.getFecAfiliacion(),	    t.getFecCaducidad(),
            t.getFecNacimiento(),	    t.getGenero(),
            t.getIdGrupoPoblacional(),  t.getIdNumReg(),
            t.getIdPlan(),  			t.getIdUbigeo(),
            t.getNombres(),             t.getNroContrato(),
            t.getNroDocumento(),		t.getRegimen(),
            t.getTabla(),				t.getTipoDocumento(),
            t.getTipoFormato(),	        t.getTipoSeguro()
        );
    }
    public List<TotemEstablecimientos> buscarEstablecimiento(String codigo){
        return rpEst.buscarCodigo(codigo);
    }
    public TotemGuardarRpta admisionGuardar(TotemGuardar t){
        return rpGuarda.guardar(
            t.getIdPaciente(), t.getIdEspecialidad(), t.getIdIafa(), t.getReferenciaCodigo(), t.getReferenciaNumero()
        );
    }
    public Optional<TotemCuposFechas> TotemCuposFechas(){
        return rpTcf.findById(1);
    }
    public TiposDocumentos docId(Integer id){
        return rptd.findByIdDocIdentidad(id);
    }
}
