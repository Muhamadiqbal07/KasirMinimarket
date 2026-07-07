package KasirMinimarket;

// Deklarasi class kasirMember yang dimana turunan dari class kasir
public class KasirMember extends Kasir {
    // Constructor kasirMember untuk memanggil constructor dari class kasir, menggunakan 'super' untuk inisialisasi data kasir
    public KasirMember(String kodeKasir, String namaKasir, String username, String password) {
        super(kodeKasir, namaKasir, username, password);
    }
    
    // Method hitungDiskon() untuk menghitung besar diskon pada pelanggan 
    public double hitungDiskon(double total) {
        // Ketentuan harga jika total belanja di atas Rp100.000, maka diskon 10%
        if (total >= 100000) {
            return total * 0.10;
        }
        return 0;
    }
}
