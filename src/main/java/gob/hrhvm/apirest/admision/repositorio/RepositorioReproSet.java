package gob.hrhvm.apirest.admision.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.Publico.entidad.Respuesta;

@Repository
public interface RepositorioReproSet extends JpaRepository<Respuesta,Integer>{
  /*  @Query(value="exec reproo ?1,?2,?3,?4", nativeQuery=true) public Respuesta reproSet(Integer idProgramacion, String horaInicio, Integer idCuentaAtencion, Integer idUsuario);
    @Query(value="exec CitasEliminar ?1,?2", nativeQuery=true) public Respuesta supRegs(Integer id, Integer id2);
    @Query(value="exec paciente ?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12, ?13,?14,?15,?16,?17,?18,?19,?20,?21,?22,?23,?24, ?25", nativeQuery=true)
    public Respuesta paciente(
        String nroDocumento,        String primerNombre,        String apellidoPaterno,        String apellidoMaterno,
        String idDistritoNacimiento,        String fechaNacimiento,        String telefono,        String email,
        String madreDocumento,        String madreApellidoPaterno,        String madreApellidoMaterno,        String madrePrimerNombre,
        String IdDistritoDomicilio,        String IdDistritoProcedencia,        String IdEtnia,        String IdIdioma,        String IdGradoInstruccion,
        String IdEstadoCivil,        String IdProcedencia,        String IdTipoOcupacion,        String IdPaisDomicilio,        String IdPaisProcedencia,
        String IdPaisNacimiento, String IdDocIdentidad, String Foto
    );
    @Query(value="exec reprooo ?1,?2,?3", nativeQuery=true)
    public Respuesta repro(
        Integer idProgramacion, String fecha, Integer idMedico
    );*/
  @Query(
          value = "exec reproo ?1,?2,?3,?4",
          nativeQuery = true
  )
  Respuesta reproSet(Integer idProgramacion, String horaInicio, Integer idCuentaAtencion, Integer idUsuario);

    @Query(
            value = "exec CitasEliminar ?1,?2",
            nativeQuery = true
    )
    Respuesta supRegs(Integer id, Integer id2);

    @Query(
            value = "exec paciente ?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12, ?13,?14,?15,?16,?17,?18,?19,?20,?21,?22,?23,?24, ?25, ?26, ?27, ?28, ?29, ?30, ?31",
            nativeQuery = true
    )
    Respuesta paciente(String nroDocumento, String primerNombre, String segundoNombre, String tercerNombre, String apellidoPaterno, String apellidoMaterno, String idDistritoNacimiento, String fechaNacimiento, String telefono, String email, String madreDocumento, String madreApellidoPaterno, String madreApellidoMaterno, String madrePrimerNombre, String IdDistritoDomicilio, String IdDistritoProcedencia, String IdEtnia, String IdIdioma, String IdGradoInstruccion, String IdEstadoCivil, String IdProcedencia, String IdTipoOcupacion, String IdPaisDomicilio, String IdPaisProcedencia, String IdPaisNacimiento, String IdDocIdentidad, String madreTipoDocumento, String NroOrdenHijo, String IdTipoSexo, String Observacion, String Foto);

    @Query(
            value = "exec reprooo ?1,?2,?3",
            nativeQuery = true
    )
    Respuesta repro(Integer idProgramacion, String fecha, Integer idMedico);
}