package gob.hrhvm.apirest.usuario.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class DtoSolicitaAcceso {
    @Id
    public String usuario;
    @Column
    public String clave;
}
