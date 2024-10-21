package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class CuposLibres {
    @Id
    private Integer id;
    @Basic
    private Integer idProgramacion;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private Integer idServicio;
    private String nombreServicio;
    private Integer idEspecialidad;
    private String nombreEspecialidad;
    private String nombreMedico;
    //private String total_Citas ;
    private String cuposLibres;
}
