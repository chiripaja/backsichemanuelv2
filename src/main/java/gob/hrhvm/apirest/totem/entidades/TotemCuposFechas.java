package gob.hrhvm.apirest.totem.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
@Getter
@Entity
@Table(name="ApiTotemCuposFecha")
public class TotemCuposFechas {
    @Id private Integer id;
    @Column private String desde;
    @Column private String hasta;
}
