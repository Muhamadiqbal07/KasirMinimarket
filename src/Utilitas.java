package KasirMinimarket;

import java.time.LocalDateTime;             // Import library untuk tanggal dan waktu
import java.time.format.DateTimeFormatter;  // Import library untuk format tanggal dan waktu
import java.util.Random;                    // Import library untuk random generator

// Deklarasi class utilitas
public class Utilitas {
    // Method getDateTime()
    public static String getDateTime() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  // Menentukan format tanggal dan waktu
        return LocalDateTime.now().format(format);  // Mengembalikan tanggal dan waktu sekarang
    }

    // Method generateKodeUnik()
    // Format kode XX-XXXX dengan XX sebagai huruf kapital acak dan XXXX sebagai 4 digit angka acak
    public static String generateKodeUnik() {
        Random r = new Random();    // Deklarasi objek random
        char a = (char) ('A' + r.nextInt(26));  // Huruf pertama (A-Z)
        char b = (char) ('A' + r.nextInt(26));  // Huruf kedua (A-Z)
        int angka = 1000 + r.nextInt(9000); // Angka acak dengan range 1000 hingga 9999
        return "" + a + b + "-" + angka;    // Menggabungkan kode
    }

    // Method getNamaFileStruk()
    public static String getNamaFileStruk() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");  // Menentukan format tanggal dan waktu untuk file
        return "Struk_" + LocalDateTime.now().format(format) + ".txt";  // Mengembalikan nama file struk
    }
}
