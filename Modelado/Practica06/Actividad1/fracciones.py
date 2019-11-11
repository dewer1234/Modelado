

class Fracciones:

	#Constructor que crea una fraccion	
	def __init__(self,numerador,denominador):
		self.numerador = numerador
		self.denominador = denominador


	def setFrac(self,n,m):
		self.numerador = n	
		self.denominador = m


	def getNum(self):
		return self.numerador


	def getDen(self):
		return self.denominador


	def getValor(self):
		return self.getNum()/self.getDen()		
	



def suma(frac1,frac2):
		a = Fracciones(frac1.getNum()+frac2.getNum(),frac1.getDen()+frac2.getDen())
		return a

id1 = Fracciones(0,1)
id2 = Fracciones(1,0)
actual = Fracciones(1,1) 
actual1 = Fracciones(1,1)


while(True):
	line = input("")
	frac = line.split()
	frac1 = int(frac[0])
	frac2 = int(frac[1])
	a = Fracciones(frac1,frac2)

	res = ""

	if(frac1 == 1 and frac2 == 1):
		break

	else:	

		while(a.getValor() != actual.getValor()):

			if(a.getValor() > actual.getValor()):
				id1 = actual
				actual = suma(actual,id2)
				res += "R"			
			

			if(a.getValor() < actual.getValor()):
				id2 = actual
				actual = suma(actual,id1)
				res += "L"			

			

		print(res)
		actual.setFrac(1,1)
		id1.setFrac(0,1)
		id2.setFrac(1,0)


	

