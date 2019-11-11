import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import java.awt.EventQueue;
import java.util.Arrays;

class Parte2  {
public static void main(String[] args) {
	UIManager uim=new UIManager();
		double[] arreglo= new double[6];

		String valor1;
		int i=0;
		double a=0;
		while(i<6) {
			valor1 = JOptionPane.showInputDialog("Escribe el promedio de los alumnos de " + String.valueOf(i+1)+"º grado");
			a = Double.parseDouble(valor1);
			arreglo[i]=a;
			i++;
		}
	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					Grafica grafica=new Grafica(arreglo);
                    grafica.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

	Texto texto=new Texto();
	texto.mostrarPromedios(arreglo);




	}	
}