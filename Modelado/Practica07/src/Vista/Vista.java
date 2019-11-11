package Vista;
import Modelo.*;
import java.util.Scanner;
import java.io.Serializable;
import java.io.*;

public class Vista implements Serializable{

public  Vista(){
	return; 
}	



public void imprimeMenu(){
		System.out.println("");
		System.out.println("ELIGE UNA OPCION:");
		System.out.println("1.Registrar Libro.");
		System.out.println("2.Editar Libro.");
		System.out.println("3.Eliminar Libro.");
		System.out.println("4.Agregar Libro.");
		System.out.println("5.Ver Libros.");
		System.out.println("6.Finalizar.");
}

public Libro registrarLibroMenu(){
	Scanner ls = new Scanner(System.in);
	System.out.println("Ingresa el ISBN:");
	String isbk = ls.next();
	System.out.println("Ingresa el titulo:");
	String title = ls.next();
	System.out.println("Ingresa el autor:");
	String author = ls.next();
	System.out.println("Ingresa el precio: ");
	int price = ls.nextInt();
	System.out.println("Ingresa la cantidad:");
	int cuantity = ls.nextInt();
	Libro x = new Libro(isbk,title,author,price,cuantity);
	System.out.println("Se ah agregado un nuevo libro a la libreria!");
	return x;

}

public void listaDeLibrosMenu(){
	System.out.println("La lista de libros: ");
	System.out.println("");

}

public String eliminarLibroMenu(){
	Scanner ls = new Scanner(System.in);
	System.out.println("Ingresa el isbn del libro a borrar:");
	String isbn4 = ls.next();
	System.out.println("Se ah eliminado un libro de la Libreria!");
	return isbn4;
}

public String ingresaAutor(){
	Scanner ls = new Scanner(System.in);
	System.out.println("Ingresa el autor: ");
	String isbn = ls.next();
	return isbn;
}

public String ingresaIsbn(){
	Scanner ls = new Scanner(System.in);
	System.out.println("Ingresa el isbn del libro a editar: ");
	String isbn = ls.next();
	return isbn;
}



public String ingresaTitulo(){
	Scanner ls = new Scanner(System.in);
	System.out.println("Ingresa el titulo: ");
	String isbn = ls.next();
	return isbn;
}

public int ingresaUni(){
	Scanner ls = new Scanner(System.in);
	System.out.println("Ingresa las unidades: ");
	int isbn = ls.nextInt();
	return isbn;
}

public int ingresaPrecio(){
	Scanner ls = new Scanner(System.in);
	System.out.println("Ingresa el precio: ");
	int isbn = ls.nextInt();
	return isbn;
}

public void adios(){
	System.out.println("Gracias por usar el programa, hasta luego!");
}



}











