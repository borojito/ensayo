package model;

public class CalculadoraImpuesto {

    private static final double limiteBajo = 54_057_000; // Valor comercial en pesos colombianos
    private static final double limiteMedio = 121_635_000; // Valor comercial en pesos colombianos

    private static final double tarifaBaja = 0.015; // 1.5% tarifa para valor comercial hasta $54.057.000 COP
    private static final double tarifaMedia = 0.025; // 2.5% tarifa para valor comercial entre $54.057.001 y $121.635.000 COP
    private static final double tarifaAlta = 0.035; // 3.5% tarifa para valor comercial mayor a $121.635.000 COP

    private static final double descuentoPublico = 0.20; // 20% de descuento para vehículos de uso público

    public double calcularImpuesto(Carro carro) {
        double tarifa = obtenerTarifa(carro.getValorComercial());
        double impuesto = carro.getValorComercial() * tarifa;

        if (carro.isUsoPublico()) {
            impuesto -= impuesto * descuentoPublico;
        }

        return impuesto;
    }

    private double obtenerTarifa(double valorComercial) {
        if (valorComercial <= limiteBajo) {
            return tarifaBaja;
        } else if (valorComercial <= limiteMedio) {
            return tarifaMedia;
        } else {
            return tarifaAlta;
        }
    }

    public String getDescripcionTarifa(double valorComercial) {
        if (valorComercial <= limiteBajo) {
            return "La tarifa es del 1.5% para valor comercial hasta $54.057.000 COP";
        } else if (valorComercial <= limiteMedio) {
            return "La tarifa es del 2.5% para valor comercial entre $54.057.001 y $121.635.000 COP";
        } else {
            return "La tarifa es del 3.5% para valor comercial mayor a $121.635.000 COP";
        }
    }
}
// Tarifas de impuesto para carros según Ley 488 de 1998 de Colombia
