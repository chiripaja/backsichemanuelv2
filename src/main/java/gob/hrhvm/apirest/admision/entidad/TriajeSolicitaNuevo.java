package gob.hrhvm.apirest.admision.entidad;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TriajeSolicitaNuevo {
    private Triaje triaje;
    private TriajeSolicitaAgregar triajeSolicita;
    private List<TriajeVariables> triajeVariables;
    private TriajeNacido triajeNacido;
    private TriajeGestante triajeGestante;
}
