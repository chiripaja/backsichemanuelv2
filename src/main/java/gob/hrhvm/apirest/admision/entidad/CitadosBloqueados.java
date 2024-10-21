package gob.hrhvm.apirest.admision.entidad;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ApiAdmisionCitasBloqueos")
public class CitadosBloqueados {
    @Id private Integer idCita;
    
    @Column private Integer idProgramacion;
    @Column private String horaInicio;
    @Column private String horaFin;
    @Column private String paciente;
    @Column private Date FechaSolicitud;
    @Column private String horaSolicitud;
    @Column private String tipo;
    @Column private Integer idCuentaAtencion;
}
