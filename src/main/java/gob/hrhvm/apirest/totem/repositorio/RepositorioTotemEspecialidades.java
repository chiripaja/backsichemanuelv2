package gob.hrhvm.apirest.totem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.totem.entidades.TotemEspecialidades;
import java.util.List;

@Repository
public interface RepositorioTotemEspecialidades extends JpaRepository<TotemEspecialidades,Integer>{
    @Query(value="exec ApiTotemEspecialidades ?1",nativeQuery=true)
    public List<TotemEspecialidades> listaPorId(Integer Id);
}
