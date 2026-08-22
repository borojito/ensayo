package view;

import controller.CarroController;
import model.Carro;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class CalculadoraView extends JFrame {

    private static final Color COLOR_FONDO = new Color(245, 235, 217);
    private static final Color COLOR_CAFE  = new Color(109, 74, 46);
    private static final Color COLOR_TEXTO = new Color(66, 45, 30);

    private final CarroController controller;

    private JTextField campoMarca;
    private JTextField campoModelo;
    private JTextField campoAnio;
    private JTextField campoValorComercial;
    private JTextField campoCilindraje;
    private JCheckBox checkUsoPublico;
    private JLabel labelResultado;

    public CalculadoraView(CarroController controller) {
        this.controller = controller;
        configurarVentana();
        construirFormulario();
    }

    private void configurarVentana() {
        setTitle("Calculadora de Impuestos de Vehículos");
        setSize(380, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(COLOR_FONDO);
    }

    private void construirFormulario() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 8, 8));
        panel.setBackground(COLOR_FONDO);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 24, 20, 24));

        campoMarca = new JTextField();
        campoModelo = new JTextField();
        campoAnio = new JTextField();
        campoValorComercial = new JTextField();
        campoCilindraje = new JTextField();
        checkUsoPublico = new JCheckBox("Uso público");
        checkUsoPublico.setBackground(COLOR_FONDO);
        checkUsoPublico.setForeground(COLOR_TEXTO);

        panel.add(crearEtiqueta("Marca"));
        panel.add(campoMarca);
        panel.add(crearEtiqueta("Modelo"));
        panel.add(campoModelo);
        panel.add(crearEtiqueta("Año"));
        panel.add(campoAnio);
        panel.add(crearEtiqueta("Valor comercial (COP)"));
        panel.add(campoValorComercial);
        panel.add(crearEtiqueta("Cilindraje"));
        panel.add(campoCilindraje);
        panel.add(checkUsoPublico);

        JButton botonCalcular = new JButton("Calcular Impuesto");
        botonCalcular.setBackground(COLOR_CAFE);
        botonCalcular.setForeground(Color.WHITE);
        botonCalcular.setFocusPainted(false);
        botonCalcular.setOpaque(true);
        botonCalcular.setBorderPainted(false);
        botonCalcular.addActionListener(e -> calcularImpuesto());
        panel.add(botonCalcular);

        labelResultado = new JLabel(" ");
        labelResultado.setForeground(COLOR_TEXTO);
        labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelResultado);

        add(panel);
    }

    private JLabel crearEtiqueta(String texto) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setForeground(COLOR_CAFE);
        return etiqueta;
    }

    private void calcularImpuesto() {
        try {
            Carro carro = new Carro(
                    campoMarca.getText(),
                    campoModelo.getText(),
                    Integer.parseInt(campoAnio.getText().trim()),
                    Double.parseDouble(campoValorComercial.getText().trim()),
                    campoCilindraje.getText(),
                    checkUsoPublico.isSelected()
            );

            double impuesto = controller.calcularImpuesto(carro);
            String descripcion = controller.obtenerDescripcionTarifa(carro);

            NumberFormat formato = NumberFormat.getNumberInstance(Locale.of("es", "CO"));
            labelResultado.setText("<html><center>Impuesto: $" + formato.format(impuesto)
                    + " COP<br>" + descripcion + "</center></html>");
        } catch (NumberFormatException ex) {
            labelResultado.setText("Revisa que año y valor comercial sean números válidos.");
        }
    }
}
