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
    public JLabel lbl;

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

                for(int i = 0; i <= 12; i++) {
                    if((indice % 13) == i && i == 0) {
                        NombreCarta nombre = NombreCarta.values()[i + 12];
                        for(int j = 13; j <= 52; j+=13) {
                            if(indice <= j) {
                                Pinta pinta = Pinta.values()[(j/13) - 1];
                                JOptionPane.showMessageDialog(null, nombre +" de "+ pinta);
                                break;

                            }
                        }
                    } if((indice % 13) == i) {
                        NombreCarta nombre = NombreCarta.values()[i - 1];
                        for(int j = 13; j <= 52; j+=13) {
                            if(indice <= j) {
                                Pinta pinta = Pinta.values()[(j/13) - 1];
                                JOptionPane.showMessageDialog(null, nombre +" de "+ pinta);
                                break;
                            }
                        }
                    }

                }
            }

        });

        pnl.add(lbl);
    }

    public void verificar(JPanel pnl) {

        for(int i = 0; i <= 12; i++) {
            if((indice % 13) == i && i == 0) {
                NombreCarta nombre = NombreCarta.values()[i + 12];
                for(int j = 13; j <= 52; j+=13) {
                    if(indice <= j) {
                        Pinta pinta = Pinta.values()[(j/13) - 1];
                        JOptionPane.showMessageDialog(null, nombre+" de "+pinta);
                        break;

                    }
                }
            } if((indice % 13) == i && i != 0) {
                NombreCarta nombre = NombreCarta.values()[i - 1];
                for(int j = 13; j <= 52; j+=13) {
                    if(indice <= j) {
                        Pinta pinta = Pinta.values()[(j/13) - 1];
                        JOptionPane.showMessageDialog(null, nombre+" de "+pinta);
                        break;
                    }
                }
            }

        }
    }


}
