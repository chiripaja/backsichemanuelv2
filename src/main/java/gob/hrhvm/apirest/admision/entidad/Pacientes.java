package gob.hrhvm.apirest.admision.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pacientes{
    @Id private Integer IdPaciente;
    @Column private String ApellidoPaterno;
    @Column private String ApellidoMaterno;
    @Column private String PrimerNombre;
    @Column private String SegundoNombre;
    @Column private String TercerNombre;
    @Column private String FechaNacimiento;
    @Column private String nroDocumento;
    @Column private String Telefono;
    @Column private String DireccionDomicilio;
    @Column private String Autogenerado;
    @Column private String NombrePadre;
    @Column private String NombreMadre;
    @Column private String NroHistoriaClinica;
    @Column private String Observacion;
    @Column private String Email;
    @Column private String madreDocumento;
    @Column private String madreApellidoPaterno;
    @Column private String madreApellidoMaterno;
    @Column private String madrePrimerNombre;
    @Column private String madreSegundoNombre;
    @Column private String NroOrdenHijo;
    @Column private String madreTipoDocumento;
    
    @Column private String IdDistritoNacimiento;
    @Column private String IdDistritoDomicilio;
    @Column private String IdDistritoProcedencia;
    @Column private String IdEtnia;
    @Column private String IdIdioma;
    @Column private String IdGradoInstruccion;
    @Column private String IdEstadoCivil;
    @Column private String IdProcedencia;
    @Column private String IdTipoOcupacion;
    @Column private String IdPaisDomicilio;
    @Column private String IdPaisProcedencia;
    @Column private String IdPaisNacimiento;
    @Column private String IdTipoSexo;
    @Column private String IdDocIdentidad;

    @OneToOne
    @JoinColumn(name="idPaciente", insertable = false, updatable = false)
    private Fotos foto;


    /* 
    @Column private String IdCentroPobladoNacimiento;
    @Column private String IdCentroPobladoDomicilio;
    @Column private String IdTipoNumeracion;
    @Column private String IdCentroPobladoProcedencia;
    @Column private String IdDistritoProcedencia;
    @Column private String IdDistritoDomicilio;
    @Column private String IdDistritoNacimiento;
    @Column private String FichaFamiliar;
    @Column private String GrupoSanguineo;
    @Column private String FactorRh;
    @Column private String UsoWebReniec;
    @Column private String Sector;
    @Column private String Sectorista;
    */
}