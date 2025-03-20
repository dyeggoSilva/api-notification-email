package dyeggo.silva.dio.notification_email_api;

import dyeggo.silva.dio.notification_email_api.Exception.BlankFieldException;
import dyeggo.silva.dio.notification_email_api.domain.Contato;
import dyeggo.silva.dio.notification_email_api.dtos.ContatoDTO;
import dyeggo.silva.dio.notification_email_api.repository.ContatoRepository;
import dyeggo.silva.dio.notification_email_api.services.ContatoService;
import dyeggo.silva.dio.notification_email_api.services.EnvioEmailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class NotificationEmailApiApplicationTests {

	@InjectMocks
	private ContatoService contatoService;
	@Mock
	private EnvioEmailService emailAdmService;
	@Mock
	private ContatoRepository contatoRepository;
	@Test
	@DisplayName("Deve retornar apenas um usuário")
	public void deveRetornarUmaListaDeContatos() {
		Contato contato = new Contato(1,"dyeggo","Dyeggo@mail.com","12345678","test");

		Mockito.when(contatoRepository.findAll()).thenReturn(Collections.singletonList(contato));
		List<Contato> contatos = contatoService.listAll();
		Assertions.assertEquals(1,contatos.size());
	}



	@Test
	@DisplayName("Deve lançar uma exceção quando faltar um dado ")
	public void deveLancarExcecaoQuandoFaltarUmDado(){

		ContatoDTO contato = new ContatoDTO("dyeggo","dyeggo@mail.com","","test");
		Assertions.assertThrows(BlankFieldException.class,() -> contatoService.salvaContato(contato));

	}

}
