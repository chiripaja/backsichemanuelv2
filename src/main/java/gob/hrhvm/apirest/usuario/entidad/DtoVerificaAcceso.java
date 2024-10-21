package gob.hrhvm.apirest.usuario.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;

@Entity
@Getter
@Setter
@Table(name="ApiResponse")
public class DtoVerificaAcceso {
    @Id
    public String exito;
    
    @Column
    public String mensaje;

    @OneToOne
    @JoinColumn(name="idEmpleado")
    private Empleados empleado;

}
