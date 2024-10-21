package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TriajeNormal {
    private Integer idAtencion;
    private String triajePulso;
	private String triajeTemperatura;
	private Integer presionSist;
	private Integer presionDiast;
	private String triajeFrecCardiaca;
	private String triajePerimetro;
	private String triajeFrecRespiratoria;
	private String triajePeso;
	private String triajeTalla;
	private String triajePerimCefalico;
	private String triajeSaturacion;
	private Integer triajeIdUsuario;
	private String observaciones;
	
	@OneToOne
    @JoinColumn(name="idAtencion", insertable = false, updatable = false)
    private TriajeGestante gestante;

    @OneToOne
    @JoinColumn(name="idAtencion", insertable = false, updatable = false)
    private TriajeNacido nacido;

}
