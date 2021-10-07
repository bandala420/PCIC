clc; clear all;

W = -pi:pi/180:pi-pi/180;
Z1 = -1;
Z2 = 0.9*exp(-i*pi/4);
Z3 = 0.9*exp(i*pi/4);
Z = exp(i*W);

aZ1 = abs(Z-Z1);
aZ2 = abs(Z-Z2);
aZ3 = abs(Z-Z3);

figure();
plot(W,aZ1);
hold on;
plot(W,aZ2,'r');
plot(W,aZ3,'g');

aZT = (aZ1)./(aZ2.*aZ3);
plot(W,aZT,'k');