package gob.hrhvm.apirest.totem.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import gob.hrhvm.apirest.totem.entidades.TotemEstablecimientos;

public interface RepositorioTotemEstablecimientos extends JpaRepository<TotemEstablecimientos, Integer> {
    @Query(value="select IdEstablecimiento, Codigo, nombre from ApiTotemEstablecimientos where codigo=?1",nativeQuery=true)
    public List<TotemEstablecimientos> buscarCodigo(String codigo);

    @Query(value="select IdEstablecimiento, Codigo, nombre from ApiTotemEstablecimientos where nombre like %?1%",nativeQuery=true)
    public List<TotemEstablecimientos> buscarNombre(String nombre);

    @Query(value="select IdEstablecimiento, Codigo, nombre from ApiTotemEstablecimientos order by nombre",nativeQuery=true)
    public List<TotemEstablecimientos> listarTodo();
}