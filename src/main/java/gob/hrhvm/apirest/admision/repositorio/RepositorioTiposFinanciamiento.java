package gob.hrhvm.apirest.admision.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.admision.entidad.TiposFinanciamiento;
@Repository
public interface RepositorioTiposFinanciamiento extends JpaRepository<TiposFinanciamiento, Integer>{
    public List<TiposFinanciamiento> findByIdFuenteFinanciamiento(Integer idFuenteFinanciamiento);
}
