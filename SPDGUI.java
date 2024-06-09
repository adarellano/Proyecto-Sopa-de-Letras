/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import DFS.DFS;
import DFS.ListaDoble;
import DFS.NodoDoble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Annabella Mendoza
 *
 */
/**
 * La clase SopaDeLetrasGUI representa la interfaz gráfica de usuario para el juego de la sopa de letras.
 * La interfaz permite cargar un archivo con el tablero y el diccionario, buscar palabras en el tablero y guardar el diccionario.
 */
public class SPDGUI extends JFrame {

    private Diccionario diccionario = new Diccionario("diccionario.txt");
    private JLabel archivoLabel;
    private JTextField archivoTextField;
    private JButton cargarArchivoButton = new JButton("Cargar Archivo");
    private JLabel tableroLabel;
    private JTextArea tableroYDiccionarioArea;
    private JLabel palabraLabel;
    private JTextField palabraTextField;
    private JLabel metodoBusquedaLabel;
    private DFS dfs;
    private JComboBox<String> metodoBusquedaComboBox = new JComboBox<>(new String[]{"DFS", "BFS"});
    private JButton buscarPalabraButton = new JButton("Buscar Palabra");
    private JLabel resultadosBusquedaLabel;
    private JTextArea resultadosBusquedaArea;
    private JButton guardarDiccionarioButton = new JButton("Guardar Diccionario");

    /**
     * Constructor para la clase SopaDeLetrasGUI.
     * Inicializa la interfaz gráfica de usuario y los componentes de la interfaz.
     */
    public SPDGUI() {
        setTitle("Sopa de Letras");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        this.dfs = new DFS();

        // Etiquetas
        archivoLabel = new JLabel("Archivo:");
        tableroLabel = new JLabel("Tablero y Diccionario:");
        palabraLabel = new JLabel("Palabra:");
        metodoBusquedaLabel = new JLabel("Método de Búsqueda:");
        resultadosBusquedaLabel = new JLabel("Resultados de Búsqueda:");

        // Campos de texto
        archivoTextField = new JTextField(20);
        palabraTextField = new JTextField(20);

        // Botones
        cargarArchivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarArchivo();
            }
        });
        buscarPalabraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPalabra();
            }
        });
        guardarDiccionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDiccionario();
            }
        });

        // ComboBox
        metodoBusquedaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarMetodo();
            }
        });

        // Áreas de texto
        tableroYDiccionarioArea = new JTextArea(10, 40);
        resultadosBusquedaArea = new JTextArea(10, 40);

        // Agregar componentes al GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();

        // Primera fila
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(archivoLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(archivoTextField, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        add(cargarArchivoButton, constraints);

        // Segunda fila
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(tableroLabel, constraints);

        constraints.gridx = 1;
        constraints.gridx = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(tableroYDiccionarioArea), constraints);

        // Tercera fila
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(palabraLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        add(palabraTextField, constraints);

        // Cuarta fila
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(metodoBusquedaLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        add(metodoBusquedaComboBox, constraints);

        // Quinta fila
        constraints.gridx = 0;
        constraints.gridy = 4;
        add(buscarPalabraButton, constraints);

        // Sexta fila
        constraints.gridx = 0;
        constraints.gridy = 5;
        add(resultadosBusquedaLabel, constraints);

        constraints.gridx = 1;
        constraints.gridx = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(resultadosBusquedaArea), constraints);

        // Séptima fila
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        add(guardarDiccionarioButton, constraints);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cargarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (!selectedFile.exists()) {
                JOptionPane.showMessageDialog(null, "File does not exist: " + selectedFile.getAbsolutePath());
                return;
            }
            try {
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                String line;
                StringBuilder stringBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        stringBuilder.append(word).append("\n");
                    }
                }
                reader.close();
    
                tableroYDiccionarioArea.setText(stringBuilder.toString());
    
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
        /**
         * Busca una palabra en el tablero y muestra los resultados en el área de texto.
         */
        private void buscarPalabra() {
            String palabra = palabraTextField.getText();
            String metodoBusqueda = metodoBusquedaComboBox.getSelectedItem().toString();
    
            // Buscar la palabra en el tablero
            List<String> palabrasEncontradas = new LinkedList<>();
            long tiempoEjecucion = 0;
    

            /**
             * Aquí estoy tratando de implementar las funciones del dfs en la interfaz gráfica, pero no me está funcionando.
             */
            // Buscar la palabra en el diccionario
            if (metodoBusqueda.equals("DFS")) {
                NodoDoble nodo = new NodoDoble();
                NodoDoble lista = NodoDoble.getListaAdy();
                string palabra = palabraTextField.getText();
                this.dfs.buscarPalabra(lista, palabra);
                boolean resultado = this.dfs.BuscarPalabra(lista, palabra);
                if (resultado) {
                    JOptionPane.showMessageDialog(null, "La palabra está en el diccionario.");
                } else {
                    JOptionPane.showMessageDialog(null, "La palabra no está en el diccionario.");
                }
                
            } else if (metodoBusqueda.equals("BFS")) {
                tiempoEjecucion = diccionario.buscarPalabraBFS(tableroYDiccionarioArea.getText(), palabra, palabrasEncontradas);
            }
    
            // Mostrar los resultados en el área de texto
            String resultado;
            if (palabrasEncontradas.isEmpty()) {
        resultado = "La palabra no se encontró en el tablero.\n";
    } else {
        resultado = "Palabras encontradas: \n";
        for (String palabraEncontrada : palabrasEncontradas) {
            resultado += palabraEncontrada + "\n";
        }
    }
    
            // Mostrar el tiempo de ejecución
            resultado += "\nTiempo de ejecución: " + tiempoEjecucion + " milisegundos";
            resultadosBusquedaArea.setText(resultado);
        }
     
        /**
         * Muestra el método de búsqueda seleccionado en un cuadro de diálogo.
         */
        private void seleccionarMetodo() {
            String metodoSeleccionado = metodoBusquedaComboBox.getSelectedItem().toString();
            JOptionPane.showMessageDialog(null, "Método de búsqueda seleccionado: " + metodoSeleccionado);
        }
        
        /**
         * Guarda el diccionario en un archivo.
         */
        private void guardarDiccionario() {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        diccionario.guardarDiccionario(selectedFile.getPath());
                        JOptionPane.showMessageDialog(null, "Diccionario guardado exitosamente.");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } finally {
                        JOptionPane.showMessageDialog(null, "Error al guardar el diccionario.");
                    }
                } 
            } 

            /**
             * Método principal para ejecutar la aplicación.
             * @param args Los argumentos de la línea de comandos.
             */
            public static void main(String[] args) {
                SwingUtilities.invokeLater(SPDGUI::new);
            }
            } 
