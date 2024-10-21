package gob.hrhvm.apirest.totem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.totem.entidades.TotemCuposFechas;

@Repository
public interface RepositorioTotemCuposFechas extends JpaRepository<TotemCuposFechas,Integer>{
    
}
