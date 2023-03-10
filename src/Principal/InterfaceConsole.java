package Principal;
import BuscaMinas.BuscaMinas;

import java.util.Scanner;

public class InterfaceConsole {
    BuscaMinas juego = new BuscaMinas();

    /**
     * Funcion principal inicializadora
     * @param args No usados
     */
    public static void main(String[] args) {
        InterfaceConsole interfaz = new InterfaceConsole();
        interfaz.juegote(interfaz);
    }

    /**
     * Controlador principal del juego
     * @param interfaz Objeto interfaz con las funciones necesarias para funcionar
     */
    public void juegote(InterfaceConsole interfaz){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al Buscaminas");

        interfaz.juego.inicializarTablero();
        interfaz.juego.colocarMinas();
        interfaz.imprimirTablero();

        while (true) {
            System.out.print("Introduce la posicion ('fila columna' con un espacio): ");
            int fila = sc.nextInt() - 1;
            int columna = sc.nextInt() - 1;

            if (interfaz.juego.esMina(fila, columna)) {
                System.out.println("DIABLOSSSSSS... EXPLOTOOOOOUUUUU");
                interfaz.mostrarMinas();
                break;
            }

            interfaz.juego.descubrirCasilla(fila, columna);
            interfaz.imprimirTablero();

            if (interfaz.juego.esVictoria()) {
                System.out.println("Oleeeee LO HAS CONSEGUIDOOOO");
                break;
            }
        }

        sc.close();
    }

    /**
     * Funcion encargada de imprimir al usuario el tablero
     */
    public void imprimirTablero() {
        System.out.println("  | 1 2 3 4 5 6 7 8");
        System.out.println("--|----------------");

        for (int i = 0; i < 8; i++) {
            System.out.print((i + 1) + " | ");

            for (int j = 0; j < 8; j++) {
                if (juego.getDescubiertas()[i][j]) {
                    if (juego.getMinas()[i][j]) {
                        System.out.print("* ");
                    } else {
                        int minasCercanas = juego.contarMinasCercanas(i, j);
                        System.out.print(minasCercanas + " ");
                    }
                } else {
                    System.out.print(juego.getTablero()[i][j] + " ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }

    /**
     * En caso de perder mostrar donde estan las minas
     */
    private void mostrarMinas() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (juego.getMinas()[i][j]) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }
}
