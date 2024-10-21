package gob.hrhvm.apirest.Publico;

import java.util.List;

import gob.hrhvm.apirest.Publico.entidad.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
public class PublicoServicio {
    private final RepositorioUbigeo reUb;
    private final RepositorioTiposDocumentos reTd;
    private final RepositorioPaises rePa;
    private final RepositorioActualizaCupo reAc;
    private final RepositorioMaestros reDi;

    public List<Ubigeo> buscarDistrito(String distrito) {
        return this.reUb.findByDistritoContaining(distrito);
    }

    public List<TiposDocumentos> listarDocumentos() {
        return this.reTd.findAll();
    }

    public List<Paises> listarPaises() {
        return this.rePa.findAll();
    }

    public ActualizarCupos buscarEstado() {
        return this.reAc.findByIdConfig(2);
    }

    public List<Maestros> listaDiccionario(String categoria) {
        return  this.reDi.findByCategoria(categoria);
    }

    public List<Ubigeo> idDistrito(Integer id) {
        return this.reUb.findByIdDistrito(id);
    }

    public List<Ubigeo> idDistrito2(Integer id) {
        return this.reUb.findByIdReniec(id);
    }

    public PublicoServicio(final RepositorioUbigeo reUb, final RepositorioTiposDocumentos reTd, final RepositorioPaises rePa, final RepositorioActualizaCupo reAc, final RepositorioMaestros reDi) {
        this.reUb = reUb;
        this.reTd = reTd;
        this.rePa = rePa;
        this.reAc = reAc;
        this.reDi = reDi;
    }
}
