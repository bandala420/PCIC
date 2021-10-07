%FUNCIONES DE FILTRO VENTANA

N=51;
figure();
subplot(2,2,1);
plot(hann(N),'-r')
title('FUNCIÓN HAN');
grid on

subplot(2,2,2);
plot(hamming(N),'-r')
title('FUNCIÓN HAMMING');
grid on

subplot(2,2,3);
plot(blackman(N),'-r')
title('FUNCIÓN BLACKMAN');
grid on

subplot(2,2,4);
plot(bartlett(N),'-r')
title('FUNCIÓN BARTLETT');
grid on