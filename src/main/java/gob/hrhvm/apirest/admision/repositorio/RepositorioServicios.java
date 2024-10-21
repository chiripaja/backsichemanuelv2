package gob.hrhvm.apirest.admision.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import gob.hrhvm.apirest.admision.entidad.Servicios;
import java.util.List;


@Repository
public interface RepositorioServicios extends JpaRepository<Servicios,String> {
    List<Servicios> findByIdDepartamento(String idDepartamento);

    @Query( value = "select IdServicio, nombre as servicio, 0 idEspecialidad, 0 especialidad, 0 idDepartamento,0 tiempoPromedioAtencion from Servicios where IdEspecialidad=?",  nativeQuery = true
    )
    List<Servicios> servicios(Integer id);}
