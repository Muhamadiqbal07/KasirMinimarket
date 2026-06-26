package KasirMinimarket;

import java.util.ArrayList;

public class Login {
    private ArrayList<Kasir> daftarKasir;
    public Login() {
        daftarKasir = new ArrayList<>();
        daftarKasir.add(new KasirMember("KS001", "Andriyawan", "andri", "09876"));
        daftarKasir.add(new KasirMember("KS002", "Muhamad Iqbal", "iqbal", "10293"));
    }
    public Kasir autentikasi(String username, String password) {
        for (Kasir k : daftarKasir) {
            if (k.getUsername().equals(username)
                    && k.getPassword().equals(password)) {
                return k;
            }
        }
        return null;
    }
}
