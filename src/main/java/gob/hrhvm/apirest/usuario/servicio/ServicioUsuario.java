package gob.hrhvm.apirest.usuario.servicio;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import gob.hrhvm.apirest.usuario.repositorio.RepositorioRoles;
import gob.hrhvm.apirest.usuario.repositorio.RepositorioUsuario;
import gob.hrhvm.apirest.usuario.entidad.DtoSolicitaAcceso;
import gob.hrhvm.apirest.usuario.entidad.DtoVerificaAcceso;
import gob.hrhvm.apirest.usuario.entidad.EmpleadosRoles;

@Service
@RequiredArgsConstructor
public class ServicioUsuario {
    private final RepositorioUsuario repositorioUsuario;
    private final RepositorioRoles r_ro;

    public DtoVerificaAcceso verificaAcceso(DtoSolicitaAcceso p){
        return repositorioUsuario.verificaAcceso(p.usuario, p.clave);
    }

    public List<EmpleadosRoles> getRolesPorIdEmpleado(Integer idEmpleado){
        return r_ro.findByIdEmpleadoRol(idEmpleado);
    }

}