package gob.hrhvm.apirest.admision.entidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class AdmisionGuardar {
    @Id private Integer idPaciente;
	@Column private Integer idProgramacion;
	@Column private Integer idIafa;
	@Column private String referenciaCodigo;
	@Column private String referenciaNumero;
	@Column private Integer esAdicional;
	@Column private Integer idUsuario;
}
