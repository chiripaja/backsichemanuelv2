package gob.hrhvm.apirest.totem.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class TotemCuposLibres {
    @Id private Integer id;
    @Basic
    private Integer IdDepartamento;
    private String Departamento;
    private Integer IdEspecialidad;
    private String Especialidad;
    private Integer CuposLibres;
}
