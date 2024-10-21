package gob.hrhvm.apirest.totem.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name="ApiTotemEspecialidades")
public class TotemEspecialidades {
    @Id private Integer idEspecialidad;
    @Column private String Nombre;
    @Column private Integer idDepartamento;
    @Column private String tiempoPromedioAtencion;
}
