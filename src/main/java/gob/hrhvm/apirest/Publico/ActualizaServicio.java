package gob.hrhvm.apirest.Publico;

import gob.hrhvm.apirest.Publico.entidad.ActualizarCupos;
import org.springframework.stereotype.Service;

@Service
public class ActualizaServicio {
    private final RepositorioActualizaCupo repo;

    public ActualizarCupos buscarEstado() {
        return this.repo.findByIdConfig(2);
    }

    public void resetCupos() {
        ActualizarCupos t = new ActualizarCupos();
        t.setIdConfig(2);
        t.setValor("0");
        this.repo.save(t);
    }

    public ActualizaServicio(final RepositorioActualizaCupo repo) {
        this.repo = repo;
    }
}
