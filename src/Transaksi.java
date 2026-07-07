package KasirMinimarket;

import java.util.ArrayList;     // Import library untuk ArrayList
import java.util.Scanner;       // Import library untuk scanner input

// Import library untuk eksekusi file
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;     // Import library untuk pencegahan error

// Deklarasi class transaksi
public class Transaksi {
    private ArrayList<Barang> daftarBarang = new ArrayList<>(); // Menyimpan seluruh barang yang telah diinput

    // Method inputBarang()
    public void inputBarang() {
        Scanner input = new Scanner(System.in); // Deklarasi objek scanner
        String lagi; // Deklarasi variabel

        // Looping menggunakan do while
        do {
            // Exception menggunakan try catch
            try {
                // Input kode barang
                System.out.print("Kode Barang (13 digit): ");
                String kode = input.nextLine();
                // Validasi kode barang 13 digit
                if (kode.length() != 13) {
                    throw new Exception("Kode barang harus 13 digit!");
                }
                // Input nama barang
                System.out.print("Nama Barang : ");
                String nama = input.nextLine();
                // Input harga
                System.out.print("Harga : ");
                double harga = Double.parseDouble(input.nextLine());
                // Input qty
                System.out.print("Qty : ");
                int qty = Integer.parseInt(input.nextLine());

                daftarBarang.add(new Barang(kode, nama, harga, qty));   // Menyimpan data ke dalam ArrayList

            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());    // Menangani semua kesalahan input
            }

            // Menanyakan apakah ingin input lagi
            System.out.print("Ingin menginput lagi (Y/T)? : ");
            lagi = input.nextLine();
        } while (lagi.equalsIgnoreCase("Y"));
    }

    // Method getGrandTotal()
    public double getGrandTotal(Kasir kasir) {

        double total = 0; // Deklarasi nilai awal

        // Menghitung total seluruh subtotal barang
        for (Barang b : daftarBarang) {
            total += b.getSubtotal();
        }
        double diskon = 0; // Deklarasi nilai awal

        // Jika kasir menggunakan kasirMember, maka hitung diskon
        if (kasir instanceof KasirMember) {
            diskon = ((KasirMember) kasir).hitungDiskon(total);
        }

        return total - diskon;  // Mengembalikan nilai total akhir
    }

    // Method cetakStruk()
    public void cetakStruk(Kasir kasir, double bayar) {
        double total = 0;   // Deklarasi nilai awal

        // Menghitung total seluruh subtotal barang
        for (Barang b : daftarBarang) {
            total += b.getSubtotal();
        }

        double diskon = 0; // Deklarasi nilai awal

        // Jika kasir menggunakan kasirMember, maka hitung diskon
        if (kasir instanceof KasirMember) {
            diskon = ((KasirMember) kasir).hitungDiskon(total);
        }

        double totalBayar = total - diskon;     // Menghitung total pembayaran
        double kembali = bayar - totalBayar;    // Menghitung kembalian

        // OUTPUT
        System.out.println();
        System.out.println("----- STRUK TRANSAKSI -----");
        System.out.println(Utilitas.getDateTime() + " / 1.0.0 / " + Utilitas.generateKodeUnik() + " / " + kasir.getNamaKasir() + " / " + kasir.getKodeKasir());
        System.out.println("------------------------------------------------------------------");

        System.out.printf("%-25s %-8s %-12s %-12s\n", "NAMA BARANG", "QTY", "HARGA", "SUBTOTAL");

        for (Barang b : daftarBarang) {
            System.out.printf("%-25s %-8d %-12.0f %-12.0f\n", b.getNamaBarang(), b.getQty(), b.getHarga(), b.getSubtotal());
        }

        if (diskon > 0) {
            System.out.printf("%48s %-12.0f\n", "VOUCHER/DISKON :", diskon);
        }

        System.out.println("------------------------------------------------------------------");
        System.out.printf("%65s %.0f\n", "TOTAL BELANJA :", totalBayar);
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%65s %.0f\n", "TUNAI :", bayar);
        System.out.printf("%65s %.0f\n", "KEMBALI :", kembali);
        System.out.printf("%65s %.0f\n", "ANDA HEMAT :", diskon);
        System.out.println();
        System.out.println("=== TERIMA KASIH TELAH BERBELANJA ===");
    }

    // Method simpanStrukTxt()
    public void simpanStrukTxt(Kasir kasir, double bayar, String namaFile) {
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile));   // Membuat objek writer untuk menulis file

            double total = 0;

            // Menghitung total transaksi
            for (Barang b : daftarBarang) {
                total += b.getSubtotal();
            }

            double diskon = 0;

            if (kasir instanceof KasirMember) {
                diskon = ((KasirMember) kasir).hitungDiskon(total);
            }

            double grandTotal = total - diskon;
            double kembali = bayar - grandTotal;

            // Menulis seluruh isi struk ke dalam file
            writer.write("----- STRUK TRANSAKSI -----");
            writer.newLine();
            writer.write(Utilitas.getDateTime() + " / 1.0.0 / " + Utilitas.generateKodeUnik() + " / " + kasir.getNamaKasir() + " / " + kasir.getKodeKasir());
            writer.newLine();
            writer.write("------------------------------------------------------------------");
            writer.newLine();
            writer.write(String.format("%-25s %-8s %-12s %-12s", "NAMA BARANG", "QTY", "HARGA", "SUBTOTAL"));
            writer.newLine();

            // Menulis seluruh daftar barang
            for (Barang b : daftarBarang) {
                writer.write(String.format("%-25s %-8d %-12.0f %-12.0f", b.getNamaBarang(), b.getQty(), b.getHarga(), b.getSubtotal()));
                writer.newLine();
            }

            if (diskon > 0) {
                writer.write(String.format("%48s %-12.0f", "VOUCHER/DISKON :", diskon));
                writer.newLine();
            }
            writer.write("------------------------------------------------------------------");
            writer.newLine();
            writer.write(String.format("%65s %.0f", "TOTAL BELANJA :", grandTotal));
            writer.newLine();
            writer.write(String.format("%65s %.0f", "TUNAI :", bayar));
            writer.newLine();
            writer.write(String.format("%65s %.0f", "KEMBALI :", kembali));
            writer.newLine();
            writer.write(String.format("%65s %.0f", "ANDA HEMAT :", diskon));
            writer.newLine();
            writer.newLine();
            writer.write("=== TERIMA KASIH TELAH BERBELANJA ===");
            writer.close();     // Menutup file agar data tersimpan

            System.out.println("Struk berhasil disimpan ke file " + namaFile);  // Pesan untuk struk berhasil disimpan ke dalam file

        } catch (IOException e) {
            System.out.println("Gagal menyimpan struk: " + e.getMessage()); // Menangani kesalahan saat proses menyimpan file
        }
    }
}
