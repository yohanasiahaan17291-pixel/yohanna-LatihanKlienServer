package com.pbi.tk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Client.java
 * Bagian "client tier" dari arsitektur two-tier.
 * Bertugas: membuka koneksi ke server, mengirim pesan,
 * lalu menampilkan balasan dari server.
 */
public class Client {
    public static void main(String[] args) {
        // Keluaran Identitas (Tugas Praktikum Minggu 1)
        System.out.println("=== APLIKASI CLIENT ===");
        System.out.println("Nama  : Yohanna Enesia Roma Anggi Siahaan");
        System.out.println("NIM   : 25110089");
        System.out.println("Kelas : Teknik Komputer B Pagi");
        System.out.println("---------------------------------------");

        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Terhubung ke server " + host + ":" + port);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Mengirim pesan ke server
            out.println("Halo dari Client!");

            // Menerima balasan dari server
            String response = in.readLine();
            System.out.println("Pesan dari Server: " + response);

        } catch (IOException e) {
            System.out.println("Gagal terhubung ke server: " + e.getMessage());
        }
    }
}