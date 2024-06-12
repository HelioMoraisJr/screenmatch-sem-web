package br.com.helio.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.helio.screenmatch.Principal.Principal;


@SpringBootApplication
public class ScreenmatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@SpringBootApplication
public class MyCommandLineRunner implements CommandLineRunner {
   
   @Override
    public void run(String... args) throws Exception {
		Principal principal =  new Principal();
		principal.exibeMenu();  
    }
}
}
