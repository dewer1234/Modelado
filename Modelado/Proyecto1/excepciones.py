
valor1=raw_input("escribe el numerador: ")
valor2=raw_input("escribe el denominador: ")


try:
	valor1=float(valor1)
	valor2=float(valor2)
	resultado=valor1/valor2
except ZeroDivisionError:
	print "No es posible realizar la division entre cero!"
except ValueError:
	print "Introduce valores numericos"
else:
	print "La division es "+str(resultado)
