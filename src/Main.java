import javafx.graphics.com.sun.glass.ui.Application;
import javafx.graphics.javafx.stage.Stage;

import java.awt.*;
import java.lang.classfile.Label;

public abstract class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Controles de entrada
        Label lblTitulo = new Label("Registro de Estudiante");

        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Ingrese el nombre");

        TextField txtMatricula = new TextField();
        txtMatricula.setPromptText("Ingrese la matrícula");

        Button btnRegistrar = new Button("Registrar");

        // Etiqueta para mostrar el resultado en pantalla
        Label lblResultado = new Label();

        // 2. Manejador de evento con setOnAction
        btnRegistrar.setOnAction(event -> {
            String nombreIngresado = txtNombre.getText().trim();
            String matriculaIngresada = txtMatricula.getText().trim();

            if (!nombreIngresado.isEmpty() && !matriculaIngresada.isEmpty()) {
                // Instanciación del modelo de dominio con los datos obtenidos
                Estudiante estudiante = new Estudiante(nombreIngresado, matriculaIngresada);

                // Presentación en pantalla utilizando los getters de la clase
                lblResultado.setText("Estudiante registrado:\n" +
                        "• Nombre: " + estudiante.getNombre() + "\n" +
                        "• Matrícula: " + estudiante.getMatricula());
            } else {
                lblResultado.setText("Por favor, complete ambos campos.");
            }
        });

        // 3. Layout (VBox)
        VBox layout = new VBox(10); // Espaciado vertical de 10px
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(lblTitulo, txtNombre, txtMatricula, btnRegistrar, lblResultado);

        // 4. Scene y Stage
        Scene scene = new Scene(layout, 320, 280);
        primaryStage.setTitle("Gestión Escolar - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}