package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ApiAtencionesCE")
public class Triaje {
    @Id
    private Integer idAtencion;
    @Column
    private Integer idCuentaAtencion;
    @Column
    private String triajeEdad;
    @Column
    private String triajePresion;
    @Column
    private String triajeTalla;
    @Column
    private String triajeTemperatura;
    @Column
    private String triajePeso;
    @Column
    private String triajeFecha;
    @Column
    private Integer triajeIdUsuario;
    @Column
    private Integer triajePulso;
    @Column
    private Integer triajeFrecRespiratoria;
    @Column
    private String citaAntecedente;
    @Column
    private String triajePerimCefalico;
    @Column
    private Integer triajeFrecCardiaca;
    @Column
    private Integer triajeOrigen;
    @Column
    private Integer triajelatido;
    @Column
    private String triajeObservacion;
    @Column
    private String triajeCanal;
    @Column
    private Integer TriajeSaturacion;
    @Column
    private String triajePerimetro;

}
