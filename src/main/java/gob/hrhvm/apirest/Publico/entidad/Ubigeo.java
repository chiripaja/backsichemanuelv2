package gob.hrhvm.apirest.Publico.entidad;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name="ApiUbigeo")
public class Ubigeo {
    @Id
    private Integer idDistrito;
    @Basic
    private String distrito;
    private Integer idProvincia;
    private String provincia;
    private Integer idDepartamento;
    private String departamento;
    private String descripcion;
    private Integer idReniec;

}
