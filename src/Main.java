import controller.CarroController;
import model.Carro;
import model.CalculadoraImpuesto;
import view.CalculadoraView;

import javax.swing.SwingUtilities;


public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        
            Carro modelo = new Carro();
            CalculadoraImpuesto calculadora = new CalculadoraImpuesto();
            CalculadoraView vista = new CalculadoraView();
            
            CarroController controller = new CarroController();

            vista.setVisible(true);
        });
    }
}