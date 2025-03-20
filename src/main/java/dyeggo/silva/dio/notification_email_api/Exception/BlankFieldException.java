package dyeggo.silva.dio.notification_email_api.Exception;

public class BlankFieldException extends RuntimeException{
    public BlankFieldException(){super("preencha todos os campos!");};
    public BlankFieldException(String msg){super(msg);};
}
