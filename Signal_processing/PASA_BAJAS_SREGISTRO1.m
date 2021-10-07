%FILTRO PASABAJAS CON VENTANA RECTANGULAR
clc;
load('ECGa3.mat');

n = 0:599;
x_n = registro1;

%SUBMUESTREO DE SEÑAL
x2_n = zeros(1,300);
x2_n(1) = x_n(1);
for i = 1:299
    x2_n(i+1) = x_n(2*i+1);
end

%DISEÑO DE FILTRO
Oc = (1.1*pi)/6;
M = 28;
h_n = (sin(Oc.*(n-M)))./(pi.*(n-M));
h_n(M+1) = Oc/pi;
w_n = 1.*(n<57);
hr_n = h_n.*w_n;
Hr_z = fft(hr_n);
X_z = fft(x_n);
X2_z = fft(x2_n);

%FILTRO DE SEÑAL Y GRAFICAS
y_n = ifft(X_z.*Hr_z);

figure();
subplot(3,1,1);
plot(n,h_n,'-r');
grid on;
subplot(3,1,2);
plot(n,w_n,'-b');
grid on;
subplot(3,1,3);
plot(n,hr_n,'-k');
grid on;

figure();
subplot(3,1,1);
plot(n,abs(X_z),'-r');
grid on;
title('Respuesta en Frecuencia de Señal (Magnitud)');
subplot(3,1,2);
plot(n,abs(Hr_z),'-b');
grid on;
title('Respuesta en Frecuencia de Filtro (Magnitud)');
subplot(3,1,3);
plot(n,abs(Hr_z).*abs(X_z),'-k');
grid on;
title('Respuesta en Frecuencia de Señal Filtrada (Magnitud)');

figure();
subplot(2,1,1);
plot(n,x_n,'-r');
grid on;
title('SEÑAL SIN FILTRO');
subplot(2,1,2);
plot(n,y_n,'-k');
grid on;
title('SEÑAL CON FILTRO');
