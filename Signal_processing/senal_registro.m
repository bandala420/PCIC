%TAREA SE�AL REGISTRO
clc
n=0:599;
x = registro1;

%X[n]
figure();
stem(n,x,'filled');
grid on; title('Se�al Original (X[n])'); 
xlabel('Muestra (n)'); ylabel('Se�al Registro (X[n])');

%Y1[n]
figure();
stem(n+100,x,'filled');
grid on; title('Desplazamiento de Se�al (Y1 = X[n-100])'); 
xlabel('Muestra (n)'); ylabel('Se�al (Y1[n])');

%Y2[n]
figure();
stem(-n,x,'filled');
grid on; title('Reflexi�n de Se�al (Y2 = X[-n])'); 
xlabel('Muestra (n)'); ylabel('Se�al (Y2[n])');

%Y3[n]
y3 = zeros(1,300);
i=1;
while (i<301)
    y3(i) = registro1(2*i);
    i=i+1;
end
figure();
stem(y3,'filled');
grid on; title('Submuestreo de Se�al (Y3 = X[2n])'); 
xlabel('Muestra (n)'); ylabel('Se�al (Y3[n])');

%Y4[n]
figure();
stem(n,(1/2)*x,'filled');
grid on; title('Escalado de Se�al (Y4 = (1/2)X[n])'); 
xlabel('Muestra (n)'); ylabel('Se�al (Y4[n])');

%Y5[n]
figure();
stem(n,(3/2)*x,'filled');
grid on; title('Escalado de Se�al (Y5 = (3/2)X[n])'); 
xlabel('Muestra (n)'); ylabel('Se�al (Y5[n])');

%Y6[n]
figure();
z = (n<=299).*(-1) + (n>=300).*(1);
stem(n,x.*z,'filled');
grid on; title('Producto de Se�al (Y6 = X[n]Z[n])'); 
xlabel('Muestra (n)'); ylabel('Se�al (Y6[n])');
