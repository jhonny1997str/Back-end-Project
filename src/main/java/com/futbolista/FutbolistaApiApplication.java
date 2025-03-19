package com.futbolista;

import io.github.cdimascio.dotenv.Dotenv;
import org.jfree.util.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FutbolistaApiApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		// Cargar las variables de entorno en el sistema
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		System.setProperty("SERVER_PORT", dotenv.get("SERVER_PORT"));
		SpringApplication.run(FutbolistaApiApplication.class, args);
		Log.info("Carga completa, sigamos trabajando!!");
	}



}
