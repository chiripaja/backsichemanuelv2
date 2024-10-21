package gob.hrhvm.apirest.admision.repositorio;

import gob.hrhvm.apirest.admision.entidad.Triaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTriajee extends JpaRepository<Triaje, Integer> {
    Triaje findByIdCuentaAtencion(Integer idAtencion);
    Triaje findByIdAtencion(Integer idAtencion);
}
