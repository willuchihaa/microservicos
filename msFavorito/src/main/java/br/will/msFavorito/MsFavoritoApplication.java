package br.will.msFavorito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication //(exclude= {SecurityAutoConfiguration.class})
public class MsFavoritoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFavoritoApplication.class, args);
	}

}
