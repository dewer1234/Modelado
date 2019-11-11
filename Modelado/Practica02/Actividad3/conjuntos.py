
def union(A,B):
	AUB = A
	for element in B:
		if element not in A:
			AUB+=[element]
	return AUB	

def interseccion(A,B):
	AYB = []
	for element in A:
		if element in B:
			AYB += [element]
	return AYB				
