import java.util.Random;

import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
import javax.swing.JButton;


public class Jugador {

    private int TOTAL_CARTAS = 10;
    private String Nombres = "";
    private String Pintas = "";
    private int MARGEN = 10;
    private int DISTANCIA = 40;
    private String mensaje = "";
    private JLabel lbl;


    private Carta[] cartas = new Carta[TOTAL_CARTAS];
    private NombreCarta[] nombres = NombreCarta.values();
    private Pinta[] pintas = Pinta.values();
    private String[] nc = new String[TOTAL_CARTAS];
    private String[] pi = new String[TOTAL_CARTAS];

    Random r = new Random();

    public void repartir() {
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl) {
        pnl.removeAll();
        int posicion = MARGEN + cartas.length * DISTANCIA;
        for (Carta c : cartas) {
            c.mostrar(pnl, posicion, MARGEN);
            posicion -= DISTANCIA;
        }
        pnl.repaint();
    }

    public void verificar(JPanel pnl) {
        for(Carta c : cartas) {
            c.verificar(pnl);
            pnl.repaint();
        }
    }

}
