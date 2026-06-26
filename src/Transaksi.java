package KasirMinimarket;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Transaksi {
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    public void inputBarang() {
        Scanner input = new Scanner(System.in);
        String lagi;

        do {
            try {

                System.out.print("Kode Barang (13 digit): ");
                String kode = input.nextLine();
                if (kode.length() != 13) {
                    throw new Exception("Kode barang harus 13 digit!");
                }

                System.out.print("Nama Barang : ");
                String nama = input.nextLine();
                System.out.print("Harga : ");
                double harga = Double.parseDouble(input.nextLine());
                System.out.print("Qty : ");
                int qty = Integer.parseInt(input.nextLine());

                daftarBarang.add(new Barang(kode, nama, harga, qty));

            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
            System.out.print("Ingin menginput lagi (Y/T)? : ");
            lagi = input.nextLine();
        } while (lagi.equalsIgnoreCase("Y"));
    }
    public double getGrandTotal(Kasir kasir) {

        double total = 0;

        for (Barang b : daftarBarang) {
            total += b.getSubtotal();
        }
        double diskon = 0;

        if (kasir instanceof KasirMember) {
            diskon = ((KasirMember) kasir).hitungDiskon(total);
        }

        return total - diskon;
    }

    public void cetakStruk(Kasir kasir, double bayar) {
        double total = 0;

        for (Barang b : daftarBarang) {
            total += b.getSubtotal();
        }

        double diskon = 0;

        if (kasir instanceof KasirMember) {
            diskon = ((KasirMember) kasir).hitungDiskon(total);
        }

        double totalBayar = total - diskon;
        double kembali = bayar - totalBayar;

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

    public void simpanStrukTxt(
        Kasir kasir,
        double bayar,
        String namaFile) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile));

            double total = 0;

            for (Barang b : daftarBarang) {
                total += b.getSubtotal();
            }

            double diskon = 0;

            if (kasir instanceof KasirMember) {
                diskon = ((KasirMember) kasir).hitungDiskon(total);
            }

            double grandTotal = total - diskon;
            double kembali = bayar - grandTotal;

            writer.write("----- STRUK TRANSAKSI -----");
            writer.newLine();
            writer.write(Utilitas.getDateTime() + " / 1.0.0 / " + Utilitas.generateKodeUnik() + " / " + kasir.getNamaKasir() + " / " + kasir.getKodeKasir());
            writer.newLine();
            writer.write("------------------------------------------------------------------");
            writer.newLine();
            writer.write(String.format("%-25s %-8s %-12s %-12s", "NAMA BARANG", "QTY", "HARGA", "SUBTOTAL"));
            writer.newLine();

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
            writer.close();

            System.out.println("Struk berhasil disimpan ke file " + namaFile);

        } catch (IOException e) {
            System.out.println("Gagal menyimpan struk: " + e.getMessage());
        }
    }
}
