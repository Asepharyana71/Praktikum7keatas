package com.praktikum7atas;

public abstract class BangunDatar {
abstract double luas();
abstract double keliling();
void tampilLuas(double l){
    System.out.println("Luas = " + l);
}
void tampilKeliling(double k){
    System.out.println("Keliling = " + k);
}
static void staticMethod(){
    System.out.println("Static Method");
}

}
