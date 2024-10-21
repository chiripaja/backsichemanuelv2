package gob.hrhvm.apirest.usuario;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gob.hrhvm.apirest.usuario.entidad.DtoSolicitaAcceso;
import gob.hrhvm.apirest.usuario.entidad.DtoVerificaAcceso;
import gob.hrhvm.apirest.usuario.entidad.EmpleadosRoles;
import gob.hrhvm.apirest.usuario.servicio.ServicioUsuario;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Usuario")
public class ControladorUsuario {
    private final ServicioUsuario sv;

    @Operation(summary = "Valida acceso al SIHCE", description = "Enviar clave encriptada con SHA1")
    @PostMapping("/VerificaAcceso")
    public DtoVerificaAcceso verificaAcceso(@RequestBody DtoSolicitaAcceso p) {
      return sv.verificaAcceso(p);
    }
    
    @Operation(summary = "Lista roles segun Id Empleado", description = "select * from ApiEmpleadosRoles")
    @GetMapping("/Roles/{idEmpleado}")
    public List<EmpleadosRoles> getRolesPorIdEmpleado(@PathVariable Integer idEmpleado) {
        return sv.getRolesPorIdEmpleado(idEmpleado);
    }
    
    
}
