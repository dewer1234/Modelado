import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import java.util.Arrays;

class Texto  {
JFrame frame;

public Texto(){
	frame = new JFrame();
}

public void mostrarPromedios(double []arreglo){
String regreso="";
double suma=0;
String [] ordinales={"Primer","Segundo","Tercer","Cuarto","Quinto","Sexto"};
for (int i=0; i<ordinales.length;i++) {
	suma+=arreglo[i];
	regreso+=ordinales[i]+" grado: "+String.valueOf(arreglo[i])+"\n";	
}

	regreso+="Promedio de la escuela :"+String.valueOf((suma)/6);
	JOptionPane.showMessageDialog(frame,regreso, "Promedios", JOptionPane.PLAIN_MESSAGE);

}
}