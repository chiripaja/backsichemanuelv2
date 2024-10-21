package gob.hrhvm.apirest.totem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import gob.hrhvm.apirest.Publico.entidad.Respuesta;

public interface RepositorioTotemPacienteGuardar extends JpaRepository<Respuesta,Integer> {
    @Query(value="exec ApiTotemPacienteGuardar ?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10", nativeQuery=true)
    public Respuesta pacienteGuardar(
        String ApeMaterno,
        String ApePaterno,
        String Direccion,
        String FechaNacimiento,
        String Nombres,
        String NroDocumento,
        String Sexo,
        String UbigeoResidencia,
        String LugarResidencia,
        String FechaEmision
    );
}
