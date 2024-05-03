package team1.hackerton.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "해커톤 team1 명세서",
                description = "healthy f&b 해커톤 api 명세서",
                version = "v1"))
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi team1() {
        String[] paths = {"/"};

        return GroupedOpenApi.builder()
                .group("team1")
                .pathsToMatch(paths)
                .build();
    }
}
