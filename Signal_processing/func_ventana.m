%FUNCIONES DE FILTRO VENTANA

N=51;
figure();
subplot(2,2,1);
plot(hann(N),'-r')
title('FUNCI�N HAN');
grid on

subplot(2,2,2);
plot(hamming(N),'-r')
title('FUNCI�N HAMMING');
grid on

subplot(2,2,3);
plot(blackman(N),'-r')
title('FUNCI�N BLACKMAN');
grid on

subplot(2,2,4);
plot(bartlett(N),'-r')
title('FUNCI�N BARTLETT');
grid on