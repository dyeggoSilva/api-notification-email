package dyeggo.silva.dio.notification_email_api.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Documentation") // Título da documentação
                        .version("1.0") // Versão da API
                        .description("Documentação da API usando Springdoc OpenAPI")); // Descrição
    }
}
