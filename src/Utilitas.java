package KasirMinimarket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utilitas {
    public static String getDateTime() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(format);
    }

    public static String generateKodeUnik() {
        Random r = new Random();
        char a = (char) ('A' + r.nextInt(26));
        char b = (char) ('A' + r.nextInt(26));
        int angka = 1000 + r.nextInt(9000);
        return "" + a + b + "-" + angka;
    }

    public static String getNamaFileStruk() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return "Struk_" + LocalDateTime.now().format(format) + ".txt";
    }
}
