package dyeggo.silva.dio.notification_email_api.controler;

import dyeggo.silva.dio.notification_email_api.dtos.FeedbackDTO;
import dyeggo.silva.dio.notification_email_api.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;
    @PostMapping("/contato/feedback")
    public Object cadastroFeedback(@RequestBody FeedbackDTO data){

        return feedbackService.salvaFeedback(data) ;
    }
}
