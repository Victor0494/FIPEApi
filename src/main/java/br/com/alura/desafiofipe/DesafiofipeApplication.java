package br.com.alura.desafiofipe;

import br.com.alura.desafiofipe.service.Impl.MenuService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafiofipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafiofipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MenuService menuService = new MenuService();

		menuService.menu();
	}
}
