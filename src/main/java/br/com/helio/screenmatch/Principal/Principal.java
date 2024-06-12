package br.com.helio.screenmatch.Principal;

import java.util.Scanner;

import br.com.helio.screenmatch.model.DadosSerie;
import br.com.helio.screenmatch.service.ConsumoApi;
import br.com.helio.screenmatch.service.ConverteDados;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private  ConsumoApi consumo = new ConsumoApi();
    private  ConverteDados conversor = new ConverteDados();
    
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";

  public void exibeMenu() {

    System.out.println("Digete o nome da série para a busca:");
    var nomeSerie = leitura.nextLine();
    var json = consumo.obterDados(ENDERECO + nomeSerie.replace("", "+") + API_KEY);
	DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
	System.out.println(dados);

    leitura.close();

  }

}
