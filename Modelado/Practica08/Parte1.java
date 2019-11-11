import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Parte1 extends Application {

@Override public void start(Stage stage){
		stage.setTitle("Parte 1");
        Scene scene = new Scene(new Group(), 500, 500);

        final Button button = new Button ("Send");
        final TextField nombre = new TextField("");
        final TextField edad = new TextField("");
        final TextField estatura = new TextField("");
        final TextField peso = new TextField("");

        final ComboBox genero = new ComboBox();
        genero.getItems().addAll(
            "Hombre",
            "Mujer"
        );

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.add(new Label("Nombre: "), 0, 0);
        grid.add(nombre, 1, 0);
	    grid.add(new Label("Edad: "), 0, 1);
        grid.add(edad, 1, 1);
        grid.add(new Label("Estatura: "), 0, 2);
        grid.add(estatura, 1, 2);
        grid.add(new Label("Peso: "), 0, 3);
        grid.add(peso, 1, 3);
        grid.add(new Label("Genero: "), 0, 4);
        grid.add(genero, 1, 4);
        grid.add(button,1,5);

		final Text mensajeFinalMostrar = new Text();
        grid.add(mensajeFinalMostrar, 1, 6);

		button.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent t) {
                Double estaturad = Double.parseDouble(estatura.getText());
                Double pesod = Double.parseDouble(peso.getText());
                String nombred = nombre.getText();
                Double tax = pesod/(estaturad*estaturad);
                mensajeFinalMostrar.setText(nombred+" tu IMC es = "+tax);
            }
        });

        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();


}

public static void main(String[] args) {
        launch(args);
}
	
}