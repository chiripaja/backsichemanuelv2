package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="ApiReprogramacionAtencion")
public class ReproAtencion {
    @Id private Integer idCuentaAtencion;
    @Column private String dni;
    @Column private String paciente;
    @Column private String servicio;
    @Column private String usuario;
    @Column private String fechaIngreso;
    @Column private String tipoServicio;
    @Column private String fuenteFinanciamiento;
    @Column private Integer idEspecialidad;

}