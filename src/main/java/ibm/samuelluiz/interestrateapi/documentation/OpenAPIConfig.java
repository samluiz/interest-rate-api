package ibm.samuelluiz.interestrateapi.documentation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI config() {
        return new OpenAPI()
                .info(new Info().title("Taxa de juros mensal API")
                        .description("API que lê, salva, remove e apresenta dados das taxas de juros de operações de " +
                                "crédito por instituicao financeira, buscando diretamente do catálogo de dados abertos do " +
                                "sistema financeiro nacional (DASFN) do Banco Central do Brasil.")
                        .version("v0.0.1"));

    }
}
