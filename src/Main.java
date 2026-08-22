import controller.CarroController;
import view.CalculadoraView;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            CarroController controller = new CarroController();
            CalculadoraView vista = new CalculadoraView(controller);

            vista.setVisible(true);
        });
    }
}
