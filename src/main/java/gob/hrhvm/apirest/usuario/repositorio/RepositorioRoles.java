package gob.hrhvm.apirest.usuario.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gob.hrhvm.apirest.usuario.entidad.EmpleadosRoles;

public interface RepositorioRoles extends JpaRepository<EmpleadosRoles,Integer>{
    public List<EmpleadosRoles> findByIdEmpleadoRol(Integer idEmpleadoRol);
}
