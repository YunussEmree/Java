import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    ArrayList<Customer> customers = new ArrayList<>();

    customers.add(new Customer(1, "Yunus Emre", "Şenyiğit"));
    customers.add(new Customer(2, "Bekir", "Şenyiğit"));


    customers.remove(0);
        for (Customer customer : customers) {
            System.out.println(customer.firstname);
        }


    }

}