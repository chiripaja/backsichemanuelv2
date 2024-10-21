package gob.hrhvm.apirest.totem.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.totem.entidades.TotemCuposLibres;

@Repository
public interface RepositorioTotemCuposLibres extends JpaRepository<TotemCuposLibres, Integer>{
    @Query(value="exec ApiTotemCuposLibres ?1", nativeQuery = true)
    public List<TotemCuposLibres> cuposLibres(Integer idDepartamento);
}
