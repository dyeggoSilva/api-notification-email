package dyeggo.silva.dio.notification_email_api.services;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class EnvioEmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    private String remetente = "dyeggo0102@gmail.com";
    private String assunto = "DY Technology - EMAIL DE CONFIRMAÇÃO";


    //função criada para enviar um email de notificação para o ADM
    private String enviarEmailADM(String nome, String mensagem){

        String mensagemEmail = nome +" acabou de mandar uma mensagem para você"+ "\n \n" +"mensagem:"+ "\n \n" +mensagem;

        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setSubject("NOVA MENSAGEM NO PORTFÓLIO");
            simpleMailMessage.setTo(remetente);
            simpleMailMessage.setText(mensagemEmail);
            javaMailSender.send(simpleMailMessage);
            return "Email enviado.";
        }catch (Exception e){
            return "erro ao enviar o email.";
        }
    }

    //função criada para enviar um email de notificação para o cliente
    public String enviarEmailCliente(String destinatario, String nome,String mensagemCliente){

        String[] primeitoNomeArray = nome.split(" ");
        String primeitoNome = primeitoNomeArray[0];
        try{

            MimeMessage mensagem = javaMailSender.createMimeMessage();
            MimeMessageHelper help = new MimeMessageHelper(mensagem,true);
            help.setFrom(remetente);
            help.setSubject(assunto);
            help.setTo(destinatario);

            String template = carregarTemplate();

            template = template.replace("#{nome}", primeitoNome);
            help.setText(template,true);
            javaMailSender.send(mensagem);

            enviarEmailADM(primeitoNome,mensagemCliente);

            return "ok";

        }catch (Exception e){
            return "erro ao enviar";

        }

    }


    public String enviarEmailClienteFeedback(String destinatario, String nome,String mensagemCliente){

        String[] primeitoNomeArray = nome.split(" ");
        String primeitoNome = primeitoNomeArray[0];
        try{

            MimeMessage mensagem = javaMailSender.createMimeMessage();
            MimeMessageHelper help = new MimeMessageHelper(mensagem,true);
            help.setFrom(remetente);
            help.setSubject(assunto);
            help.setTo(destinatario);

            String template = carregarTemplateFeedback();

            template = template.replace("#{nome}", primeitoNome);
            help.setText(template,true);
            javaMailSender.send(mensagem);

            enviarEmailADM(primeitoNome,mensagemCliente);

            return "ok";

        }catch (Exception e){
            return "erro ao enviar";

        }

    }

    public String carregarTemplate() throws IOException {
        ClassPathResource resource = new ClassPathResource("email.html");


        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }

    public String carregarTemplateFeedback() throws IOException {
        ClassPathResource resource = new ClassPathResource("emailFeedback.html");


        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
