package gob.hrhvm.apirest.admision.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.admision.entidad.TriajeGestante;

@Repository
public interface RepositorioTriajeGestante extends JpaRepository<TriajeGestante, Integer> {
    
    @Query(value="select top(1) * from triajeGestante where idAtencion=?", nativeQuery=true)
    public TriajeGestante triajeId(Integer idAtencion);
}
