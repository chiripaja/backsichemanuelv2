package gob.hrhvm.apirest.admision.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import gob.hrhvm.apirest.admision.entidad.CuposLibres;

@Repository
public interface RepositorioCuposLibres extends JpaRepository <CuposLibres, Integer> {
    @Query(value="exec ApiRptCuposLibresDetalle", nativeQuery=true)
    public List<CuposLibres> cuposLibres();

}