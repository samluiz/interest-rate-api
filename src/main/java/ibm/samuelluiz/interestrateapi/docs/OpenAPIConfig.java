package ibm.samuelluiz.interestrateapi.docs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class OpenAPIConfig {

    private Environment env;

    @Autowired
    public OpenAPIConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public OpenAPI config() {
        return new OpenAPI()
                .addServersItem(new Server().url("/api"))
                .info(new Info()
                        .title(env.getProperty("app-name"))
                        .description("API que faz a leitura, salva, remove e apresenta dados das taxas de juros de operaçoes de\n" +
                                "credito por instituicao financeira, buscando diretamente do catalogo de dados abertos do\n" +
                                "sistema financeiro nacional (DASFN) do Banco Central do Brasil.")
                        .version(env.getProperty("app-version")))
                .components(new Components()
                        .addSecuritySchemes("basicScheme",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")));

    }
}
