package gob.hrhvm.apirest.Publico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.Publico.entidad.ActualizarCupos;

@Repository
public interface RepositorioActualizaCupo extends JpaRepository<ActualizarCupos,Integer> {
    public ActualizarCupos findByIdConfig(Integer idConfig);
}
