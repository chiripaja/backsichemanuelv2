package gob.hrhvm.apirest.totem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gob.hrhvm.apirest.totem.entidades.TotemPacienteBuscar;

public interface RepositorioTotemPacienteBuscar extends JpaRepository<TotemPacienteBuscar,Integer>{
    @Query(value = "exec ApiTotemPacienteBuscar ?1,?2", nativeQuery = true )
    TotemPacienteBuscar buscarDni(String Dni, Integer tipo);
}
