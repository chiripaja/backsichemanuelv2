package gob.hrhvm.apirest.admision.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.admision.entidad.Repro;

@Repository
public interface RepositorioRepro extends JpaRepository<Repro, Integer>{
    public List<Repro> findByIdEspecialidad(Integer idEspecialidad);
    public List<Repro> findByServicio(String s);
    @Query(value="select distinct idmedico, Medico,idmedico as idprogramacion, '' as servicio, 0 as idespecialidad,'' as fecha from repro order by 2", nativeQuery=true)
    public List<Repro> findByMedico();
    public List<Repro> findByIdMedico(Integer idMedico);

}
