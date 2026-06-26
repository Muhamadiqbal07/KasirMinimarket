package KasirMinimarket;

public class KasirMember extends Kasir {

    public KasirMember(String kodeKasir, String namaKasir, String username, String password) {
        super(kodeKasir, namaKasir, username, password);
    }

    public double hitungDiskon(double total) {
        if (total >= 100000) {
            return total * 0.10;
        }
        return 0;
    }
}
