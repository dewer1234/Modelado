import socket
import random

class Cuenta:

	def __init__(self):
		self.monto = 0
		self.fecha  = "01/01/2017"
		self.numero = random.randint(1000000000000000,9999999999999999)
		self.numeroA = []

	def getMontoC(self):
		return self.monto 

	def getCuenta(self):
		return self.numeroA			

	def ingresarMonto(self,monto2):
		self.monto += monto2

	def retirarMonto(self,monto2):
		self.monto -= monto2
			

	
class Cuentahabiente(Cuenta):
	
	def __init__(self,nombre,curp,adress,tel,mail,password):
		self.nombre = nombre
		self.curp = curp
		self.adress = adress
		self.tel = tel
		self.mail = mail
		self.password = password
		Cuenta.__init__(self)
	

	def getMonto(self):
		return self.monto	

	def getCURP(self):
		return self.curp

	def getPASS(self):
		return self.password		

	def cancelarCuenta(self):
		ran = random.randint(1000000000000000,9999999999999999)
		ant = self.numero
		self.numeroA.append(ant)
		self.numero = ran			
					
		#Falta lanzar la excepcion

	def toString(self):
		return "Nombre: "+self.nombre+"\n"+"Direccion: "+self.adress+"\n"+"Cuenta actual: "+str(self.numero)+"\n"+"Cuentas anteriores: "+str(self.numeroA)+"\n"

	def toStringC(self):
		return "Numero de cuenta: "+str(self.numero)+"\n"+"Fecha de apertura: "+self.fecha+"\n"+"Saldo: "+str(self.monto)+"\n"	

	
