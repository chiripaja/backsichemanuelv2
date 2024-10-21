package gob.hrhvm.apirest.admision.entidad;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="DepartamentosHospital")
public class Departamentos {
    @Id private Integer idDepartamento;
    @Column private String nombre;
    @Column private String totem;

    @OneToMany
    @JoinColumn(name="idDepartamento", insertable = false, updatable = false)
    private List<Especialidades> especialidades;
}
