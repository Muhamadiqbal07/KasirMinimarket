package KasirMinimarket;

import java.util.ArrayList; // Import library untuk ArrayList

// Deklarasi class login
public class Login {
    private ArrayList<Kasir> daftarKasir;   // Menyimpan data kasir ke dalam ArrayList
    // Constructor login()
    public Login() {
        daftarKasir = new ArrayList<>();    // Inisialisasi objek ArrayList

        // Menambahkan data kasir ke dalam ArrayList
        daftarKasir.add(new KasirMember("KS001", "Andriyawan", "andri", "09876"));
        daftarKasir.add(new KasirMember("KS002", "Muhamad Iqbal", "iqbal", "10293"));
    }

    // Method autentikasi() untuk memeriksa apakah username dan password sesuai dengan yang ada pada data kasir
    public Kasir autentikasi(String username, String password) {

        // Looping untuk cek seluruh data
        for (Kasir k : daftarKasir) {
            if (k.getUsername().equals(username)
                    && k.getPassword().equals(password)) {
                return k;
            }
        }
        return null;    // Mengembalikan nilai NULL sebagai data tidak ditemukan dan program akan berhenti
    }
}
