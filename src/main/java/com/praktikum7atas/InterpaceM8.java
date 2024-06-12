package com.praktikum7atas;

// Interface untuk informasi umum suku
interface InformasiSuku {
    String getNamaSuku();
    String getLokasi();
    int getPopulasi();
    String getBahasa();
    String getAgama();
    String getMataPencaharian();
}

// Interface untuk informasi budaya suku
interface BudayaSuku {
    String getSistemKepercayaan();
    String getAdatIstiadat();
    String getKesenian();
}

// Implementasi Interface untuk Suku Baduy
class SukuBaduy implements InformasiSuku, BudayaSuku {
    @Override
    public String getNamaSuku() {
        return "Baduy";
    }

    @Override
    public String getLokasi() {
        return "Lebak, Banten, Indonesia";
    }

    @Override
    public int getPopulasi() {
        return 12000; // perkiraan
    }

    @Override
    public String getBahasa() {
        return "Bahasa Sunda dialek Baduy";
    }

    @Override
    public String getAgama() {
        return "Sunda Wiwitan";
    }

    @Override
    public String getMataPencaharian() {
        return "Bertani dan berkebun";
    }

    @Override
    public String getSistemKepercayaan() {
        return "Menghormati alam dan leluhur";
    }

    @Override
    public String getAdatIstiadat() {
        return "Hidup sederhana, menolak teknologi modern, tradisi Seba";
    }

    @Override
    public String getKesenian() {
        return "Menenun kain, musik tradisional, tari-tarian";
    }
}

public class InterpaceM8 {
    public static void main(String[] args) {
        SukuBaduy baduy = new SukuBaduy();

        // Menampilkan informasi Suku Baduy
        System.out.println("Nama Suku: " + baduy.getNamaSuku());
        System.out.println("Lokasi: " + baduy.getLokasi());
        System.out.println("Populasi: " + baduy.getPopulasi());
        System.out.println("Bahasa: " + baduy.getBahasa());
        System.out.println("Agama: " + baduy.getAgama());
        System.out.println("Mata Pencaharian: " + baduy.getMataPencaharian());
        System.out.println("Sistem Kepercayaan: " + baduy.getSistemKepercayaan());
        System.out.println("Adat Istiadat: " + baduy.getAdatIstiadat());
        System.out.println("Kesenian: " + baduy.getKesenian());
    }
}