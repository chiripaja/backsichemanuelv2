package gob.hrhvm.apirest.usuario.entidad;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ApiEmpleados")
public class Empleados {
    @Id
    private Integer idEmpleado;
    @Column
    private String apellidoPaterno;
    @Column
    private String apellidoMaterno;
    @Column
    private String nombres;
    @Column
    private String dni;
    @Column
    private String tipoEmpleado;
    @Column
    private String condicionTrabajo;

    @OneToMany
    @JoinColumn(name="idEmpleadoRol", insertable = false, updatable = false)
    private List<EmpleadosRoles> roles;

}