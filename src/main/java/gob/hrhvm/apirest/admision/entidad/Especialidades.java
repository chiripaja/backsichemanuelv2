package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Especialidades {
    @Id private Integer idEspecialidad;
    @Column private String Nombre;
    @Column private Integer idDepartamento;
    @Column private String tiempoPromedioAtencion;
}
