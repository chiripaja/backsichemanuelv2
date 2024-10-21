package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ReproDispone {
    @Id
    private Long id;
    private String hora;
}
