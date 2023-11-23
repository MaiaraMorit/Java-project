package com.firstProject.freight;

import com.firstProject.freight.calculate.DeliveryCostCalculator;
import com.firstProject.freight.cepApi.CepApi;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Solicite ao usuário que insira o CEP
    System.out.print("Digite o CEP: ");
    String cep = scanner.nextLine();

    // Utilize a classe CepApi para obter informações sobre o CEP
    String adress = CepApi.getAddressByCep(cep);

    // Exiba as informações do endereço
    System.out.println("Endereço: " + adress);

    // Solicite ao usuário que insira o peso do pacote
    System.out.print("Digite o peso do pacote em quilogramas: ");
    double peso = scanner.nextDouble();

    // Crie uma instância de DeliveryCostCalculator
    DeliveryCostCalculator calculator = new DeliveryCostCalculator();

    // Calcule o frete base
    double freteBase = calculator.calculateFreight(peso);

    // Verifique se o peso é maior que 5kg e aplique a taxa extra, se necessário
    double freteFinal = (peso > 5) ? freteBase * 1.15 : freteBase;

    // Exiba o resultado
    System.out.println("O custo do frete é: $" + freteFinal);

    // Feche o scanner
    scanner.close();
  }
}


