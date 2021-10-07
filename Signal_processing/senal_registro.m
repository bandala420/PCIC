%TAREA SEÑAL REGISTRO
clc
n=0:599;
x = registro1;

%X[n]
figure();
stem(n,x,'filled');
grid on; title('Señal Original (X[n])'); 
xlabel('Muestra (n)'); ylabel('Señal Registro (X[n])');

%Y1[n]
figure();
stem(n+100,x,'filled');
grid on; title('Desplazamiento de Señal (Y1 = X[n-100])'); 
xlabel('Muestra (n)'); ylabel('Señal (Y1[n])');

%Y2[n]
figure();
stem(-n,x,'filled');
grid on; title('Reflexión de Señal (Y2 = X[-n])'); 
xlabel('Muestra (n)'); ylabel('Señal (Y2[n])');

%Y3[n]
y3 = zeros(1,300);
i=1;
while (i<301)
    y3(i) = registro1(2*i);
    i=i+1;
end
figure();
stem(y3,'filled');
grid on; title('Submuestreo de Señal (Y3 = X[2n])'); 
xlabel('Muestra (n)'); ylabel('Señal (Y3[n])');

%Y4[n]
figure();
stem(n,(1/2)*x,'filled');
grid on; title('Escalado de Señal (Y4 = (1/2)X[n])'); 
xlabel('Muestra (n)'); ylabel('Señal (Y4[n])');

%Y5[n]
figure();
stem(n,(3/2)*x,'filled');
grid on; title('Escalado de Señal (Y5 = (3/2)X[n])'); 
xlabel('Muestra (n)'); ylabel('Señal (Y5[n])');

%Y6[n]
figure();
z = (n<=299).*(-1) + (n>=300).*(1);
stem(n,x.*z,'filled');
grid on; title('Producto de Señal (Y6 = X[n]Z[n])'); 
xlabel('Muestra (n)'); ylabel('Señal (Y6[n])');
