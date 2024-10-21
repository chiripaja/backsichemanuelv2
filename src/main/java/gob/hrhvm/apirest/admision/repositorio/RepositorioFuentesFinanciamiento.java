package gob.hrhvm.apirest.admision.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.admision.entidad.FuentesFinanciamiento;

@Repository
public interface RepositorioFuentesFinanciamiento extends JpaRepository<FuentesFinanciamiento, Integer> {

}
