package gob.hrhvm.apirest.totem.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TotemSis {
    @Id private String nroDocumento;
    @Basic
    private String apeMaterno;          private String apePaterno;
	private String contrato;            private String descEESS;       private String correlativo;
	private String descTipoSeguro;      private String disa;
	private String eESS;                private String estado;
	private String fecAfiliacion;       private String fecCaducidad;
	private String fecNacimiento;       private String genero;
	private String idGrupoPoblacional;  private String idNumReg;
	private String idPlan;  		    private String idUbigeo;
	private String nombres;     	    private String nroContrato;
	private String regimen;
	private String tabla;			    private Integer tipoDocumento;
	private String tipoFormato;         private String tipoSeguro;
}
