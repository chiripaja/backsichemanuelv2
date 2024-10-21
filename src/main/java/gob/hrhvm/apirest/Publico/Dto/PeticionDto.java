package gob.hrhvm.apirest.Publico.Dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class PeticionDto {
    private String ip;
    private String usuario;
    private String endPoint;
    private String fechaConsulta;
    private String tipoDocumento;
    private String numeroDocumento;

}
