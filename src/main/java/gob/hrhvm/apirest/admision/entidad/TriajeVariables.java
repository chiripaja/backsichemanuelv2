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
@Table(name="TriajeValorNormal")
public class TriajeVariables {
    @Id private Integer idTriajeVariable;
    @Column private String TriajeVariable;
    @Column private String ValorNormalMinimo;
    @Column private String ValorNormalMaximo;
}
