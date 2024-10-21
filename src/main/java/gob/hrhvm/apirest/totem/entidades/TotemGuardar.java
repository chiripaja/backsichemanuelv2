package gob.hrhvm.apirest.totem.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class TotemGuardar {
    @Id private Integer idPaciente;
	@Column private Integer idEspecialidad;
	@Column private Integer idIafa;
	@Column private String referenciaCodigo;
	@Column private String referenciaNumero;
}
