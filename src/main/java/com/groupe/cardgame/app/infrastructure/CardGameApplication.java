package com.groupe.cardgame.app.infrastructure;

import com.groupe.cardgame.app.infrastructure.springboot.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import({AppConfig.class})
@SpringBootApplication(scanBasePackages = "com.groupe.cardgame.app")
public class CardGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardGameApplication.class, args);
	}

}