import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Formulario extends Application {

    @Override
    public void start(Stage primaryStage) {

	//Ventana
        primaryStage.setTitle("Calculadora de IMC");

	//Grid
        GridPane panel = new GridPane();
        panel.setHgap(10);
        panel.setVgap(10);
       	panel.setPadding(new Insets(0, 25, 25, 25));
        Scene scene = new Scene(panel, 500, 500);

	//Texto
        Text sceneTitle = new Text("Calcular IMC");
        sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL,15));
        panel.add(sceneTitle, 0, 0, 2, 1);


	//Se agrega el nombre /total = nombre/
	//Mensaje
        Label nombre = new Label("Nombre");
        panel.add(nombre, 0, 1);
	//Input /cant = nombreField/
        final TextField nombreField = new TextField();
        panel.add(nombreField, 1, 1);


	//Se agrega la edad /porcentaje = edad/
        Label edad = new Label("Edad");
        panel.add(edad,0,2);
	//Input /porcentajeField = edadField/
        final TextField edadField = new TextField();
        panel.add(edadField, 1, 2);

    //Se agrega la estatura
    //Mensaje
        Label estatura = new Label("Estatura");
        panel.add(estatura, 0, 3);
    //Input /cant = nombreField/
        final TextField estaturaField = new TextField();
        panel.add(estaturaField, 1, 3);  

    //Se agrega el peso
    //Mensaje
        Label peso = new Label("Peso");
        panel.add(peso, 0, 4);
    //Input /cant = nombreField/
        final TextField pesoField = new TextField();
        panel.add(pesoField, 1, 4); 
     //Se agrega el genero   
        Label genero = new Label("Genero");
        panel.add(genero,0,5);
        //Hacemos un combo box para el genero
        final ComboBox<String> cbx = new ComboBox<>();
        cbx.getItems().addAll("Masculino","Femenino");
        panel.add(cbx,1,5);
        


     


	//Boton
        Button boton = new Button("Calcular");

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.getChildren().add(boton);
        panel.add(hbox, 1, 7);

        final Text mensajeFinalMostrar = new Text();
        panel.add(mensajeFinalMostrar, 1, 10);

        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Double weight = Double.parseDouble(pesoField.getText());
                Double height = Double.parseDouble(estaturaField.getText());
                String name = nombreField.getText();
                String age = edadField.getText();
                Double imc = weight/(height*height);
                String message = "";
                if(imc < 16){
                    message = "Usted tiene bajo peso muy grave";
                }else if(imc > 16 && imc < 17){
                    message = "Usted tiene bajo peso grave";
                }else if(imc > 17 && imc < 18.5){
                    message = "Usted tiene bajo peso";
                }else if(imc > 18.5 && imc < 25){
                    message = "Usted tiene peso normal";
                }else if(imc > 25){
                    message = "Usted tiene sobre peso";
                }
                mensajeFinalMostrar.setText("Nombre: "+name+"\n"+"Edad: "+age+"\n"+"Genero: "+cbx.getValue()+"\n"+"Su IMC es de: "+imc+" kg/m^2"+"\n"+message);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();


	//Estilos
	panel.setStyle("-fx-background-color: MediumSpringGreen;");
	boton.setStyle("-fx-background-color: MediumVioletRed; -fx-text-fill: white;");
    


    }


    public static void main(String[] args) {
        launch(args);
    }


}
