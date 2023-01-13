package br.com.cubo.filmesapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "CRUD de Filmes",
				version = "1.0.0",
				description = "Projeto de Exercício de Spring Boot"
		)
)
public class FilmesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmesApiApplication.class, args);
	}

}
