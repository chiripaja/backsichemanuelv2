package gob.hrhvm.apirest.totem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gob.hrhvm.apirest.Publico.entidad.Respuesta;

public interface RepositorioTotemSis extends JpaRepository<Respuesta,Integer>{
    @Query(value="exec ApiTotemSisGuardar ?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17, ?18, ?19, ?20, ?21, ?22, ?23, ?24, ?25", nativeQuery=true)
    public Respuesta sisGuardar(
        String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8, String p9, String p10,
        String p11, String p12, String p13, String p14, String p15, String p16, String p17, String p18, String p19, String p20,
        String p21, String p22, String p23, String p24, String p25
    );
}
