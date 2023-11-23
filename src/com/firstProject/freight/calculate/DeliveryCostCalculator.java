package com.firstProject.freight.calculate;

public class DeliveryCostCalculator {

  // Método para calcular o frete com base no peso
  public double calculateFreight(double peso) {
    // Suponha uma taxa fixa por quilo
    double taxaPorQuilo = 2.0;

    // Aplica uma taxa extra se o peso for maior que 5 kg
    if (peso > 5) {
      double taxaExtra = 0.15; // 15% de taxa extra
      return peso * (taxaPorQuilo + taxaPorQuilo * taxaExtra);
    } else {
      return peso * taxaPorQuilo;
    }
  }
}

