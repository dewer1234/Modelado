package Controlador;
import Modelo.*;
import Vista.*;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.Serializable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main implements Serializable{

public static void main(String[] args){
	Hashtable<String,Libro> n = new Hashtable<String,Libro>();
	Libreria libs = null;
	Scanner ls = new Scanner(System.in);
 	Vista vista = new Vista();
 	int x;
 	//Serializacion
 	FileOutputStream fos = null;
    ObjectOutputStream salida = null;
    FileInputStream fis = null;
    ObjectInputStream entrada = null;

    File doc = new File("libreria.dat");
    try{
    	if (doc.exists()) { 
            fis = new FileInputStream("libreria.dat");
            entrada = new ObjectInputStream(fis);
            libs = (Libreria) entrada.readObject();
		}
		else{    	
  
    		libs = new Libreria(n);
		}
    	fos = new FileOutputStream("libreria.dat");
    	salida = new ObjectOutputStream(fos);
 	} 
 	catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
	}
	catch (FileNotFoundException e) {
		  System.out.println(e.getMessage());
	}
	catch (IOException e) {
            System.out.println(e.getMessage());
    	} 

 	

 	
	do{	
	vista.imprimeMenu();
	x = ls.nextInt();
		switch(x){
		
			case 1:
			libs.registrarLibro(vista.registrarLibroMenu());
			break;

			case 2:
			libs.searchSet(vista.ingresaIsbn(),vista.ingresaAutor(),vista.ingresaTitulo(),vista.ingresaPrecio());
			break;

			case 3:
			libs.removerLibro(vista.eliminarLibroMenu());
			break; 

			case 4:
			String isbn2 = vista.ingresaIsbn();
			int uni = vista.ingresaUni();
			libs.search(isbn2).setUnidades(uni);
			break;

			case 5:
			vista.listaDeLibrosMenu();
			libs.verLibros();
			break;

			case 6:
			vista.adios();
			break;



		}	

	}while(x!=6);

	ls.close();
	try{
			
			salida.writeObject(libs);
		}catch(IOException e){
		}




}





}