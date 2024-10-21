package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Medico {
    @Id
    private Integer idMedicoEspecialidad;
    @Column
    private Integer idEspecialidad;
    @Column
    private Integer idMedico;
    @Column
    private String especialidad;
    @Column
    private String medico;
}
