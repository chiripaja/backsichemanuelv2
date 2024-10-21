package gob.hrhvm.apirest.admision.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.admision.entidad.AdmisionGuardarRpta;

@Repository
public interface RepositorioAdmision extends JpaRepository<AdmisionGuardarRpta,Integer>{
    @Query(value="exec ApiAdmisionGuardar ?1,?2,?3,?4,?5,?6,?7", nativeQuery = true)
    public AdmisionGuardarRpta admisionWebGuardar(
    Integer idPaciente,
	Integer idProgramacion,
	Integer idIafa,
	String referenciaCodigo,
	String referenciaNumero,
    Integer esAdicional,
	Integer idUsuario
    );
}
