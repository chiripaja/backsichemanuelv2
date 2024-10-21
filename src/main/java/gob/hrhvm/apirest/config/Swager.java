package gob.hrhvm.apirest.config;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
@OpenAPIDefinition

public class Swager {

    public OpenAPI api(){
        return new OpenAPI();
    }
}
