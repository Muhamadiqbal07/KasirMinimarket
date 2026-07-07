package KasirMinimarket;

// Deklarasi class kasir
public class Kasir {
    protected String kodeKasir; // Menyimpan kode kasir
    protected String namaKasir; // Menyimpan nama kasir
    protected String username;  // Menyimpan username
    protected String password;  // Menyimpan password

    // Constructor kasir untuk inisialisasi seluruh data kasir
    public Kasir(String kodeKasir, String namaKasir, String username, String password) {
        this.kodeKasir = kodeKasir;
        this.namaKasir = namaKasir;
        this.username = username;
        this.password = password;
    }

    // Getter kode kasir
    public String getKodeKasir() {
        return kodeKasir;
    }

    // Getter nama kasir
    public String getNamaKasir() {
        return namaKasir;
    }

    // Getter username
    public String getUsername() {
        return username;
    }

    // Getter password
    public String getPassword() {
        return password;
    }
}
