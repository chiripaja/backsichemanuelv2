package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="repro")
public class Repro {
    @Id private Integer idProgramacion;
    @Column private Integer idEspecialidad;
    @Column private String fecha;
    @Column private Integer idMedico;
    @Column private String medico;
    @Column private String servicio;
}
