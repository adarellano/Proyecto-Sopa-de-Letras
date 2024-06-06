import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Annabella Mendoza
 */

/**
 * La clase Tablero representa un tablero de letras.
 * El tablero se almacena en una matriz de caracteres y se utiliza para buscar palabras.
 */
public class Tablero {
    private char[][] tablero;
    private boolean[][] visitado;
    private LinkedList<String> palabras;

    public boolean[][] getVisitado() {
        return visitado;
    }
    /**
     * Constructor para la clase Tablero.
     * Inicializa el tablero y la matriz de visitados.
     * @param tablero La matriz de caracteres que representa el tablero.
     */
    public Tablero(String nombreArchivo) {
        cargarPalabras(nombreArchivo);
        // Inicializa tablero y visitado según el número de palabras
        int size = (int) Math.ceil(Math.sqrt(palabras.size()));
        tablero = new char[size][size];
        visitado = new boolean[size][size];
        // Llena el tablero con las palabras
        for (int i = 0; i < palabras.size(); i++) {
            String palabra = palabras.get(i);
            for (int j = 0; j < palabra.length(); j++) {
                tablero[i][j] = palabra.charAt(j);
            }
        }
    }

    /**
     * Obtiene la letra en una posición del tablero.
     * @param x La coordenada x de la posición.
     * @param y La coordenada y de la posición.
     * @return La letra en la posición (x, y).
     */
    private void cargarPalabras(String nombreArchivo) {
        palabras = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                palabras.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** (Este método puede ser útil en la implementación de los algoritmos de búsqueda dfs y bfs. 
     * Estos algoritmos a menudo necesitan verificar si dos nodos (en este caso, posiciones en el tablero) son adyacentes.)
     * Verifica si una posición está dentro de los límites del tablero.
     * @param x La coordenada x de la posición.
     * @param y La coordenada y de la posición.
     * @return true si la posición está dentro del tablero, false en caso contrario.
     */
    public boolean esAdyacente(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);
        return dx <= 1 && dy <= 1 && !(dx == 0 && dy == 0);
    }

    /**
     * Verifica si una posición está dentro de los límites del tablero.
     * @param x La coordenada x de la posición.
     * @param y La coordenada y de la posición.
     * @return true si la posición está dentro del tablero, false en caso contrario.
     */
    public List<Integer> obtenerVecinos(int x, int y) {
        List<Integer> vecinos = new LinkedList<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = x + dx, ny = y + dy;

                if (nx >= 0 && nx < tablero.length && ny >= 0 && ny < tablero[0].length && !visitado[nx][ny]) {
                    vecinos.add(nx * tablero[0].length + ny);
                }
            }
        }
        return vecinos;
    }
    /**
     * Obtiene el número de filas del tablero.
     * @return El número de filas.
     */
    public int getNumFilas() {
        return tablero.length;
    }

    /**
     * Obtiene el número de columnas del tablero.
     * @return El número de columnas.
     */
    public int getNumColumnas() {
        return tablero[0].length;
    }
}