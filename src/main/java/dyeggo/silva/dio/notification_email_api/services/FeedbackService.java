package dyeggo.silva.dio.notification_email_api.services;

import dyeggo.silva.dio.notification_email_api.domain.Feedback;
import dyeggo.silva.dio.notification_email_api.dtos.FeedbackDTO;
import dyeggo.silva.dio.notification_email_api.repository.FeedbackRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepositoty feedbackRepositoty;
    @Autowired
    EnvioEmailService envioEmailService;

    public String salvaFeedback(FeedbackDTO data) {
        Feedback newFeedback = new Feedback();

        newFeedback.setNome(data.nome());
        newFeedback.setEmail(data.email());
        newFeedback.setTelefone(data.telefone());
        newFeedback.setVagaConcorrida(data.vagaConcorrida());
        newFeedback.setEmpresa(data.empresa());
        newFeedback.setFeedback(data.feedback());
        feedbackRepositoty.save(newFeedback);
        return envioEmailService.enviarEmailClienteFeedback(newFeedback.getEmail(),
                newFeedback.getNome(), newFeedback.getFeedback());
    }
}
