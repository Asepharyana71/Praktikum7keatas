package com.praktikum7atas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BiodataMahasiswa extends JFrame implements ActionListener {

    JLabel lNim, lNama, lAlamat, lJenisKelamin, lProgramStudi, lJurusan;
    JTextField tfNim, tfNama, tfAlamat;
    JRadioButton rbPria, rbWanita;
    JComboBox cbProgramStudi, cbJurusan;
    JButton btnSimpan, btnBacaData, btnKeluar;

    public BiodataMahasiswa() {
        setTitle("Form Biodata Mahasiswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2));

        // Label and Text Fields
        lNim = new JLabel("NIM");
        tfNim = new JTextField();
        lNama = new JLabel("Nama");
        tfNama = new JTextField();
        lAlamat = new JLabel("Alamat");
        tfAlamat = new JTextField();

        // Radio Buttons
        lJenisKelamin = new JLabel("Jenis Kelamin");
        rbPria = new JRadioButton("Pria");
        rbWanita = new JRadioButton("Wanita");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbPria);
        bg.add(rbWanita);

        // Combo Boxes
        lProgramStudi = new JLabel("Program Studi");
        cbProgramStudi = new JComboBox(new String[]{"S1", "S2", "S3"});
        lJurusan = new JLabel("Jurusan");
        cbJurusan = new JComboBox(new String[]{"Sistem Informasi", "Teknik Informatika", "Ilmu Komputer"});

        // Buttons
        btnSimpan = new JButton("Simpan");
        btnBacaData = new JButton("Baca Data");
        btnKeluar = new JButton("Keluar");

        // Add components to the frame
        add(lNim);
        add(tfNim);
        add(lNama);
        add(tfNama);
        add(lAlamat);
        add(tfAlamat);
        add(lJenisKelamin);
        add(rbPria);
        add(rbWanita);
        add(lProgramStudi);
        add(cbProgramStudi);
        add(lJurusan);
        add(cbJurusan);
        add(btnSimpan);
        add(btnBacaData);
        add(btnKeluar);

        // Add action listener to buttons
        btnSimpan.addActionListener(this);
        btnBacaData.addActionListener(this);
        btnKeluar.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSimpan) {
            // Simpan data
            String nim = tfNim.getText();
            String nama = tfNama.getText();
            String alamat = tfAlamat.getText();
            String jenisKelamin = rbPria.isSelected() ? "Pria" : "Wanita";
            String programStudi = (String) cbProgramStudi.getSelectedItem();
            String jurusan = (String) cbJurusan.getSelectedItem();

            // Do something with the data
            JOptionPane.showMessageDialog(this, "Data telah disimpan!\n" +
                    "NIM: " + nim + "\n" +
                    "Nama: " + nama + "\n" +
                    "Alamat: " + alamat + "\n" +
                    "Jenis Kelamin: " + jenisKelamin + "\n" +
                    "Program Studi: " + programStudi + "\n" +
                    "Jurusan: " + jurusan);
        } else if (e.getSource() == btnBacaData) {
            // Baca data
            // Implementasi logic untuk membaca data
            JOptionPane.showMessageDialog(this, "Fitur Baca Data belum diimplementasikan.");
        } else if (e.getSource() == btnKeluar) {
            // Keluar dari program
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new BiodataMahasiswa();
    }
}