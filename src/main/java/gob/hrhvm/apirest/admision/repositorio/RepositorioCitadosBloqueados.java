package gob.hrhvm.apirest.admision.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.hrhvm.apirest.admision.entidad.CitadosBloqueados;


@Repository
public interface RepositorioCitadosBloqueados extends JpaRepository<CitadosBloqueados, Integer>{

        List<CitadosBloqueados> findByIdProgramacion(Integer IdProgramacion);

        @Query(
                value = "select * from ApiAdmisionCitasBloqueos where cast(fecha as date)=?1 and idservicio=?2 order by HoraInicio",
                nativeQuery = true
        )
        List<CitadosBloqueados> listaCitas(String f, Integer id);

        @Query(
                value = "select * from ApiAdmisionCitasBloqueos where cast(fecha as date) between ?1 and ?2 order by HoraInicio",
                nativeQuery = true
        )
        List<CitadosBloqueados> listaCitas0(String d, String h);

        @Query(
                value = "select * from ApiAdmisionCitasBloqueos where ( cast(fecha as date) between ?1 and ?2 ) and idDepartamento=?3 order by HoraInicio",
                nativeQuery = true
        )
        List<CitadosBloqueados> listaCitas1(String d, String h, Integer de);

        @Query(
                value = "select * from ApiAdmisionCitasBloqueos where ( cast(fecha as date) between ?1 and ?2 ) and idDepartamento=?3 and idEspecialidad=?4 order by HoraInicio",
                nativeQuery = true
        )
        List<CitadosBloqueados> listaCitas2(String d, String h, Integer de, Integer es);

        @Query(
                value = "select * from ApiAdmisionCitasBloqueos where ( cast(fecha as date) between ?1 and ?2 ) and idDepartamento=?3 and idEspecialidad=?4 and idservicio=?5 order by HoraInicio",
                nativeQuery = true
        )
        List<CitadosBloqueados> listaCitas3(String d, String h, Integer de, Integer es, Integer se);}
