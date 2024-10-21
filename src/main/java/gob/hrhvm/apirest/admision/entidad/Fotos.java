package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Fotos {
    @Id private Integer idPaciente;
    @Column private String foto;
    @Column private String fecha;
    @Column private String mes;
}
