package com.modul10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BiodataMahasiswa extends JFrame implements ActionListener {

    JLabel lNim, lNama, lAlamat, lJenisKelamin, lProgramStudi, lJurusan;
    JTextField tfNim, tfNama, tfAlamat;
    JRadioButton rbPria, rbWanita;
    JComboBox<String> cbProgramStudi, cbJurusan;
    JButton btnSimpan, btnBacaData, btnKeluar;

    List<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    static final String DATA_MAHASISWA_FILE_PATH = "C:/Users/asephs/OneDrive/Documents/Praktikum PBO/demo/datamodul10.txt";

    public BiodataMahasiswa() {
        setTitle("Form Biodata Mahasiswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(lNim = new JLabel("NIM"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(tfNim = new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(lNama = new JLabel("Nama"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(tfNama = new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(lAlamat = new JLabel("Alamat"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(tfAlamat = new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(lJenisKelamin = new JLabel("Jenis Kelamin"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(rbPria = new JRadioButton("Pria"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(rbWanita = new JRadioButton("Wanita"), gbc);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbPria);
        bg.add(rbWanita);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(lProgramStudi = new JLabel("Program Studi"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(cbProgramStudi = new JComboBox<>(new String[] { "S1", "S2", "S3" }), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        add(lJurusan = new JLabel("Jurusan"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(cbJurusan = new JComboBox<>(new String[] { "Sistem Informasi", "Teknik Informatika", "Ilmu Komputer" }),
                gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnSimpan = new JButton("Simpan"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnBacaData = new JButton("Baca Data"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnKeluar = new JButton("Keluar"), gbc);

        btnSimpan.addActionListener(this);
        btnBacaData.addActionListener(this);
        btnKeluar.addActionListener(this);

        setVisible(true);

        bacaDataDariFile();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSimpan) {
            String nim = tfNim.getText();
            String nama = tfNama.getText();
            String alamat = tfAlamat.getText();
            String jenisKelamin = rbPria.isSelected() ? "Pria" : "Wanita";
            String programStudi = (String) cbProgramStudi.getSelectedItem();
            String jurusan = (String) cbJurusan.getSelectedItem();

            Mahasiswa mahasiswa = new Mahasiswa(nama, alamat, jenisKelamin, nim, programStudi, jurusan);
            daftarMahasiswa.add(mahasiswa);
            simpanDataKeFile(mahasiswa);

            JOptionPane.showMessageDialog(this, "Data telah disimpan!\n" +
                    "NIM: " + nim + "\n" +
                    "Nama: " + nama + "\n" +
                    "Alamat: " + alamat + "\n" +
                    "Jenis Kelamin: " + jenisKelamin + "\n" +
                    "Program Studi: " + programStudi + "\n" +
                    "Jurusan: " + jurusan);
        } else if (e.getSource() == btnBacaData) {
            tampilkanMahasiswa();
        } else if (e.getSource() == btnKeluar) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new BiodataMahasiswa();
    }

    void bacaDataDariFile() {
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

    void tampilkanMahasiswa() {
        if (daftarMahasiswa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data mahasiswa kosong!");
        } else {
            StringBuilder dataMahasiswa = new StringBuilder();
            for (Mahasiswa mahasiswa : daftarMahasiswa) {
                dataMahasiswa.append("Nama: ").append(mahasiswa.nama).append("\n");
                dataMahasiswa.append("Alamat: ").append(mahasiswa.alamat).append("\n");
                dataMahasiswa.append("Jenis Kelamin: ").append(mahasiswa.jenisKelamin).append("\n");
                dataMahasiswa.append("NIM: ").append(mahasiswa.NIM).append("\n");
                dataMahasiswa.append("Program Studi: ").append(mahasiswa.programStudi).append("\n");
                dataMahasiswa.append("Jurusan: ").append(mahasiswa.jurusan).append("\n");
                dataMahasiswa.append("--------------------\n");
            }
            JOptionPane.showMessageDialog(this, dataMahasiswa.toString());
        }
    }

    void simpanDataKeFile(Mahasiswa mahasiswa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_MAHASISWA_FILE_PATH, true))) { // true untuk
                                                                                                           // append
                                                                                                           // data
            writer.write(mahasiswa.nama + "," +
                    mahasiswa.alamat + "," +
                    mahasiswa.jenisKelamin + "," +
                    mahasiswa.NIM + "," +
                    mahasiswa.programStudi + "," +
                    mahasiswa.jurusan + "\n");
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menyimpan data ke file: " + e.getMessage());
        }
    }
}

class Mahasiswa {
    String nama;
    String alamat;
    String jenisKelamin;
    String NIM;
    String programStudi;
    String jurusan;

    public Mahasiswa(String nama, String alamat, String jenisKelamin, String NIM, String programStudi, String jurusan) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.NIM = NIM;
        this.programStudi = programStudi;
        this.jurusan = jurusan;
    }
}
