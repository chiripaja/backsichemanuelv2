package gob.hrhvm.apirest.admision.repositorio;

import gob.hrhvm.apirest.admision.entidad.Atenciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtencionRepository extends JpaRepository<Atenciones,Integer> {
  //  Atenciones atencion = findByIdAtencion()
  @Query("Select A from Atenciones A where A.IdCuentaAtencion=?1"  )
   Optional<Atenciones> findAtenciones(Integer id);
}
