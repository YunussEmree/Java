public class Main {
    public static void main(String[] args) {

        int[] sayilar = {1,2,3};

        try {
            System.out.println(sayilar[5]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("An error accured: " + e);
        } catch (StringIndexOutOfBoundsException e){
            System.out.println(e);
        } catch (Exception e){
            System.out.println("Loglandı: " + e);
        }
        finally { //try catch den sonra bu kod bloğu çalışır.
            System.out.println("try catch den çıkıldı.");
        }

    }
}