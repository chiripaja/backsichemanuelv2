package gob.hrhvm.apirest.admision.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.admision.entidad.TriajeNacido;

@Repository
public interface RepositorioTriajeNacido extends JpaRepository<TriajeNacido, Integer>{
    @Query(value="select top(1) * from triajeNacido where idAtencion=?", nativeQuery=true)
    public TriajeNacido triajeId(Integer idAtencion);
}
