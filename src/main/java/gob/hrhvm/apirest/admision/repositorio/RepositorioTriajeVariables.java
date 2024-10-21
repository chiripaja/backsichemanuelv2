package gob.hrhvm.apirest.admision.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.admision.entidad.TriajeVariables;

@Repository
public interface RepositorioTriajeVariables extends JpaRepository<TriajeVariables,Integer>{
    @Query(value="exec ApiTriajeVariables ?1", nativeQuery=true)
    public List<TriajeVariables> findByIdAtencion(Integer idAtencion);

}
