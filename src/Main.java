package KasirMinimarket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login login = new Login();

        System.out.println("===== LOGIN KASIR =====");
        System.out.print("Username : ");
        String username = input.nextLine();
        System.out.print("Password : ");
        String password = input.nextLine();

        Kasir kasir = login.autentikasi(username, password);

        if (kasir == null) {
            System.out.println("Login gagal!");
            return;
        }

        int pilih;

        do {
            System.out.println();
            System.out.println("===== SISTEM KASIR MINIMARKET =====");
            System.out.println("1. Input transaksi dan print struk");
            System.out.println("2. Keluar");
            System.out.print("Pilih : ");

            pilih = Integer.parseInt(input.nextLine());

            switch (pilih) {
                case 1:
                    Transaksi trx = new Transaksi();
                    trx.inputBarang();

                    double grandTotal = trx.getGrandTotal(kasir);

                    System.out.println();
                    System.out.println("Grand Total : Rp" + grandTotal);

                    System.out.print("Uang Bayar: ");
                    double bayar = Double.parseDouble(input.nextLine());
                    trx.cetakStruk(kasir, bayar);

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
