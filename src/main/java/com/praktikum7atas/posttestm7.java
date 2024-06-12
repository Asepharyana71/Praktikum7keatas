package com.praktikum7atas;


abstract class Hewan {
    private String nama;

    public Hewan(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    // Abstract method untuk mengeluarkan suara
    public abstract void bersuara();

    // Concrete method untuk menampilkan informasi hewan
    public void infoHewan() {
        System.out.println("Nama: " + nama);
        System.out.print("Suara: ");
        bersuara();
    }
}

class Kucing extends Hewan {
    public Kucing(String nama) {
        super(nama);
    }

    @Override
    public void bersuara() {
        System.out.println("Meong!");
    }
}

class Anjing extends Hewan {
    public Anjing(String nama) {
        super(nama);
    }

    @Override
    public void bersuara() {
        System.out.println("Guk! Guk!");
    }
}

public class posttestm7 {
    public static void main(String[] args) {
        Kucing kucing = new Kucing("Luna");
        Anjing anjing = new Anjing("Max");

        kucing.infoHewan();
        System.out.println();
        anjing.infoHewan();
    }
}