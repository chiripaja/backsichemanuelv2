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
@Table(name="TriajeNacido")
public class TriajeNacido {
    @Id private Integer idAtencion;
    @Column private String apariencia;
    @Column private String circulatorio;
    @Column private String respiratorio;
}
