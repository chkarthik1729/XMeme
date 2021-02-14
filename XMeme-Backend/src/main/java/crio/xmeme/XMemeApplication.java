package crio.xmeme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories("crio.xmeme.persist")
@EnableSwagger2
public class XMemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(XMemeApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/memes/**")
						.allowedOrigins("*")
						.allowedHeaders("GET", "POST", "PATCH", "DELETE")
						.allowedHeaders("*");
			}
		};
	}
}
