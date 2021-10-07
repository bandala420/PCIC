#include <SPI.h>

int CS = 10;    // chip select
int Data = 11;  //MOSI serial data
int SCLK = 13;   // clock
SPISettings mysetting(20000000, MSBFIRST, SPI_MODE0);

const int N = 25;
int s_pin = A5;
int filtro_b = 4, filtro_val = 0;
int led_v = 5, led_r = 6;
boolean flag=false;
float X[N], h[N] = {-0.053051, 0, 0.061492, 0,
                     -0.068916, 0, 0.075026, 0,
                     -0.079577, 0, 0.082384, 0,
                      0.916666, 0, 0.082384, 0,
                     -0.079577, 0, 0.075026, 0,
                     -0.068916, 0, 0.061492, 0,
                     -0.053051};

float variable = 0;

void setup() {
  pinMode(CS,OUTPUT);
  pinMode(Data,OUTPUT);
  pinMode(SCLK,OUTPUT);
  pinMode(filtro_b, INPUT);
  Serial.begin(115200);
  SPI.begin();
  analogWrite(led_r,255);
}

void loop() {
  //float tiempo_i = micros();
  if (digitalRead(filtro_b) == HIGH) {
    while (digitalRead(filtro_b) == HIGH);
    flag = !flag;
  }
  if (flag == true) {
    analogWrite(led_r,0);
    analogWrite(led_v,255); 
    play_fsignal();
    flag = true;
    delayMicroseconds(3150);
  } else {
    analogWrite(led_r,255);
    analogWrite(led_v,0);
    play_signal();
    flag = false;
    delayMicroseconds(3898);
  }
  //float tiempo = micros() - tiempo_i;
  Serial.println(X[24]);
}

void play_signal() {
  float s_val = 0;
  byte conf = 0b00010000;
  //DESPLAZAMIENTO DE VECTOR DE SEÑAL
  for (int i=(N-1); i>0 ;i--) {
    X[i] = X[i-1];
  }
  s_val = analogRead(s_pin);
  //s_val = (s_val*4.4)/1024;
  X[0] = s_val;
  //TRANSMISION DE SEÑAL A DAC VIA SPI
  SPI.beginTransaction(mysetting);
  digitalWrite(CS,LOW);
  SPI.transfer(conf);
  SPI.transfer(X[24]*0.248);
  digitalWrite(CS,HIGH);
}

void play_fsignal() {
  float s_val = 0, sum = 0;
  byte conf = 0b00010000;
  //DESPLAZAMIENTO DE VECTOR DE SEÑAL
  for (int i=(N-1); i>0 ;i--) {
    X[i] = X[i-1];
  }
  s_val = analogRead(s_pin);
  //s_val = (s_val*4.4)/1024;
  X[0] = s_val;
  //CONVOLUCION DE SEÑAL - FILTRO
  sum = 0;
  for (int i=0; i<N ;i++) {
    sum = sum + X[i]*h[i];
  }
  X[24] = sum;
  //TRANSMISION DE SEÑAL A DAC VIA SPI
  SPI.beginTransaction(mysetting);
  digitalWrite(CS,LOW);
  SPI.transfer(conf);
  SPI.transfer(X[24]*0.248);
  digitalWrite(CS,HIGH);
}

