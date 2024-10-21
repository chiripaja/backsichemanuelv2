package gob.hrhvm.apirest.Publico.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ApiConfig")
public class ActualizarCupos {
    @Id private Integer idConfig;
    @Column private String valor;
}
