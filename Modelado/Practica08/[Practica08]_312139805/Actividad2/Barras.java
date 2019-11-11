import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Barras extends JFrame {

   private JPanel contentPane;
    double [] grupos;

  	public Barras(double grupos [] ) {
    	this.grupos = grupos;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new LineBorder(Color.black));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 2,10,10));
        setBounds(0,0,300,500);
        this.setTitle("Grafica");


    }
    


    public void paint (Graphics g){
        super.paint(g);
    	Color colores []={Color.blue,Color.red,Color.green,Color.pink,Color.black,Color.orange};
    	int i=0;
    	int x=0;
    	int y=0;
    	int ancho=50;
    	int largo=0;
    	for ( double clase : this.grupos) {
    	largo=(int)(clase*50);
    	y=500-largo;
        g.setColor (colores[i]);
        g.fillRect (x, y, ancho, largo);
    	i++;	
    	x+=50;
    	}
    }
}