package com.modul10;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Posttestm10 extends JFrame implements ActionListener {

    private JLabel labelNama;
    private JTextField textFieldNama;
    private JButton buttonTampilkan;

    public Posttestm10() {
        // Mengatur judul JFrame
        super("Program GUI Sederhana");

        // Mengatur layout manager
        setLayout(new FlowLayout());

        // Membuat komponen JLabel
        labelNama = new JLabel("Masukkan nama Anda:");
        add(labelNama);

        // Membuat komponen JTextField
        textFieldNama = new JTextField(20);
        add(textFieldNama);

        // Membuat komponen JButton
        buttonTampilkan = new JButton("Tampilkan");
        add(buttonTampilkan);

        // Menambahkan ActionListener ke buttonTampilkan
        buttonTampilkan.addActionListener(this);

        // Mengatur ukuran dan posisi JFrame
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan teks dari textFieldNama
        String nama = textFieldNama.getText();

        // Menampilkan pesan dengan nama yang diinputkan
        JOptionPane.showMessageDialog(this, "Halo, " + nama + "!");
    }

    public static void main(String[] args) {
        // Membuat instance dari kelas ProgramGUI
        new Posttestm10();
    }
}