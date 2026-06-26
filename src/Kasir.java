package KasirMinimarket;

public class Kasir {

    protected String kodeKasir;
    protected String namaKasir;
    protected String username;
    protected String password;

    public Kasir(String kodeKasir, String namaKasir, String username, String password) {
        this.kodeKasir = kodeKasir;
        this.namaKasir = namaKasir;
        this.username = username;
        this.password = password;
    }

    public String getKodeKasir() {
        return kodeKasir;
    }

    public String getNamaKasir() {
        return namaKasir;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
