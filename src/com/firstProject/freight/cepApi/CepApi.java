package com.firstProject.freight.cepApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CepApi {

  public static String getAddressByCep(String cep) {
    String apiUrl = "https://cep.awesomeapi.com.br/json/" + cep;
    HttpURLConnection connection = null;

    try {
      // Construa a URL da API com o CEP desejado
      URL url = new URL(apiUrl);

      // Abra a conexão HTTP
      connection = (HttpURLConnection) url.openConnection();

      // Configure o método HTTP
      connection.setRequestMethod("GET");

      // Leia a resposta
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
          response.append(line);
        }

        // Retorne as informações do endereço como uma String
        return response.toString();
      }
    } catch (IOException e) {
      e.printStackTrace();
      // Lide com erros de conexão ou resposta da API
      return null;
    } finally {
      // Feche a conexão manualmente no bloco finally
      if (connection != null) {
        connection.disconnect();
      }
    }
  }

  public static void main(String[] args) {
    // Crie um Scanner para ler a entrada do usuário
    Scanner scanner = new Scanner(System.in);

    // Solicite ao usuário que digite o CEP
    System.out.print("Digite o CEP: ");
    String cep = scanner.nextLine();

    // Obtenha as informações do endereço
    String adress = getAddressByCep(cep);

    // Exiba as informações do endereço
    System.out.println(adress);

    // Feche o Scanner
    scanner.close();
  }
}

