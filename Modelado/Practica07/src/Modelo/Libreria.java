package Modelo;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Scanner;
import java.io.Serializable;
import java.io.*;


public class Libreria implements Serializable{

public Hashtable<String,Libro> libreria;

public Libreria(Hashtable<String,Libro> x){
	this.libreria = x;
}

public void register(String k, Libro b){
	this.libreria.put(k,b);

}

public void searchSet(String k,String m,String n,int z){
	this.libreria.get(k).setLibro(m,n,z);

}

public Libro search(String k){
	return this.libreria.get(k);

}

public void registrarLibro(Libro a){
	String isbn2 = a.getIsbn();
	this.register(isbn2,a);
}


public void verLibros(){
	Enumeration<Libro> llaves = this.libreria.elements();

	while (llaves.hasMoreElements()) {
	System.out.println(llaves.nextElement().toString());

	}

}

public void removerLibro(String k){
	this.libreria.remove(k);

}





}