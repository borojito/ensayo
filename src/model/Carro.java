package model;

public class Carro {
    
    private String marca;
    private String modelo;
    private int anio;
    private double valorComercial;
    private String cilindraje;
    private boolean usoPublico;

    public Carro() {}

    public Carro(String marca, String modelo, int anio, double valorComercial, String cilindraje, boolean usoPublico) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.valorComercial = valorComercial;
        this.cilindraje = cilindraje;
        this.usoPublico = usoPublico;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public double getValorComercial() { return valorComercial; }
    public void setValorComercial(double valorComercial) { this.valorComercial = valorComercial; }

    public String getCilindraje() { return cilindraje; }
    public void setCilindraje(String cilindraje) { this.cilindraje = cilindraje; }

    public boolean isUsoPublico() { return usoPublico; }
    public void setUsoPublico(boolean usoPublico) { this.usoPublico = usoPublico; }


}