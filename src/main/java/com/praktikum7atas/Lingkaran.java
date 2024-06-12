package com.praktikum7atas;

public class Lingkaran extends BangunDatar {
    double jari;
    Lingkaran(double jari){
        this.jari = jari;
    }
    double luas(){
        return Math.PI * jari * jari;
    }
    double keliling(){
        return 2 * Math.PI * jari;
    }
    
}
