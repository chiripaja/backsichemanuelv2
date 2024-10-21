package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name="ApiAdmisionFuentes")
public class FuentesFinanciamiento {
@Id private Integer idFuenteFinanciamiento;
@Column private String descripcion;
}
