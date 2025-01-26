import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"Ahmet");
        map.put(2,"Mehmet");

        System.out.println(map.size());
        map.remove(2);
        System.out.println(map);
        //map.clear();

        for (int key : map.keySet()) {

            System.out.println(map.get(key));
        }


    }
}