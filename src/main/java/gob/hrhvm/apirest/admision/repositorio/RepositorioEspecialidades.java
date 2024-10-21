package gob.hrhvm.apirest.admision.repositorio;

import gob.hrhvm.apirest.admision.entidad.Especialidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEspecialidades extends JpaRepository<Especialidades, Integer> {
}
