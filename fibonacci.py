#!/usr/bin/python
# -*- coding: utf-8 -*-
# Program to display the Fibonacci sequence up to n-th term
import time

nterms = int(input("N: "))
# first two terms
n1, n2, nth = 0, 1, 1
count = 0

# time counter
start = time.time()

# check if the number of terms is valid
if nterms <= 0:
   print("Please enter a positive integer")
# if there is only one term, return n1
elif nterms == 1:
   print("Fibonacci sequence upto",nterms,":")
   print(n1)
# generate fibonacci sequence
else:
   #print("Fibonacci sequence:")
   print("Calculando...")
   for i in range(nterms):
      #print(n1)
      nth = n1 + n2
      # update values
      n1 = n2
      n2 = nth
      count += 1
elapsedTime = time.time() - start
print("N-esimo término de la serie de Fibonacci: "+str(nth)+"  ("+str(round(elapsedTime,4))+" s)")
