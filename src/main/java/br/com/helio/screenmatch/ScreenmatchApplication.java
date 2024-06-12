package br.com.helio.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.helio.screenmatch.model.DadosSerie;
import br.com.helio.screenmatch.service.ConsumoApi;
import br.com.helio.screenmatch.service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@SpringBootApplication
public class MyCommandLineRunner implements CommandLineRunner {
   
   @Override
    public void run(String... args) throws Exception {
       var  consumoApi = new ConsumoApi();
	   var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c"
	   );
	   System.out.println(json);

	   ConverteDados conversor = new ConverteDados();
	   DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
	   System.out.println(dados);
    }
}


}
