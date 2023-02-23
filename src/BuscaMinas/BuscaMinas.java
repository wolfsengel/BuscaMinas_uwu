package BuscaMinas;

import java.util.Random;

public class BuscaMinas {
    private final int FILAS = 8;
    private final int COLUMNAS = 8;
    private final int MINAS = 10;

    private final char[][] tablero = new char[FILAS][COLUMNAS];
    private final boolean[][] minas = new boolean[FILAS][COLUMNAS];
    private final boolean[][] descubiertas = new boolean[FILAS][COLUMNAS];
    private final Random random = new Random();

    /**
     * Esta funcion accede a las posiciones descubiertas del tablero
     * @return boolean array del tablero
     */
    public boolean[][] getDescubiertas() {
        return descubiertas;
    }
    /**
     * Esta funcion accede a las minas
     * @return boolean array del tablero
     */
    public boolean[][] getMinas() {
        return minas;
    }
    /**
     * Esta funcion genera el mapeo del tablero
     * @return char array del tablero
     */
    public char[][] getTablero() {
        return tablero;
    }

    /**
     * Funcion encargada de crear un tablero completamente en blanco, todavía sin minas y con todas
     * las descubiertas a false y las minas a false tambien
     */
    public void inicializarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = ' ';
                minas[i][j] = false;
                descubiertas[i][j] = false;
            }
        }
    }

    /**
     * Esta funcion genera aleatoriamente la posicion de las minas y las redefine como true
     */
    public void colocarMinas() {
        int minasColocadas = 0;

        while (minasColocadas < MINAS) {
            int fila = random.nextInt(FILAS);
            int columna = random.nextInt(COLUMNAS);

            if (!minas[fila][columna]) {
                minas[fila][columna] = true;
                minasColocadas++;
            }
        }
    }

    /**
     * Funcion que comprueba el estado de una posicion concreta para saber si hay minas
     * @param fila Fila del tablero
     * @param columna Columna del tablero
     * @return Boolean acorde a si hay mina o no
     */
    public boolean esMina(int fila, int columna) {
        return minas[fila][columna];
    }

    /**
     * Funcion encargada de descubrir una casilla en concreto y las adyacentes si asi procediese.
     * Tambien comprueba si hay mina.
     * @param fila Fila del tablero
     * @param columna Columna del tablero
     */
    public void descubrirCasilla(int fila, int columna) {
        if (!descubiertas[fila][columna]) {
            descubiertas[fila][columna] = true;

            if (minas[fila][columna]) {
                return;
            }

            if (contarMinasCercanas(fila, columna) == 0) {
                for (int i = Math.max(fila - 1, 0); i <= Math.min(fila + 1, FILAS - 1); i++) {
                    for (int j = Math.max(columna - 1, 0); j <= Math.min(columna + 1, COLUMNAS - 1); j++) {
                        if (i != fila || j != columna) {
                            descubrirCasilla(i, j);
                        }
                    }
                }
            }
        }
    }

    /**
     * Funcion encargada de generar el numero de minas cercanas para la informacion del usuario
     * @param fila Fila del tablero
     * @param columna Columna del tablero
     * @return numero entero derivado del numero cercano de minas en una posicion
     */
    public int contarMinasCercanas(int fila, int columna) {
        int minasCercanas = 0;

        for (int i = Math.max(fila - 1, 0); i <= Math.min(fila + 1, FILAS - 1); i++) {
            for (int j = Math.max(columna - 1, 0); j <= Math.min(columna + 1, COLUMNAS - 1); j++) {
                if (minas[i][j]) {
                    minasCercanas++;
                }
            }
        }

        return minasCercanas;
    }

    /**
     * Funcion encargada de determinar o no la victoria
     * @return Boolean acorde a si se gana o no
     */
    public boolean esVictoria() {
        int casillasRestantes = FILAS * COLUMNAS - MINAS;

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (descubiertas[i][j]) {
                    casillasRestantes--;
                }
            }
        }

        return casillasRestantes == 0;
    }
}
