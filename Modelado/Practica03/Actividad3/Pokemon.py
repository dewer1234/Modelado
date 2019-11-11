
class Pokemon:

	def __init__(self,nombre,energia,ataque):
		self.nombre = nombre
		self.energia = energia
		self.ataque = ataque

	def imprimeAtaque(self):
		print(self.nombre + "/"+"Ataques=" + str(self.ataque)+"/"+"Energia="+str(self.energia))

	def ataca(poke1,nom,poke2):
		for elem in poke1.ataque:
			if nom == elem:
				poke2.energia -= poke1.ataque[nom]




class Electrico:

	def __init__(self,name,energy,atacks):
		Pokemon.__init__(self,name,energy,atacks)

class Fuego:
	
	def __init__(self,name,energy,atacks):
		Pokemon.__init__(self,name,energy,atacks)

class Planta:
	
	def __init__(self,name,energy,atacks):
		Pokemon.__init__(self,name,energy,atacks)

class Agua:

	def __init__(self,name,energy,atacks):
		Pokemon.__init__(self,name,energy,atacks)


poke1 = Electrico("Pikachu",100,{'trueno':30,'velocidad':25})
poke2 = Agua("Greninja",100,{'corte':30,'dobleequipo':35})

while(poke2.energia > 0 or poke1.energia >0):
	Pokemon.imprimeAtaque(poke1)
	ataque = input("Ingresa el ataque que quieres hacer: "+"\n")
	Pokemon.ataca(poke1,ataque,poke2)
	if poke2.energia <= 0:
		print("El ganador es: " + poke1.nombre)
		break
	Pokemon.imprimeAtaque(poke2)
	ataque2 = input("Ingresa el ataque que quieres realizar: "+"\n")
	Pokemon.ataca(poke2,ataque2,poke1)
	if poke1.energia <= 0:
		print("El ganador es: " + poke2.nombre)	
		break	