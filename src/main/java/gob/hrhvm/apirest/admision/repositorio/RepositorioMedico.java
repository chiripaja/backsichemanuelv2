package gob.hrhvm.apirest.admision.repositorio;

import gob.hrhvm.apirest.admision.entidad.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioMedico extends JpaRepository<Medico, Integer> {
    List<Medico> findByIdEspecialidad(Integer idEspecialidad);
}