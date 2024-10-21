package gob.hrhvm.apirest.Publico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import gob.hrhvm.apirest.Publico.Dto.Mensajes;

@EnableScheduling
@Controller
public class WsControlador {
    @Autowired
    private SimpMessagingTemplate template;
    private final ActualizaServicio sv;

    public WsControlador(ActualizaServicio sv) {
        this.sv = sv;
    }

    @MessageMapping({"/send"})
    @SendTo({"/Actualiza/Cupos"})
    public Mensajes envio(Mensajes m) {
        return new Mensajes(m.nombre(), m.contenido());
    }

    @Scheduled(
            fixedRate = 5000L
    )
    public void greeting() throws InterruptedException {
        if (this.sv.buscarEstado().getValor().equals("1")) {

            this.template.convertAndSend("/Actualiza/Cupos", new Mensajes("Update", "True"));
            Thread.sleep(1000L);
            this.sv.resetCupos();
            System.out.println("True");
        } else {
            this.template.convertAndSend("/Actualiza/Cupos", new Mensajes("Update", "False"));
            System.out.println("False");
        }

    }

}