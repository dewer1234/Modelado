import socket
import marshal
from proyecto import *
import random


cuentas = []
cajeros = {'clave1':"EDGAR",'clave2':"CAROLINA",'clave3':"MIGUEL"}
gerentes = {'clave4':"ROBERTO",'clave5':"RAMON"}
HOST = "127.0.0.1"
PORT = 5000
counter = 0
cuenta = Cuentahabiente("Brandon","HOLA","Ecatepec",55552,"fsfobsfs","dewerone1")
CHabientes = [cuenta]
CHabientes2 = []

#creamos un socket
mySocket = socket.socket( socket.AF_INET, socket.SOCK_STREAM )
#Enlace
mySocket.bind( ( HOST, PORT ) )


#Cajero
def retirarMontoC(nCuenta,monto):
	for i in CHabientes:
		if (i.getCuenta() == nCuenta):
				i.retirarMonto(monto)
		

def ingresarMontoC(nCuenta,monto):
	for i in CHabientes:
		if (i.getCuenta() == nCuenta):
				i.ingresarMonto(monto)

#Cuentahabiente
def conocerMontoC(nCuenta):
	for i in CHabientes:
		if (i.getCuenta() == nCuenta):
				print(i.getMonto())

#Gerente
def darDeAltaCH(nombre,curp,adress,tel,mail,password):
	miembro = Cuentahabiente(nombre,curp,adress,tel,mail,password)
	CHabientes.append(miembro)
	cuentas.append(miembro.toStringC())
	CHabientes2.append(miembro.toString())



def obtenerInfoCH():
	f = open("cuentahabientes.dat","rb")
	info = marshal.load(f)
	print("Contenido del archivo:", info)
	entrada.close()	


def obtenerInfoCH():
	f = open("cuentas.dat","rb")
	info = marshal.load(f)
	print("Contenido del archivo:", info)
	entrada.close()		




while 1:
	print ("Esperando conexion...")
	mySocket.listen( 1 )
	#Esperamos conexion
	connection, address = mySocket.accept()
	counter += 1
	print ("Conexion", counter, "recibida de :", address[ 0 ])
	#Procesamos la conexion
	connection.send( "SERVIDOR>> Conexion exitosa" )
	clientMessage = connection.recv( 1024 )

	while clientMessage != "4":
		if not clientMessage:
			break
		print ("Opcion del cliente " + str(clientMessage))

		if(clientMessage == "1"):
			connection.send("INGRESA TU NOMBRE DE USUARIO: ")
			user = connection.recv(1024)
			connection.send("INGRESA TU CONTRASENA: ")
			password = connection.recv(1024)
			for i in CHabientes:
				if(i.getCURP() == user and i.getPASS() == password):
					sujeto = i
					connection.send("QUE DESEA HACER:\n 11.RETIRAR MONTO\n 12.INGRESAR MONTO\n 13.MONTO ACTUAL\n")
					validar = connection.recv(1024)
					if(validar == "11"):
						connection.send("Ingresa el monto a retirar")
						retiro = int(connection.recv(1024))
						sujeto.retirarMonto(retiro)
						connection.send("Monto retirado con exito\n")
						connection.send("Bienvenido.\n Elige una opcion:\n 1.CUENTAHABIENTE\n 2.GERENTE\n 3.CAJERO\n 4.FINALIZAR")
					if(validar == "12"):
						connection.send("Ingresa el monto a depositar")
						ingreso = int(connection.recv(1024))
						sujeto.ingresarMonto(ingreso)
						connection.send("Monto ingresado con exito\n")
						connection.send("Bienvenido.\n Elige una opcion:\n 1.CUENTAHABIENTE\n 2.GERENTE\n 3.CAJERO\n 4.FINALIZAR")
					if(validar == "13"):
						connection.send("Monto actual: "+ str(sujeto.getMonto())+"\n")	
						connection.send("Bienvenido.\n Elige una opcion:\n 1.CUENTAHABIENTE\n 2.GERENTE\n 3.CAJERO\n 4.FINALIZAR")	


		elif(clientMessage == "2"):
			connection.send("INGRESA TU NOMBRE DE USUARIO:")
			usuario = connection.recv(1024)
			connection.send("INGRESA TU CONTRASENA:")
			contrasena = connection.recv(1024)
			if gerentes.has_key(contrasena):
				connection.send("Ingreso correctamente como: " + usuario +"\n")
				connection.send("QUE DESEA HACER:\n 5.DAR DE ALTA UN CUENTAHABIENTE\n 6.ELIMINAR UNA CUENTA\n 7.OBTENER INFORMACION DE UN CUENTAHABIENTE\n 8.OBTENER INFORMACION DE UNA CUENTA\n")
				validar = connection.recv(1024)
				if(validar == "5"):
					connection.send("Ingresa el nombre:\n")
					nombre = connection.recv(1024)
					connection.send("Ingresa el CURP:\n")
					curp = connection.recv(1024)
					connection.send("Ingresa la direccion:\n")
					adress = connection.recv(1024)
					connection.send("Ingresa un numero telefonico:\n")
					tel = int(connection.recv(1024))
					connection.send("Ingresa un correo electronico:\n")
					mail = connection.recv(1024)
					connection.send("Ingresa la contrasena nueva:\n")
					password = connection.recv(1024)
					darDeAltaCH(nombre,curp,adress,tel,mail,password)
					connection.send("Ha creado un nuevo cuentahabiente")
					print("Se creo un nuevo cuentahabiente")
					connection.send("Bienvenido.\n Elige una opcion:\n 1.CUENTAHABIENTE\n 2.GERENTE\n 3.CAJERO\n 4.FINALIZAR")	
				if(validar == "6"):
					connection.send("Ingresa el numero de la cuenta que desea eliminar")
					numero = connection.recv(1024)
					for i in CHabientes:
						if i.getCuenta() == int(numero):
							i.cancelarCuenta()
							connection.send("Cuenta cancelada con exito")
					connection.send("Bienvenido.\n Elige una opcion:\n 1.CUENTAHABIENTE\n 2.GERENTE\n 3.CAJERO\n 4.FINALIZAR")	
				if(validar == "7"):			
					connection.send("Ingrese el CURP del cuentahabiente")
					numero2 = connection.recv(1024)
					for i in CHabientes:	
						if i.getCURP() == numero2:
							sujeto = i
							connection.send(sujeto.toString())
					connection.send("Bienvenido.\n Elige una opcion:\n 1.CUENTAHABIENTE\n 2.GERENTE\n 3.CAJERO\n 4.FINALIZAR")	
				if(validar == "8"):
					connection.send("Ingrese el numero de cuenta")
					numero3 = connection.recv(1024)
					for i in CHabientes:
						if i.getCuenta() == int(numero3):
							connection.send(i.toStringC())
					connection.send("Bienvenido.\n Elige una opcion:\n 1.CUENTAHABIENTE\n 2.GERENTE\n 3.CAJERO\n 4.FINALIZAR")	

						
			else:
				connection.send("contrasena o usuario incorrect@\n")	
				connection.send("Bienvenido.\n Elige una opcion:\n 1.CUENTAHABIENTE\n 2.GERENTE\n 3.CAJERO\n 4.FINALIZAR")

		elif(clientMessage == "3"):	
			connection.send("INGRESA TU NOMBRE DE USUARIO:\n")
			usuario = connection.recv(1024)
			connection.send("INGRESA TU CONTRASENA:\n")
			contrasena = connection.recv(1024)
			if cajeros.has_key(contrasena):
				connection.send("Ingreso correctamente como: " + usuario +"\n")
				connection.send("QUE DESEA HACER:\n 9.ABONAR A UNA CUENTA\n 10.RETIRAR DE UNA CUENTA\n")
				validar = connection.recv(1024)
				if(validar == "9"):
					connection.send("Ingrese el numero de la cuenta a abonar\n")
					num = int(connection.recv(1024))
					for i in CHabientes:
						if i.getCuenta() == num:	
							connection.send("Ingrese el monto\n")
							mont = int(connection.recv(1024))
							ingresarMontoC(num,mont)
					connection.send("Monto ingresado\n")
					connection.send("Bienvenido.\n Elige una opcion:\n 1.CUENTAHABIENTE\n 2.GERENTE\n 3.CAJERO\n 4.FINALIZAR")	
				if(validar == "10"):
					connection.send("Ingrese el numero de la cuenta a retirar\n")
					num = int(connection.recv(1024))
					connection.send("Ingrese el monto\n")
					mont = int(connection.recv(1024))
					retirarMontoC(num,mont)
					connection.send("Monto retirado\n")	
					connection.send("Bienvenido.\n Elige una opcion:\n 1.CUENTAHABIENTE\n 2.GERENTE\n 3.CAJERO\n 4.FINALIZAR")	
					

		clientMessage = connection.recv( 1024 )		
	#Cerramos conexion
	f = open("cuentahabientes.dat","wb")
	g = open("cuentas.dat","wb")
	marshal.dump(CHabientes2,f)
	marshal.dump(cuentas,g)
	f.close()	
	g.close()
	print ("Conexion terminada")
	connection.close()
	




