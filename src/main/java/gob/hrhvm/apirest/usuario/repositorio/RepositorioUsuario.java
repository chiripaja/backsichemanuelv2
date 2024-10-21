package gob.hrhvm.apirest.usuario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.usuario.entidad.DtoVerificaAcceso;

@Repository
public interface RepositorioUsuario extends JpaRepository <DtoVerificaAcceso, String> {
    
    @Query(value="exec ApiVerificaLogin ?1, ?2", nativeQuery=true)
    public DtoVerificaAcceso verificaAcceso(String usuario, String clave);   
}