package esprit.tn.bensassiadel4ssa15.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("bensassiadel4ssa15 API")
                        .description("API REST de gestion de parc automobile (location de véhicules) - ESPRIT 4SSA15")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Adel Bensassi")
                                .email("adelbensassi2601@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8805")
                                .description("Serveur de développement")));
    }
}
