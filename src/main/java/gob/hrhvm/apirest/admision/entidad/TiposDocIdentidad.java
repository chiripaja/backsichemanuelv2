package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TiposDocIdentidad {
    @Id
    private Integer idDocIdentidad;
    private String descripcion;
    private String codigoSUNASA;
    private String codigoHIS;
    private String codigoSIS;

}
