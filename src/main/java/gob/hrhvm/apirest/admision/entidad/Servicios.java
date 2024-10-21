package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ApiServicios")
public class Servicios {
    @Id private String IdServicio;
    @Column private String IdEspecialidad;
    @Column private String Servicio;
    @Column private String Especialidad;
    @Column private String idDepartamento;
    @Column private String TiempoPromedioAtencion;
}
