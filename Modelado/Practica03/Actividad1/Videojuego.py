
class Videojuego:

	def __init__(self,nombre,genero,precio,desarrollador):
		self.nombre = nombre
		self.genero = genero
		self.desarrollador = desarrollador
		if precio < 0:
			self.precio = 0
		else:	
			self.precio = precio

	def toString(self):
		return "Nombre: " + self.nombre + "\n" + "Genero: " + self.genero + "\n" + "Precio: " + str(self.precio) + "\n" + "Desarrollador: "+self.desarrollador  

	def setNombre(self,nom):
		self.nombre = nom

	def setGenero(self,gen):
		self.genero = gen

	def setPrecio(self,pre):
		self.precio = pre	

	def setDesarrollador(self,des):
		self.desarrollador = des			

	def getNombre(self):
		return self.nombre

	def getGenero(self):
		return self.genero

	def getPrecio(self):
		return self.precio

	def getDesarrollador(self):
		return self.desarrollador			

	def rebajaVideojuego(self):
		self.precio = self.precio*0.15	

	def precioMayor(self,lista):
		i = 0
		for elem in lista:
			if i < elem.precio:
				i = elem.precio
		return i
	
	def elMasCaro(self,lista1):
		lista = []
		aux = precioMayor(lista1)
		for elem in lista1:
			if aux == elem.precio:
				lista += elem.toString()
		print(lista)				



vid1 = Videojuego("Crash","Aventura",50,"Naughty Dog")	
vid2 = Videojuego("Mario Kart","Carreras",25,"Nintendo")
vid3 = Videojuego("Zelda","Aventura",500,"Nintengo")
vid4 = Videojuego("Silent Hill","Horror/Aventura",250,"ubisoft")
vid5 = Videojuego("Tony Hawk","Aventura",150,"EA")
vid6 = Videojuego("Resident Evil","Horror/Aventura",170,"capcom")
vid7 = Videojuego("Yu-gi-Oh","Estrategia",100,"Atari")
vid8 = Videojuego("Halo","Aventura",2,"Bongey")
vid9 = Videojuego("Gran Turismo","Carreras",60,"ubisoft")
vid10 = Videojuego("GTA V","Aventura",800,"Rockstar")
	

			