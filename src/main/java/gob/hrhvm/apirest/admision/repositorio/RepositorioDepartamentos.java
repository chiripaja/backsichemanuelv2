package gob.hrhvm.apirest.admision.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.admision.entidad.Departamentos;

@Repository
public interface RepositorioDepartamentos extends JpaRepository<Departamentos,Integer>{

    @Query( value = "select idDepartamento, nombre, totem from DepartamentosHospital where nombre like ?1% order by nombre",  nativeQuery = true    )
    List<Departamentos> filtrarDepartamento(String nombre);

    @Query( value = "select idDepartamento, nombre, totem from DepartamentosHospital where totem='1' order by nombre",  nativeQuery = true    )
    List<Departamentos> filtrarTotem();

    @Query( value = "select idDepartamento, nombre, totem from DepartamentosHospital order by nombre",  nativeQuery = true   )
    List<Departamentos> lista();

}
