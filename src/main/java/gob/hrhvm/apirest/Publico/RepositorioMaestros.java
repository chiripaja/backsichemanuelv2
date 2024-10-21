package gob.hrhvm.apirest.Publico;

import gob.hrhvm.apirest.Publico.entidad.Maestros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioMaestros extends JpaRepository<Maestros,Long> {
    List<Maestros> findByCategoria(String categoria);
}
