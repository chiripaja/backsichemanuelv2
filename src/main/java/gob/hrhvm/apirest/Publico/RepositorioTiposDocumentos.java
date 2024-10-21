package gob.hrhvm.apirest.Publico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.Publico.entidad.TiposDocumentos;

@Repository
public interface RepositorioTiposDocumentos extends JpaRepository<TiposDocumentos, Integer>{
    public TiposDocumentos findByIdDocIdentidad(Integer idDocIdentidad);
}
