package gob.hrhvm.apirest.Publico.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Diccionario")
public class Maestros {
    @Id
    private Integer id;
    @Column
    private String categoria;
    @Column
    private String nombre;

}
