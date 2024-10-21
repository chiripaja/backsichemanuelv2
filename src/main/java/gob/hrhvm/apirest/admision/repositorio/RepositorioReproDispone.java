package gob.hrhvm.apirest.admision.repositorio;

import gob.hrhvm.apirest.admision.entidad.ReproDispone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioReproDispone extends JpaRepository<ReproDispone, Integer> {
    @Query(value = "exec reproCupoLibre ?1", nativeQuery = true )
    List<ReproDispone> buscar(Integer id);
}
