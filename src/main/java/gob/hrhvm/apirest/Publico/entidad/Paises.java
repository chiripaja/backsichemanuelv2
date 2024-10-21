package gob.hrhvm.apirest.Publico.entidad;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name="Paises")
public class Paises {
    @Id private Integer idPais;
    @Basic private String nombre;
}
