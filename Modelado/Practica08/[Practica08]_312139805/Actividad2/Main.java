import javax.swing.JOptionPane;
import java.awt.EventQueue;


public class Main{

public static void main(String[] args){
	String prom1 = JOptionPane.showInputDialog("Ingresa el promedio de los alumnos de primer grado","");
	double prom11 = Double.parseDouble(prom1);
	String prom2 = JOptionPane.showInputDialog("Ingresa el promedio de los alumnos de segundo grado","");
	double prom22 = Double.parseDouble(prom2);
	String prom3 = JOptionPane.showInputDialog("Ingresa el promedio de los alumnos de tercer grado","");
	double prom33 = Double.parseDouble(prom3);
	String prom4 = JOptionPane.showInputDialog("Ingresa el promedio de los alumnos de cuarto grado","");
	double prom44 = Double.parseDouble(prom4);
	String prom5 = JOptionPane.showInputDialog("Ingresa el promedio de los alumnos de quinto grado","");
	double prom55 = Double.parseDouble(prom5);
	String prom6 = JOptionPane.showInputDialog("Ingresa el promedio de los alumnos de sexto grado","");
	double prom66 = Double.parseDouble(prom6);
	double promGen = (prom11+prom22+prom33+prom44+prom55+prom66)/6;


	double[] arr = {prom11,prom22,prom33,prom44,prom55,prom66};
	//Parte donde se muestra la grafica de barras y el promedio
	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					Barras grafica=new Barras(arr);
                    grafica.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Primer grado: "+prom11+"\n"+"Segundo grado: "+prom22+"\n"+"Tercer grado: "+prom33+"\n"+"Cuarto grado: "+prom44+"\n"+"Quinto grado :"+prom55+"\n"+"Sexto grado: "+prom66+"\n"+"Promedio de la escuela: "+promGen, "Promedio",JOptionPane.PLAIN_MESSAGE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
}











}