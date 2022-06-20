package io.github.kruzuzdyak.page_number_reducer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userServiceApi() {
        return GroupedOpenApi.builder()
                .group("page-number-reducer")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi(@Value("${app.description}") String appDescription,
                                 @Value("${app.version}") String appVersion,
                                 @Value("${app.server.url}") String serverUrl,
                                 @Value("${app.server.stage}") String stage) {
        return new OpenAPI()
                .info(new Info().title("Page reducer API")
                        .version(appVersion)
                        .description(appDescription))
                .servers(List.of(new Server()
                        .url(serverUrl)
                        .description(stage)));
    }
}
