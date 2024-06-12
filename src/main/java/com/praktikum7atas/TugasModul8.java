package com.praktikum7atas;

// Interface Mahasiswa
interface Mahasiswa {
    void belajar();
    void ujian();
}

// Interface Atlit
interface Atlit {
    void latihan();
    void bertanding();
}

// Interface Wiraswasta
interface Wiraswasta {
    void cariIde();
    void jalankanBisnis();
}

// Kelas MahasiswaSuper mengimplementasikan ketiga interface
class MahasiswaSuper implements Mahasiswa, Atlit, Wiraswasta {
    public void belajar() {
        System.out.println("Asep Haryana Saputra sedang belajar dengan giat...");
    }

    public void ujian() {
        System.out.println("Asep Haryana Saputra sedang menghadapi ujian dengan tenang...");
    }

    public void latihan() {
        System.out.println("Asep Haryana Saputra sedang berlatih untuk kompetisi mendatang...");
    }

    public void bertanding() {
        System.out.println("Asep Haryana Saputra berjuang keras dalam pertandingan!");
    }

    public void cariIde() {
        System.out.println("Asep Haryana Saputra sedang mencari ide bisnis yang inovatif...");
    }

    public void jalankanBisnis() {
        System.out.println("Asep Haryana Saputra menjalankan bisnisnya dengan penuh semangat!");
    }
}

public class TugasModul8 {
    public static void main(String[] args) {
        // Instansiasi objek MahasiswaSuper dengan nama Asep Haryana Saputra
        MahasiswaSuper asep = new MahasiswaSuper();

        // Asep melakukan kegiatan sebagai Mahasiswa
        asep.belajar();
        asep.ujian();

        // Asep melakukan kegiatan sebagai Atlit
        asep.latihan();
        asep.bertanding();

        // Asep melakukan kegiatan sebagai Wiraswasta
        asep.cariIde();
        asep.jalankanBisnis();
    }
}