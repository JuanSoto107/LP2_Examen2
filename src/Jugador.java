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

    public String getEscalacolor() { //Obtiene si existe un conjunto de 5 cartas o mas con el misma pinta

        String color = "No tienes escala de color";
        int[] contpinta = new int[Pinta.values().length];

        for(Carta c : cartas) {
            contpinta[c.getpinta().ordinal()]++;
        }

        int i = 0;
        for(int p : contpinta) {

            if(p >= 5) {
                color = "Escala de color: \n";
                color += Grupo.values()[p] +" de "+ Pinta.values()[i] +"\n";

            }
            i++;
        }

        return color;
    }

    public String getPoker() { //Obtiene si existe una combinacion de cuatro cartas del mismo numero en la baraja

        String poker = "No tienes poker";
        int[] contnombre = new int[NombreCarta.values().length];

        for(Carta c : cartas) {
            contnombre[c.getnombre().ordinal()]++;
        }

        int i = 0;
        for(int c : contnombre) {
            if(c == 4) {
                poker = "Poker de: \n";
                poker += NombreCarta.values()[i];
            }
            i++;
        }

        return poker;


    }

    public String getPuntaje() {

        String puntaje = "No";

        int[] contnombre = new int[NombreCarta.values().length];

        for(Carta c : cartas) {
            contnombre[c.getnombre().ordinal()]++;
        }

        int[] total = new int[contnombre.length];


        for(Carta c : cartas) {
            if(c.getnombre().ordinal() == 0) {
                total[0] = 10;
            }
            for(int j = 9; j <= 12;) {
                if(c.getnombre().ordinal() == j) {
                    total[j] = 10;
                }
                j++;
            }
            for(int j = 1; j <= 8;) {
                if(c.getnombre().ordinal() == j) {
                    total[j] = j + 1;
                }
                j++;
            }
        }

        int i = 0;
        for(int c : contnombre) {
            total[i] *= c;
            i++;
        }

        int puntuacion = 0;

        for(int d = 0; d < total.length; d++) {

            puntuacion += total[d];
        }

        puntaje = "Puntuacion del jugador: \n";
        puntaje += String.valueOf(puntuacion);


        return puntaje;

    }

}
