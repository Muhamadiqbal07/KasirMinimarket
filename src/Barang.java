package KasirMinimarket;

// Deklarasi class barang
public class Barang {
    private String kodeBarang;  // Menyimpan kode barang
    private String namaBarang;  // Menyimpan nama barang
    private double harga;       // Menyimpan harga barang
    private int qty;            // Menyimpan kuantitas

    // Constructor barang untuk inisialisasi data barang
    public Barang(String kodeBarang, String namaBarang, double harga, int qty) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.qty = qty;
    }

    // Getter kode barang
    public String getKodeBarang() {
        return kodeBarang;
    }

    // Getter nama barang
    public String getNamaBarang() {
        return namaBarang;
    }

    // Getter harga
    public double getHarga() {
        return harga;
    }

    // Getter kuantitas
    public int getQty() {
        return qty;
    }

    // Method getSubtotal() untuk menghitung dan mengembalikan nilai subtotal
    public double getSubtotal() {
        return harga * qty;
    }
}
