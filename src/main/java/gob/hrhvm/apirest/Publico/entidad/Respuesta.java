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
@Table(name="ApiRespuesta")
public class Respuesta {
    @Id private Integer exito;
    @Column private String mensaje;
    @Column private String dato1;
    @Column private String dato2;
}
