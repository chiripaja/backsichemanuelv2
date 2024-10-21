package gob.hrhvm.apirest.Publico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.Publico.entidad.Ubigeo;

@Repository
public interface RepositorioUbigeo extends  JpaRepository<Ubigeo,Integer>{

    List<Ubigeo> findByDistritoContaining(String distrito);

    List<Ubigeo> findByIdDistrito(Integer idDistrito);

    List<Ubigeo> findByIdReniec(Integer idReniec);
}
