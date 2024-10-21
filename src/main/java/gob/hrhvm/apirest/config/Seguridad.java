package gob.hrhvm.apirest.config;


/* 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
*/

public class Seguridad {
/*
    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        return httpSecurity
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/publico/test").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(basic -> basic.disable())
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                        .maximumSessions(3)
                        .expiredUrl("/login")
                        .and()
                        .sessionFixation()
                        .migrateSession())
                .build();

                
                //.httpBasic(basic -> basic.disable())
                //.formLogin(login -> login
                //       .successHandler(autenticacionOk())
                //       .permitAll())
                
    }

    public AuthenticationSuccessHandler autenticacionOk(){
        return ((request, response, authentication)->{
            response.sendRedirect("/Publico/Swagger");
        });
    }

    */
}
