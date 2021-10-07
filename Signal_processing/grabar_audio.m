%GRABAR Y REPRODUCIR AUDIO UTILIZANDO LOS RECURSOS DE LA PC
tiempo = 2;
rec_objeto = audiorecorder(44100,24,1);

% grabar...
disp('Grabando...')
recordblocking(rec_objeto, 2);
disp('Grabación terminada.');
play(rec_objeto);
grabacion = getaudiodata(rec_objeto);
grabacion_frec = fft(grabacion);

%grafica en tiempo continuo
figure();
plot(0:(2/88199):2,grabacion);
grid on;
title('Señal en el Dominio del Tiempo');
xlabel('Tiempo (s)');
ylabel('Amplitud');
%grafica en tiempo discreto
figure();
stem(abs(grabacion_frec));
title('Señal en el Dominio de la Frecuencia');
xlabel('Muestras');
ylabel('Amplitud');
grid on;
%espectrograma de la señal
figure();
spectrogram(grabacion,500,400,500,44100);
