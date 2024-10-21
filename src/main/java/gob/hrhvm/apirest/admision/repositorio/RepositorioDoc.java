package gob.hrhvm.apirest.admision.repositorio;

import gob.hrhvm.apirest.admision.entidad.TiposDocIdentidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDoc extends JpaRepository<TiposDocIdentidad, Integer> {
}

