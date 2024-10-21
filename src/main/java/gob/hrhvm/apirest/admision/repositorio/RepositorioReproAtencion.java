package gob.hrhvm.apirest.admision.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.admision.entidad.ReproAtencion;

@Repository
public interface RepositorioReproAtencion extends JpaRepository<ReproAtencion,Integer>{
    public Optional<ReproAtencion> findByIdCuentaAtencion(Integer idCuentaAtencion);
}
