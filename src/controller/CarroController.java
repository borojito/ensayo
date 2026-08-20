package controller;

import model.Carro;
import model.CalculadoraImpuesto;

public class CarroController {

    private CalculadoraImpuesto calculadora;

    public CarroController() {
        this.calculadora = new CalculadoraImpuesto();
    }

    public double calcularImpuesto(Carro carro) {
        return calculadora.calcularImpuesto(carro);
    }

    public String obtenerDescripcionTarifa(Carro carro) {
        String descripcion = calculadora.getDescripcionTarifa(carro.getValorComercial());

        if (carro.isUsoPublico()) {
            descripcion += " (con descuento del 20% por uso público)";
        }

        return descripcion;
    }
}
