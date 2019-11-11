

suma = 0
cont = 0
carry = 0
while(True):
	line = raw_input("")
	entrada = line.split()
	f1 = entrada[0]
	f2 = entrada[1]
	if(int(f1) == 0 and int(f2) ==0):
			break

	else:
	
		for i in range(8,-1,-1):
			n = int(f1[i])
			m = int(f2[i])
			if(len(f1) > len(f2)):
				f2 += "0"
			suma = n+m+carry
			carry = 0
			if(suma >= 10):
	  			cont += 1
	  			carry += 1 	
	 	 	suma = 0
	  		

	  	if(cont == 0):
	  		print("No carry operation.")
	  	else:		
	  		print(str(cont) +" "+ "carry operations.")
	  		cont = 0
	  	
  	

