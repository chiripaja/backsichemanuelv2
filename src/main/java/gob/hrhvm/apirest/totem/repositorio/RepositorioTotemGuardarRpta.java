package gob.hrhvm.apirest.totem.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.totem.entidades.TotemGuardarRpta;
@Repository
public interface RepositorioTotemGuardarRpta extends JpaRepository<TotemGuardarRpta,Integer> {
    @Query(value="exec ApiTotemGuardar ?1,?2,?3,?4,?5", nativeQuery = true)
    public TotemGuardarRpta guardar(
    Integer idPaciente,
	Integer idEspecialidad,
	Integer idIafa,
	String referenciaCodigo,
	String referenciaNumero
    );
}
