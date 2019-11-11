
def sumaElementos(lista):
	res = 0
	for element in lista:
		if str(element).isdigit():
			res+= element
		if type(element) is list:
			res+=sumaElementos(element)		
	return res

	