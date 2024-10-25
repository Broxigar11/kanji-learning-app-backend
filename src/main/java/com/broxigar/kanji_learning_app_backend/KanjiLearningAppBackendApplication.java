package com.broxigar.kanji_learning_app_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class KanjiLearningAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KanjiLearningAppBackendApplication.class, args);
	}

}
