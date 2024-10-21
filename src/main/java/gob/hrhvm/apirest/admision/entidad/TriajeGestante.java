package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TriajeGestante")

public class TriajeGestante {
    @Id private Integer idAtencion;
    @Column private String alturaUterina;
    @Column private String frecCardiaca;
    @Column private String edadGestacional;
    @Column private String fechaParto;
}
