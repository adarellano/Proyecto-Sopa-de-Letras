import java.util.HashSet;
import java.util.Set;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: Annabella Mendoza
 */

/**
 * La clase Diccionario representa un conjunto de palabras.
 * Las palabras se almacenan en un HashSet para permitir la inserción y búsqueda en tiempo constante.
 */
public class Diccionario {
    private Set<String> palabras;

    /**
     * Constructor para la clase Diccionario.
     * Inicializa el HashSet de palabras.
     */
    public Diccionario(String nombreArchivo) {
        this.palabras = new HashSet<>();
        cargarDiccionario(nombreArchivo);
    }

    /**
     * Agrega una palabra al diccionario.
     * @param palabra La palabra a agregar.
     */
    public void agregarPalabra(String palabra) {
        palabras.add(palabra);
    }

    /**
     * Verifica si una palabra está en el diccionario.
     * @param palabra La palabra a verificar.
     * @return true si la palabra está en el diccionario, false en caso contrario.
     */
    public boolean contienePalabra(String palabra) {
        return palabras.contains(palabra);
    }
    /**
     * Guarda el diccionario en un archivo.
     * @param nombreArchivo El nombre del archivo en el que se guardará el diccionario.
     */
    public void guardarDiccionario(String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
            for (String palabra : palabras) {
                writer.println(palabra);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga el diccionario desde un archivo.
     * @param nombreArchivo El nombre del archivo desde el que se cargará el diccionario.
     */
    private void cargarDiccionario(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                palabras.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}