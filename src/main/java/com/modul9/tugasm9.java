package com.modul9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Manusia {
    String nama;
    String alamat;
    String jenisKelamin;

    public Manusia(String nama, String alamat, String jenisKelamin) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
    }
}

class Mahasiswa extends Manusia {
    String NIM;
    String programStudi;
    String jurusan;

    public Mahasiswa(String nama, String alamat, String jenisKelamin, String NIM, String programStudi, String jurusan) {
        super(nama, alamat, jenisKelamin);
        this.NIM = NIM;
        this.programStudi = programStudi;
        this.jurusan = jurusan;
    }
}

public class tugasm9 {
    static List<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static final String DATA_MAHASISWA_FILE_PATH = "C:/Users/asephs/OneDrive/Documents/Praktikum PBO/demo/data_mahasiswa.txt";

    public static void main(String[] args) {
        bacaDataDariFile();
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    inputMahasiswa();
                    break;
                case 2:
                    tampilkanMahasiswa();
                    break;
                case 3:
                    System.out.println("Keluar dari program...");
                    simpanDataKeFile();
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 3);

        scanner.close();
    }

    static void tampilkanMenu() {
        System.out.println("\nMENU PILIHAN");
        System.out.println("1. Input Data Mahasiswa");
        System.out.println("2. Lihat Data Mahasiswa");
        System.out.println("3. Keluar Program");
        System.out.print("Pilihan Anda : ");
    }

    static void inputMahasiswa() {
        System.out.println("\nInput Data Mahasiswa");
        System.out.print("Nama : ");
        String nama = scanner.nextLine();
        System.out.print("Alamat : ");
        String alamat = scanner.nextLine();
        System.out.print("Jenis Kelamin (L/P): ");
        String jenisKelamin = scanner.nextLine();
        System.out.print("NIM : ");
        String NIM = scanner.nextLine();
        System.out.print("Program Studi : ");
        String programStudi = scanner.nextLine();
        System.out.print("Jurusan : ");
        String jurusan = scanner.nextLine();

        Mahasiswa mahasiswa = new Mahasiswa(nama, alamat, jenisKelamin, NIM, programStudi, jurusan);
        daftarMahasiswa.add(mahasiswa);
        System.out.println("Data mahasiswa berhasil ditambahkan!");
    }

    static void tampilkanMahasiswa() {
        System.out.println("\nData Mahasiswa:");
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Data mahasiswa kosong!");
        } else {
            for (Mahasiswa mahasiswa : daftarMahasiswa) {
                System.out.println("Nama: " + mahasiswa.nama);
                System.out.println("Alamat: " + mahasiswa.alamat);
                System.out.println("Jenis Kelamin: " + mahasiswa.jenisKelamin);
                System.out.println("NIM: " + mahasiswa.NIM);
                System.out.println("Program Studi: " + mahasiswa.programStudi);
                System.out.println("Jurusan: " + mahasiswa.jurusan);
                System.out.println("--------------------");
            }
        }
    }

    static void simpanDataKeFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_MAHASISWA_FILE_PATH))) {
            for (Mahasiswa mahasiswa : daftarMahasiswa) {
                writer.write(mahasiswa.nama + "," + mahasiswa.alamat + "," + mahasiswa.jenisKelamin + ","
                        + mahasiswa.NIM + "," + mahasiswa.programStudi + "," + mahasiswa.jurusan);
                writer.newLine();
            }
            System.out.println("Data berhasil disimpan ke file.");
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menyimpan data ke file: " + e.getMessage());
        }
    }

    static void bacaDataDariFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_MAHASISWA_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    Mahasiswa mahasiswa = new Mahasiswa(data[0], data[1], data[2], data[3], data[4], data[5]);
                    daftarMahasiswa.add(mahasiswa);
                }
            }
            System.out.println("Data berhasil dibaca dari file.");
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat membaca data dari file: " + e.getMessage());
        }
    }
}
