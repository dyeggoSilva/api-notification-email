package dyeggo.silva.dio.notification_email_api.controler;

import dyeggo.silva.dio.notification_email_api.dtos.ContatoDTO;
import dyeggo.silva.dio.notification_email_api.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContatoController {

    @Autowired
    ContatoService contatoService;
    @PostMapping("/contato/add")
    public Object cadastroCurso(@RequestBody ContatoDTO data){
        return contatoService.salvaContato(data);
    }

    @GetMapping("/ok")
    public String Statos(){
        return "conexão ok!";
    }
}
