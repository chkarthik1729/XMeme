package crio.xmeme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("crio.xmeme.persist")
public class XMemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(XMemeApplication.class, args);
	}

}
