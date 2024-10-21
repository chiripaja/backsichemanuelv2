package gob.hrhvm.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.Security;

@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ApirestApplication.class, args);

		String disabledAlgorithms = Security.getProperty("jdk.tls.disabledAlgorithms");
		disabledAlgorithms = disabledAlgorithms.replace("TLSv1, TLSv1.1,", "");
		Security.setProperty("jdk.tls.disabledAlgorithms", disabledAlgorithms);
		SpringApplication.run(ApirestApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(new String[]{"*"}).allowedMethods(new String[]{"*"}).allowedHeaders(new String[]{"*"});
			}
		};

	}

}

// "http://192.168.13.175", "http://192.168.13.134:5500", "http://192.168.13.26", ""