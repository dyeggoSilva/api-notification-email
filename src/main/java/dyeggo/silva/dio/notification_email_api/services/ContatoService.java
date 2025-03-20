package dyeggo.silva.dio.notification_email_api.services;

import dyeggo.silva.dio.notification_email_api.Exception.BlankFieldException;
import dyeggo.silva.dio.notification_email_api.domain.Contato;
import dyeggo.silva.dio.notification_email_api.dtos.ContatoDTO;
import dyeggo.silva.dio.notification_email_api.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContatoService {
    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    private EnvioEmailService envioEmailService;

    public String salvaContato(ContatoDTO data){

        Contato newContato = new Contato();

        if(data.nome().isBlank() == true || data.telefone().isBlank() == true || data.email().isBlank() == true || data.menssagem().isBlank() == true){
            throw new BlankFieldException();
        }else{
            newContato.setNome(data.nome());
            newContato.setEmail(data.email());
            newContato.setTelefone(data.telefone());
            newContato.setMenssagem(data.menssagem());
            contatoRepository.save(newContato);
            return envioEmailService.enviarEmailCliente(newContato.getEmail(), newContato.getNome(),newContato.getMenssagem());

        }




    }
    public List<Contato> listAll(){
        return contatoRepository.findAll();
    }

}
