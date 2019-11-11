import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
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


public class LoginCliente extends JFrame implements ActionListener {
   
   JPanel panel;
   JButton boton_envio;
   JLabel usuario_label;
   JLabel password_label;
   JTextField usuario;
   JTextField password;
   /**
    * Este metodo constructor construye y acomoda los elementos de la interfaz 
    * como botones y campos de texto
    */
   public LoginCliente()  {
  
      usuario_label = new JLabel();
      usuario_label.setText("Nombre de usuario:");
      usuario = new JTextField(10);
   
      password_label = new JLabel();
      password_label.setText("Password:");
      password = new JPasswordField(10);
    
      boton_envio=new JButton("Acceder");

      panel=new JPanel(new GridLayout(3,2));
      panel.add(usuario_label);
      panel.add(usuario);
      panel.add(password_label);
      panel.add(password);
      panel.add(boton_envio);
      
      add(panel);
      boton_envio.addActionListener(this);
      setTitle("Iniciar sesión Cliente");

      
   }

    
 
   /**
   * Este metodo detecta y procesa las peticiones de inicio de sesion, 
   * verifica los datos y si el nombre de usuario y password son validos 
   * procede a mostrar la interfaz principal del programa, 
   * en otro caso muestra una mensaje de error. 
   * @param ae el evento de peticion de inicio de sesion
   */
   public void actionPerformed(ActionEvent ae)  {
      String value1=usuario.getText();
      String value2=password.getText(); 
      if (value1.equals("user") && value2.equals("pass")) {
         MenuCliente.muestraInterfaz();
         JOptionPane.showMessageDialog(this,"BIENVENIDO CLIENTE","ACCESO",JOptionPane.INFORMATION_MESSAGE);
      }else {
         JOptionPane.showMessageDialog(this,"Usuario o password incorrectos","Error",JOptionPane.ERROR_MESSAGE);
      }
   }
}
