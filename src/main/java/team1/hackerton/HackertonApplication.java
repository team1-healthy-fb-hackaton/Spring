package team1.hackerton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HackertonApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackertonApplication.class, args);
	}

}
