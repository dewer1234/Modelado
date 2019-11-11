import java.awt.Color;
import javax.swing.JOptionPane; 
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField; 
import javax.swing.JPasswordField; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class MenuCliente extends JFrame implements Serializable{

private String nombreArchivo="almacen.ser";
ArrayList<Producto> almacen = new ArrayList<Producto>();
ArrayList<Producto> carrito = new ArrayList<Producto>();
JTabbedPane panelFichas = new JTabbedPane(); 
//private String archivo = "clientes.dat";
//ArrayList<Cliente> usuarios = new ArrayList<Cliente>();

	public MenuCliente() {
	 
	      super( "Tienda de abarrotes " );
	      //usuarios = leerUsuarios();
	      almacen = leerProductos();
	      ponPestaniaAgregar();
	      ponPestaniaVerTodo();
	      ponPestaniaQuitar();
	      ponPestaniaPagar();
	      ponPestaniaSalir();
	      add( panelFichas ); // agrega objeto JTabbedPane al marco
	   }

	public static void muestraInterfaz() {
	      MenuCliente m = new MenuCliente();
	      m.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      m.setSize( 850, 400 );
	      m.setVisible( true );
	      m.setResizable(false);

	   }


	public void ponPestaniaAgregar() {

	      Icon imagen = new ImageIcon(  "compra.jpg"  );
	      JLabel estampa = new JLabel(imagen);      
	      //Etiquetas de los mensajes
	      JLabel label0 = new JLabel("Rellena la siguiente información");
	      JLabel label1 = new JLabel("Elige un producto");
	      JLabel label2 = new JLabel("Unidades");
	    

	      //Botón de envío
	      JButton boton_registro = new JButton("Agregar");
	      //ComboBox de productos 
	      JComboBox prod = new JComboBox();
	      JComboBox unidades = new JComboBox();
	      String[] listaProd = regresaArray();
	      int[] numeros = {1,2,3,4,5,6,7,8,9,10};
	      //Añadimos la lista de prod en el comboBox
	      for(int i=0;i<listaProd.length;i++){
	      	prod.addItem(listaProd[i]);
	      }
	      for(int i=0;i<numeros.length;i++){
	      	unidades.addItem(numeros[i]);
	      }

	      JPanel panel1 = new JPanel(new GridLayout(1,2));
	      JPanel panel_1 = new JPanel(new GridLayout(4,2,-100,30));
	      panel_1.add(label0);
	      panel_1.add(new JLabel(""));
	      panel_1.add(label1);
	      panel_1.add(prod);
	      panel_1.add(label2);
	      panel_1.add(unidades);
	      panel_1.add(boton_registro);
	      
	      panel1.add(panel_1);
	      panel1.add(estampa);

	      
	      boton_registro.addActionListener(new ActionListener() {             
	         public void actionPerformed(ActionEvent evento) {                                   
	            String productoSelec = (String) prod.getSelectedItem();
	            int cuantity = (int) unidades.getSelectedItem();
	            double price = 0;
	            for(int i=0;i<almacen.size();i++){
	            	if(productoSelec == (almacen.get(i)).daNombre()){
	            		int desc = ((almacen.get(i)).daCantidad())-cuantity;
	            		almacen.get(i).ponCantidad(desc);
	            		price = (almacen.get(i).daPrecio())*cuantity;
	            	}

	            }

	            boolean se_pudo = agregaCarrito(productoSelec, price, cuantity);
	            if(se_pudo) {
	               JOptionPane.showMessageDialog(null, "producto agregado exitosamente ", "exito", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	               JOptionPane.showMessageDialog(null, "ocurrio un error ", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }
	         }                       
	      });                                     
	      panelFichas.addTab( "Comprar Articulo", panel1);
	   }

	public void ponPestaniaQuitar() {

	      Icon imagen = new ImageIcon(  "quitar.png"  );
	      JLabel estampa = new JLabel(imagen);      
	      //Etiquetas de los mensajes
	      JLabel label0 = new JLabel("Rellena la siguiente información");
	      JLabel label1 = new JLabel("Elige un producto");
	    

	      //Botón de envío
	      JButton boton_registro = new JButton("Quitar");
	      //ComboBox de productos
	      JComboBox prod = new JComboBox();
	      String[] listaProd = regresaArray();

	      //Añadimos la lista de prod en el comboBox
	      for(int i=0;i<listaProd.length;i++){
	      	prod.addItem(listaProd[i]);
	      }

	      JPanel panel1 = new JPanel(new GridLayout(1,2));
	      JPanel panel_1 = new JPanel(new GridLayout(4,2,-100,30));
	      panel_1.add(label0);
	      panel_1.add(new JLabel(""));
	      panel_1.add(label1);
	      panel_1.add(prod);
	      panel_1.add(boton_registro);
	      
	      panel1.add(panel_1);
	      panel1.add(estampa);

	      
	      boton_registro.addActionListener(new ActionListener() {             
	         public void actionPerformed(ActionEvent evento) {                                   
	            String productoSelec = (String) prod.getSelectedItem();
	            boolean se_pudo = borraProducto(productoSelec);
	            if(se_pudo) {
	               JOptionPane.showMessageDialog(null, "producto eliminado exitosamente ", "exito", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	               JOptionPane.showMessageDialog(null, "ocurrio un error ", "ERROR", JOptionPane.ERROR_MESSAGE);
	            }
	         }                       
	      });                                     
	      panelFichas.addTab( "Quitar Articulo", panel1);
	   }
	 	  

	 public void ponPestaniaVerTodo() {
	      // PESTAÑA DE VER Todo
	      JLabel todo = new JLabel();
	      JPanel panel = new JPanel(new GridLayout(1,2)); 
	      JButton boton_ver = new JButton("Ver articulos de carrito");
	      panel.add(boton_ver);
	      
	      boton_ver.addActionListener(new ActionListener() {             
	         public void actionPerformed(ActionEvent evento) {                                   
	           String respuesta="<html>";
	            for(int i=0; i<carrito.size(); i++) {
	               respuesta+="<br>"+carrito.get(i);
	            } 
	            respuesta+="</html>";    
	            todo.setText(respuesta); 
	         }                       
	      });     
	       
	      panel.add(todo);
	      panelFichas.addTab( "Ver Carrito", null, panel);
   }

   public void ponPestaniaPagar() {
      // PESTAÑA DE VER Todo
      JLabel todo = new JLabel();
      JPanel panel = new JPanel(new GridLayout(2,2));
      JButton boton_compra = new JButton("Procesar Total"); 
      JButton boton_ver = new JButton("Pagar");
      panel.add(boton_compra);
      panel.add(new JLabel(""));
      panel.add(boton_ver);


      boton_compra.addActionListener(new ActionListener() {             
         public void actionPerformed(ActionEvent evento) {
         double total = 0; 
         for(int i=0; i<carrito.size(); i++) {
               total += carrito.get(i).daPrecio();
            }                                 
           String pago = "El total a pagar es: " + total+"$";     
           JOptionPane.showMessageDialog(null, pago, "exito", JOptionPane.INFORMATION_MESSAGE); 	
         }                       
      });             
      
      boton_ver.addActionListener(new ActionListener() {             
         public void actionPerformed(ActionEvent evento) {
           JOptionPane.showMessageDialog(null, "productos pagados", "exito", JOptionPane.INFORMATION_MESSAGE);
           grabar();
           carrito.clear();

         }                       
      });     
      
      panelFichas.addTab( "Pagar", null, panel);
   } 


   public void ponPestaniaSalir() {
      // PESTAÑA DE SALIR
      Icon imagen = new ImageIcon( "salir.jpg" );
      JLabel estampa = new JLabel(imagen); 
      JPanel panel = new JPanel(new GridLayout(1,2)); // crea el segundo panel
      JButton boton_salir = new JButton("Cerrar Sesion");
      panel.add(boton_salir);
      panel.add(estampa);
      boton_salir.addActionListener(new ActionListener() {             
         public void actionPerformed(ActionEvent evento) {                                   
        	carrito = null;
           System.exit(1);
         }                       
      });     
      panelFichas.addTab( "Cerrar sesión", panel); 
   }

   public void grabar(){
      try{
         ObjectOutputStream a= new ObjectOutputStream(new FileOutputStream(nombreArchivo));
         a.writeObject(almacen);
         a.close();
      }
      catch(NotSerializableException e){
         System.out.println("Error en la grabacion: "+e+"Objeto no serializable");
      }
      catch(IOException e){
         System.out.println("Error en la grabacion: "+e);
      }

   }   


	 public ArrayList leerProductos(){
	     try{
	        ObjectInputStream lector=new ObjectInputStream(new FileInputStream(nombreArchivo));
	        ArrayList<Producto> productos = (ArrayList<Producto>) lector.readObject();
	        lector.close();
	        this.almacen=productos;
	      }
	     catch(IOException e){
	        System.out.println("Lectura fallida: "+e);
	      }
	     catch(ClassNotFoundException e){
	        System.out.println("Lectura fallida: "+e);
	      }
	     return almacen;
	   }




   public String buscaProductos(String cadena) {
      String res="<html>";
      for(int i=0; i<almacen.size(); i++) {
         String cad=(almacen.get(i)).toString();
         if(cad.contains(cadena)) {
            res+="<br>"+cad;
         }
      }
      return res;

   }

   public boolean agregaCarrito(String n, double p, int c) {
      Producto nuevo = new Producto("", n, p, c);
      carrito.add(nuevo);
      return true;
   }


   public boolean borraProducto(String codigo) {
      boolean borrado=false;
      for(int i=0; i<carrito.size(); i++) {
        String cp=carrito.get(i).daNombre();
        if(cp.equals(codigo)) {
         carrito.remove(i);
         borrado=true;
        }
      }
      return borrado;
   }

   public String[] regresaArray(){
   	String[] array = new String[almacen.size()];
   	for(int i=0;i<almacen.size();i++){
   		array[i] = almacen.get(i).daNombre();
   	}
   	return array;

   }



   


}