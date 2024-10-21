package gob.hrhvm.apirest.Publico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.Publico.entidad.Paises;

@Repository
public interface RepositorioPaises extends JpaRepository<Paises,Integer>{
    
}
