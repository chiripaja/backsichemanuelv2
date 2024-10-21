package gob.hrhvm.apirest.admision.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.admision.entidad.Ticket;

@Repository
public interface RepositorioTicket extends JpaRepository<Ticket, Integer> {
    public Optional<Ticket> findByIdCuentaAtencion(Integer idCuentaAtencio);
}
