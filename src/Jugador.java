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
    private int MARGEN = 10;
    private int DISTANCIA = 40;



    private Carta[] cartas = new Carta[TOTAL_CARTAS];

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

    public String getGrupos() {

        String mensaje = "No se encontraron grupos";
        int[] contnombre = new int[NombreCarta.values().length];

        for(Carta c : cartas) {
            contnombre[c.getnombre().ordinal()]++; //Esto funciona como acumulador, toma las 12 posiciones de NombreCarta como longitud
            //Funciona que en cada posicion y por cada nombre este toma un valor inicial de 0
        }

        //Si al ir por cada carta y al tomar su nombre, encuentra que se repite, entonces este acumula la cantidad en esa posicion en +1
        boolean hayGrupos = false;

        for(int c : contnombre) {
            if(c >= 2) {
                hayGrupos = true;

                break;

            }
        }

        if(hayGrupos) {

            mensaje = "A continuacion los siguiente grupos:\n";
            int p = 0;
            for(int c : contnombre) {
                if(c >= 2) {
                    mensaje += Grupo.values()[c] + " de " + NombreCarta.values()[p] + "\n";
                }
                p++;
            }

        }

        

        return mensaje;
    }

    public String getEscalareal() {

        String manos = "No tienes escala real";
        int[] contnombre = new int[NombreCarta.values().length];
        int[] contpinta = new int[Pinta.values().length];

        for(Carta c : cartas) {
            contnombre[c.getnombre().ordinal()]++;
        }

        int i = 0;
        for(int c : contnombre) {
            if(c == 1 && contnombre[i] >= 10) {
                manos = "Escalera real: \n";
                manos += NombreCarta.values()[i];

            }
            if(i == 0) {
                if(c == 1) {
                    manos += NombreCarta.values()[i];
                    break;
    
                }
            }
            i++;
        }

        return manos;
    }

    public String getEscalacolor() {

        String manos1 = "No tienes escala de color";
        int[] contnombre = new int[NombreCarta.values().length];
        int[] contpinta = new int[Pinta.values().length];

        for(Carta c : cartas) {
            contnombre[c.getnombre().ordinal()]++;
            contpinta[c.getpinta().ordinal()]++;
        }

        int i = 0;
        for(int p : contpinta) {

            if(p >= 5) {
                manos1 = "Escala de color: \n";
                manos1 += Constantes.values()[p] +" de "+ Pinta.values()[i] +"\n";

            }
            i++;
        }

        return manos1;
    }

    public String getPoker() {

        String manos2 = "No tienes poker";
        int[] contnombre = new int[NombreCarta.values().length];
        int[] contpinta = new int[Pinta.values().length];

        for(Carta c : cartas) {
            contnombre[c.getnombre().ordinal()]++;
        }

        int i = 0;
        for(int c : contnombre) {
            if(c == 4) {
                manos2 = "Poker de: \n";
                manos2 += NombreCarta.values()[i];
            }
            i++;
        }

        return manos2;


    }


}
