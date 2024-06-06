import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: Annabella Mendoza
 
 */
/**
 * La clase SopaDeLetrasGUI representa la interfaz gráfica de usuario para el juego de la sopa de letras.
 * La interfaz permite cargar un archivo con el tablero y el diccionario, buscar palabras en el tablero y guardar el diccionario.
 */
public class SopaDeLetrasGUI extends JFrame {
    private Diccionario diccionario;
    private JButton cargarArchivoButton;
    private JTextArea tableroYDiccionarioArea;
    private JTextField palabraTextField;
    private JButton buscarPalabraButton;
    private JButton seleccionarMetodoButton;
    private JTextArea resultadosBusquedaArea;
    private JButton guardarDiccionarioButton;
    JLabel resultadoLabel = new JLabel();

    /**
     * Constructor para la clase SopaDeLetrasGUI.
     * Inicializa la interfaz gráfica de usuario y los componentes de la interfaz.
     */
    public SopaDeLetrasGUI() {
        setTitle("Sopa de Letras");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        cargarArchivoButton = new JButton("Cargar Archivo");
        diccionario = new Diccionario("nombreArchivo.txt");
        tableroYDiccionarioArea = new JTextArea(10, 40);
        palabraTextField = new JTextField(20);
        buscarPalabraButton = new JButton("Buscar Palabra");
        seleccionarMetodoButton = new JButton("Seleccionar Método");
        resultadosBusquedaArea = new JTextArea(10, 40);
        guardarDiccionarioButton = new JButton("Guardar Diccionario");

        add(cargarArchivoButton);
        add(new JScrollPane(tableroYDiccionarioArea));
        add(palabraTextField);
        add(buscarPalabraButton);
        add(seleccionarMetodoButton);
        add(new JScrollPane(resultadosBusquedaArea));
        add(guardarDiccionarioButton);
        add(resultadoLabel);

        // Aquí puedes agregar los ActionListener para cada botón
        cargarArchivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                        String line;
                        StringBuilder stringBuilder = new StringBuilder();
                        while ((line = reader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        reader.close();
                        // Aquí puedes separar el tablero del diccionario
                        tableroYDiccionarioArea.setText(stringBuilder.toString());

                        // Crear una nueva instancia de Diccionario con el archivo seleccionado
                        diccionario = new Diccionario(selectedFile.getPath());

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        // Código para buscar la palabra
        buscarPalabraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // buscar palabra en el tablero
                String palabra = palabraTextField.getText();
        
                // Verificar si la palabra está en el diccionario
                boolean isInDictionary = diccionario.contienePalabra(palabra);
        
                // Mostrar el resultado en el label
                if (isInDictionary) {
                    resultadoLabel.setText("La palabra está en el diccionario.");
                } else {
                    resultadoLabel.setText("La palabra no está en el diccionario.");
                }
            }
        });

        seleccionarMetodoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para seleccionar el método de búsqueda
            }
        });

        guardarDiccionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ha guardado el diccionario.");
                // Código para guardar el diccionario
                diccionario.guardarDiccionario(".txt");  
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SopaDeLetrasGUI().setVisible(true);
            }
        });
    }
}