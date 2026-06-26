package KasirMinimarket;

public class Barang {

    private String kodeBarang;
    private String namaBarang;
    private double harga;
    private int qty;

    public Barang(String kodeBarang, String namaBarang, double harga, int qty) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.qty = qty;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getHarga() {
        return harga;
    }

    public int getQty() {
        return qty;
    }

    public double getSubtotal() {
        return harga * qty;
    }
}
