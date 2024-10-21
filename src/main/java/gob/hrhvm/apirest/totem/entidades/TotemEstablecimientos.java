package gob.hrhvm.apirest.totem.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name="Establecimientos")
public class TotemEstablecimientos {
    @Id private Integer idEstablecimiento;
    @Column private String codigo;
    @Column private String nombre;
}
