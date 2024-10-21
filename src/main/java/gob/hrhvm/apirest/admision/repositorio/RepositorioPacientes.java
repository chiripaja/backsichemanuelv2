package gob.hrhvm.apirest.admision.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import gob.hrhvm.apirest.admision.entidad.Pacientes;

import java.util.Optional;

@Repository
public interface RepositorioPacientes extends JpaRepository <Pacientes, Integer> {

    Pacientes findByNroDocumento(String NroDocumento);

    @Query(value = "select * from pacientes where NroDocumento=?1 and IdDocIdentidad=?2", nativeQuery = true    )
    Optional<Pacientes> buscar(String n, Integer t);

}