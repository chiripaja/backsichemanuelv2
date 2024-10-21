package gob.hrhvm.apirest.admision.entidad;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="atenciones")
public class Atenciones {
    @Id
    @Column(name="idatencion")
    private Integer IdAtencion;

   @Column(name="idcuentaatencion")
    private Integer IdCuentaAtencion;
}
