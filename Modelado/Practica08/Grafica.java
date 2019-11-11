import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Grafica extends JFrame {

   private JPanel contentPane;
    double [] alumnos;

  	public Grafica(double alumnos [] ) {
    	this.alumnos=alumnos;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 2));
        setBounds(0,0,300,500);
    }
    


    public void paint (Graphics g){
        super.paint(g);
    	Color colores []={Color.blue,Color.yellow,Color.red,Color.orange,Color.pink,Color.green};
    	int i=0;
    	int x=0;
    	int y=0;
    	int ancho=50;
    	int largo=0;
    	for ( double clase : this.alumnos) {
    	largo=(int)(clase*50);
    	y=500-largo;
        g.setColor (colores[i]);
        g.fillRect (x, y, ancho, largo);
    	i++;	
    	x+=50;
    	}
    }
}