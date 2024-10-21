package gob.hrhvm.apirest.Publico.entidad;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name="TiposDocIdentidad")
public class TiposDocumentos {
    @Id private Integer idDocIdentidad;
    @Basic private String descripcion;
    private Integer codigoSIS;
}
