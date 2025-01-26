import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> sehirler = new ArrayList<>();
        sehirler.add("Ankara");
        sehirler.remove(0);
        sehirler.clear();
        sehirler.add("Antalya");
        sehirler.add("Eskişehir");
        sehirler.add("Adana");

        for (String sehir : sehirler) {
            System.out.println(sehir);
        }
        Collections.sort(sehirler);

        for (String sehir : sehirler) {
            System.out.println(sehir);
        }
    }
}