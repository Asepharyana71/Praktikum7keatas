package com.praktikum7atas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class posttest9 {

    public static void main(String[] args) {
        // Nama file input dan output
        String inputFile = "C:/Users/asephs/OneDrive/Documents/Praktikum PBO/demo/input.txt";
        String outputFile = "C:/Users/asephs/OneDrive/Documents/Praktikum PBO/demo/output.txt";

        // Variabel untuk menyimpan jari-jari
        double radius = 0;

        // Membaca jari-jari dari file input
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line = reader.readLine();
            if (line != null) {
                radius = Double.parseDouble(line);
            } else {
                System.err.println("File input kosong.");
                return;
            }
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat membaca file input: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.err.println("Format angka tidak valid dalam file input: " + e.getMessage());
            return;
        }

        // Menghitung keliling dan luas lingkaran
        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;

        // Menulis hasil perhitungan ke file output
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("Jari-jari lingkaran: " + radius);
            writer.newLine();
            writer.write("Keliling lingkaran: " + circumference);
            writer.newLine();
            writer.write("Luas lingkaran: " + area);
            System.out.println("Hasil perhitungan telah disimpan ke file output.");
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menulis ke file output: " + e.getMessage());
        }
    }
}
