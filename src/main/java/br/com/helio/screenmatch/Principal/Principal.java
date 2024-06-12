package br.com.helio.screenmatch.Principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.helio.screenmatch.model.DadosSerie;
import br.com.helio.screenmatch.model.DadosTemporadas;
import br.com.helio.screenmatch.service.ConsumoApi;
import br.com.helio.screenmatch.service.ConverteDados;

public class Principal {

    private  Scanner leitura = new Scanner(System.in);
    private  ConsumoApi consumo = new ConsumoApi();
    private  ConverteDados conversor = new ConverteDados();
    
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";

  public void exibeMenu() {

    System.out.println("Digete o nome da série para a busca:");
    var nomeSerie = leitura.nextLine();
    leitura.close();
    var json = consumo.obterDados(ENDERECO + nomeSerie.replace("", "+") + API_KEY);
	  DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
	  System.out.println(dados);

    
    List<DadosTemporadas> temporadas = new ArrayList<>();
        
   for(int i = 1; i<=dados.totalTemporadas(); i++) {
           json = consumo.obterDados (ENDERECO + nomeSerie.replace("", "+") +"&season=" + i + API_KEY);
           DadosTemporadas dadosTemporada = conversor.obterDados(json, DadosTemporadas.class);
           temporadas.add(dadosTemporada);

   }
   temporadas.forEach(System.out::println);
   
  }

  
}
