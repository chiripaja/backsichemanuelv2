package gob.hrhvm.apirest.totem.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class TotemPacienteBuscar {
    @Id private Integer idPaciente;
    @Column private Integer exito;
    @Column private String mensaje;
    @Column private String apenom;
    @Column private Integer edad;
    @Column private String sexo;
}
