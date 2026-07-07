package KasirMinimarket;

import java.util.Scanner;   // Import library untuk scanner input

// Deklarasi class main
public class Main {
    // Method main yang akan dijalankan pertama kali
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);     // Deklarasi objek scanner
        Login login = new Login();                  // Deklarasi objek login

        // INPUT
        System.out.println("===== LOGIN KASIR =====");

        // Input username
        System.out.print("Username : ");
        String username = input.nextLine();
        // Input password
        System.out.print("Password : ");
        String password = input.nextLine();

        Kasir kasir = login.autentikasi(username, password);    // Proses autentikasi dengan eksekusi method autentikasi

        // Case jika data kasir tidak ditemukan maka akan menampilkan pesan dan program berhenti
        if (kasir == null) {
            System.out.println("Login gagal!");
            return;
        }

        int pilih;  // Deklarasi variabel pilih

        // Looping menggunakan do while 
        do {
            // Tampilan awal
            System.out.println();
            System.out.println("===== SISTEM KASIR MINIMARKET =====");
            System.out.println("1. Input transaksi dan print struk");
            System.out.println("2. Keluar");
            System.out.print("Pilih : ");

            pilih = Integer.parseInt(input.nextLine()); // Membaca input pilih

            // Menentukan proses pilih
            switch (pilih) {
                case 1:
                    Transaksi trx = new Transaksi();    // Deklarasi objek transaksi
                    trx.inputBarang();  // Input barang

                    double grandTotal = trx.getGrandTotal(kasir);   // Menghitung total pembayaran

                    // Output total pembayaran
                    System.out.println();
                    System.out.println("Grand Total : Rp" + grandTotal);

                    // Input uang bayar
                    System.out.print("Uang Bayar: ");
                    double bayar = Double.parseDouble(input.nextLine());
                    trx.cetakStruk(kasir, bayar);   // Menampilkan struk pembayaran

                    // Membuat nama file struk dan menyimpannya dalam format .txt
                    String namaFile = "KasirMinimarket/struk/" + Utilitas.getNamaFileStruk();
                    trx.simpanStrukTxt(kasir, bayar, namaFile);
                    break;
                case 2:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilih != 2);
    }
}
