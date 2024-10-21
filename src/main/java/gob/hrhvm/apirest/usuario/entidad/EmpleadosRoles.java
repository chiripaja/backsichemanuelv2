package gob.hrhvm.apirest.usuario.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ApiEmpleadosRoles")
public class EmpleadosRoles {
    @Id private Integer idUsuarioRol;
    @Column private Integer idEmpleadoRol;
    @Column private Integer idRol;
    @Column private String nombre;    
}