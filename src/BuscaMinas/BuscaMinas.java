package BuscaMinas;

import java.util.Random;

public class BuscaMinas {
    private final int FILAS = 8;
    private final int COLUMNAS = 8;
    private final int MINAS = 10;

    public final char[][] tablero = new char[FILAS][COLUMNAS];
    public final boolean[][] minas = new boolean[FILAS][COLUMNAS];
    public final boolean[][] descubiertas = new boolean[FILAS][COLUMNAS];
    private final Random random = new Random();

    public void inicializarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = ' ';
                minas[i][j] = false;
                descubiertas[i][j] = false;
            }
        }
    }
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
    public boolean esMina(int fila, int columna) {
        return minas[fila][columna];
    }
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
