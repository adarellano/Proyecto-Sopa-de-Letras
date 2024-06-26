/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 * @Author: Annabella Mendoza
 */

import java.util.LinkedList;
import java.util.List;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * La clase Diccionario representa un diccionario de palabras.
 * El diccionario se almacena en una lista de palabras y se utiliza para buscar palabras en el tablero.
 */
public class Diccionario {
    private List<String> palabras;

    /**
     * Constructor para la clase Diccionario.
     * Inicializa la lista de palabras.
     */
    public Diccionario(String nombreArchivo) {
    this.palabras = new LinkedList<>();
    File file = new File(nombreArchivo);
    if (!file.exists()) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
     * @param palabra La palabra a buscar.
     * @return true si la palabra está en el diccionario, false en caso contrario.
     */
    public boolean contienePalabra(String palabra) {
        return palabras.contains(palabra);
    }

    /**
     * Guarda el diccionario en un archivo.
     * @param nombreArchivo El nombre del archivo donde se guardará el diccionario.
     */
    public void guardarDiccionario(String path) throws IOException { 
        try (PrintWriter writer = new PrintWriter(path)) {
            for (String palabra : palabras) {
                writer.println(palabra);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga el diccionario desde un archivo.
     * @param nombreArchivo El nombre del archivo donde se encuentra el diccionario.
     */
    public void cargarDiccionario(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                palabras.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca una palabra en el diccionario utilizando un algoritmo de búsqueda en anchura (BFS).
     * @param palabra La palabra a buscar.
     * @return El tiempo en nanosegundos que tardó en encontrar la palabra.
     */
    public long buscarPalabraDFS(String tablero, String palabra, List<String> palabrasEncontradas) {
        long startTime = System.nanoTime();
        for (String p : palabras) {
            if (p.equals(palabra)) {
                palabrasEncontradas.add(p);
                return System.nanoTime() - startTime;
            }
        }
        // tiempo de ejecución
        return System.nanoTime() - startTime;
    }

    /**
     * Busca una palabra en el diccionario utilizando un algoritmo de búsqueda en profundidad (DFS).
     * @param palabra La palabra a buscar.
     * @return El tiempo en nanosegundos que tardó en encontrar la palabra.
     */
    public long buscarPalabraBFS(String tablero, String palabra, List<String> palabrasEncontradas) {
        long startTime = System.nanoTime();
        for (String p : palabras) {
            if (p.equals(palabra)) {
                palabrasEncontradas.add(p);
                return System.nanoTime() - startTime;
            }
        }
        // tiempo de ejecución
        return System.nanoTime() - startTime;
    }
}

