import java.io.Serializable;




public class Cliente implements Serializable{

	private String nombre;
	private String aPaterno;
	private String aMaterno;
	private String login;
	private String password;
	private Cliente anterior;
	private Cliente siguiente;



	public Cliente(String a, String b, String c, String d, String e){
		this.nombre = a;
		this.aPaterno = b;
		this.aMaterno = c;
		this.login = d;
		this.password = e;
		this.anterior = null;
		this.siguiente = null;

	}

	public String getLogin(){
		return this.login;
	}

	public String getPassword(){
		return this.password;
	}

	public String getNombre(){
		return this.nombre;
	}


	public Cliente getAnterior(){
		return anterior;
	}


	public Cliente getSiguiente(){
		return siguiente;
	}

	public void setAnterior(Cliente ant){
		anterior=ant;
	}

	public void setSiguiente(Cliente sig){
		siguiente=sig;
	}

	public String toString(){
		return nombre+", \t"+aPaterno+aMaterno;
	}







}