import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList sayilar = new ArrayList();
        System.out.println(sayilar.size());
        sayilar.add(1);
        sayilar.add(10);
        System.out.println(sayilar.size());
        sayilar.add("Ankara");
        System.out.println(sayilar.size());
        System.out.println(sayilar.get(0));
        sayilar.set(0,100); // 0. indexteki elemanı 100 olarak değiştirdik
        System.out.println(sayilar.get(0));
        sayilar.remove(0); // 0. index silindi ve indexler birer kaydı
        System.out.println(sayilar.get(0));
        // sayilar.clear(); // listeyi tamamen boşalttık

        for (Object i : sayilar) {
            System.out.println(i);
        }
        
    }
}