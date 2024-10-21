package gob.hrhvm.apirest.totem.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class TotemGuardarRpta {
    @Id private Integer exito;
    @Column private String mensaje;
    @Column private Integer idCuentaAtencion;
    @Column private String servicio;
    @Column private String horaIngreso;
    @Column private String tipoEmpleado; 
    @Column private String nombreMedico;
    @Column private String nroHistoriaClinica;
    @Column private String idAtencion;
    @Column private String nombrePaciente;
    @Column private String fuenteFinanciamiento;
    @Column private String fechaIngreso;
    @Column private String numCupo;
    @Column private String ordenPago;
}
