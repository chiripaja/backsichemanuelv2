package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name="ApiTicketAdmision")
public class Ticket {
    @Id private Integer idCuentaAtencion;
    @Basic 
    private String servicio;
    private String horaIngreso;
    private String tipoEmpleado; 
    private String nombreMedico;
    private String nroHistoriaClinica;
    private Integer idAtencion;
    private String nombrePaciente;
    private String fuenteFinanciamiento;
    private String fechaIngreso;
    private String ordenPago;
}
