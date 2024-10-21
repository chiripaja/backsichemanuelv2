package gob.hrhvm.apirest.admision.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import gob.hrhvm.apirest.admision.entidad.TriajeSolicitaAgregar;

public interface RepositorioTriaje extends JpaRepository<TriajeSolicitaAgregar,Integer>{
    @Query(value="exec ApiTriajeSolicitaAgregar ?1", nativeQuery=true)
    public TriajeSolicitaAgregar triajeSolicitaAgregar(Integer idAtencion);
}


