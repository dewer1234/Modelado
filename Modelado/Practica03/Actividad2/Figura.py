import math

class Figura:

	pass



class Cilindro(Figura):
	
	def calculaVolumen():
		entrada = int(input("Ingresa el valor del radio: "))
		entrada2 = int(input("Ingresa el valor de la altura: "))
		vol = math.pi*(entrada*entrada)*entrada2

		print(vol)


class Esfera(Figura):

	def calculaVolumen():
		entrada = int(input("Ingresa el valor del radio: "))
		vol = (4/3)*math.pi*(entrada*entrada*entrada)

		print(vol)

class Cono(Figura):
	
	def calculaVolumen():
		entrada = int(input("Ingresa el valor del radio: "))
		entrada2 = int(input("Ingresa el valor de la altura: "))
		vol = (math.pi*(entrada*entrada)*entrada2)/2

		print(vol)	

		
