package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class TriajeSolicitaAgregar {
    @Id private Integer exito;
    @Column private String mensaje;
    @Column private Integer idAtencion;
    @Column private String nroHistoria;
    @Column private String paterno;
    @Column private String materno;
    @Column private String nombres;
    @Column private Integer edad;
    @Column private String tipoEdad;
    @Column private String iafa;
    @Column private String fechaIngreso;
    @Column private String tipoServicio;
    @Column private String estado;
    @Column private String servicio;

    @OneToOne
    @JoinColumn(name="idAtencion", insertable = false, updatable = false)
    private Triaje triaje;
}