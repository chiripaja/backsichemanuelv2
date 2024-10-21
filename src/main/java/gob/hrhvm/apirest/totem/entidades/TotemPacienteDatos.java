package gob.hrhvm.apirest.totem.entidades;

import gob.hrhvm.apirest.Publico.Dto.DtoApiSis;
import gob.hrhvm.apirest.Publico.entidad.Respuesta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotemPacienteDatos {
    TotemPacienteBuscar paciente;
    DtoApiSis sis;
    Respuesta sisRpta;
}
