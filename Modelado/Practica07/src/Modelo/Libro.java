package Modelo;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.*;


public class Libro implements Serializable{

public String isbn;
public String titulo;
public String autor;
public int precio;
public int unidades;


public Libro(String isbn,String titulo,String autor,int precio, int unidades){
	this.isbn = isbn;
	this.titulo = titulo;
	this.autor = autor;
	this.precio = precio;
	this.unidades = unidades;
}

public String toString(){
	return "ISBN: "+this.isbn+"\n" + "Titulo: "+this.titulo+"\n"+"Autor: "+this.autor+"\n"+"Precio: "+this.precio+"\n"+"Unidades: "+this.unidades+"\n";
}

public void setLibro(String title,String author,int price){
	this.titulo = title;
	this.autor = author;
	this.precio = price;

}

public String getIsbn(){
	return this.isbn;

}

public void setUnidades(int uni){
	this.unidades += uni;

}







}