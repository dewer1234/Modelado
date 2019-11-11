import socket


HOST = "127.0.0.1"
PORT = 5000


# creamos un socket
print ("Esperando Conexion...")
mySocket = socket.socket( socket.AF_INET, socket.SOCK_STREAM )
#Conexion al servidor
mySocket.connect( ( HOST, PORT ) )
print ("Estamos conectados al servidor")
#Procesamos conexion
serverMessage = mySocket.recv( 1024 )

print ("Bienvenido .\n Elige una opcion:\n 1.CUENTAHABIENTE\n 2.GERENTE\n 3.CAJERO\n 4.FINALIZAR")
while serverMessage != "SERVIDOR>>> FINALIZAR":

	if not serverMessage:
		break
	print (serverMessage)
	clientMessage = raw_input( "CLIENTE>>> " )
	mySocket.send(clientMessage)
	serverMessage = mySocket.recv( 1024 )

#Cerramos comexion
print ("Gracias por usar el sistema de banco")
mySocket.close()