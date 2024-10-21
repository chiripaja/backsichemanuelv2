package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
@Getter
@Entity
@Table(name="ApiAdmisionTiposFinanciamiento")
public class TiposFinanciamiento {
    @Id private Integer idTipoFinanciamiento;
    @Column private Integer idFuenteFinanciamiento;
    @Column private String descripcion;
}
