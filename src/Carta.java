import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

public class Carta {

    private int indice;
    private JLabel lbl;
    private NombreCarta n;
    private Pinta p;



    // metodo constructor
    public Carta(Random r) {
        // se genera un valor entre 1 y 52
        indice = r.nextInt(52) + 1;
    }

    public void mostrar(JPanel pnl, int x, int y) {
        String nombreArchivo = "/Imagenes/CARTA" + indice + ".jpg";
        ImageIcon imgCarta=new ImageIcon(getClass().getResource(nombreArchivo));

        lbl=new JLabel();
        lbl.setIcon(imgCarta);
        lbl.setBounds(x, y, imgCarta.getIconWidth(), imgCarta.getIconHeight());

        

        lbl.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, getnombre() + " de " + getpinta());
            }

        });

        pnl.add(lbl);
    }


    public NombreCarta getnombre() {
        int residuo = indice % 13;
        if(residuo == 0) {
            residuo = 13;
        }

        return NombreCarta.values()[residuo - 1];
    }

    public Pinta getpinta() {
        if(indice <= 13) {
            return Pinta.TREBOL;
        } else if(indice <= 26) {
            return Pinta.PICA;
        } else if(indice <= 39) {
            return Pinta.CORAZONES;
        } else {
            return Pinta.DIAMANTES;
        }

    }


}
