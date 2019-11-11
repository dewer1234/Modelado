import math

def triangulo(base,altura):
	area = (base*altura)/2
	return area

def cuadrado(lado):
	area = lado*lado
	return area

def rectangulo(lado1,lado2):
	area = lado1*lado2
	return area

def rombo(Dmayor,Dmenor):
	area = (Dmayor*Dmenor)/2
	return area

def trapecio(base1,base2,altura):
	area = (altura*(base1+base2))/2
	return area

def circulo(radio):
	area = math.pi*(radio*radio)
	return area

def perimetro(lados,longitud):
	per = lados*longitud
	return per

def poligonoRegular(nLados,lon,ap):
	area = 	(perimetro(nLados,lon)*ap)/2
	return area
	
def elipse(eje1,eje2):
	area = math.pi*eje1*eje2
	return area	