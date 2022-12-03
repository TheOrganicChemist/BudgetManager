package budget;

import java.util.HashMap;
import java.util.Scanner;

public class Data {
    private static final Scanner scanner = new Scanner(System.in);
    public static float balance = 0F;
    protected static final HashMap<Integer, Type> types = new HashMap<>();

    public static void populateTypes(){
        types.put(1, new Type("Food"));
        types.put(2, new Type("Clothes"));
        types.put(3, new Type("Entertainment"));
        types.put(4, new Type("Other"));
    }
    protected static void addIncome() {
        System.out.println("Enter income:");
        balance += scanner.nextFloat();
        System.out.println("Income was added!\n");
    }

    protected static void addPurchase(Type type) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter purchase name:");
        String name = scanner1.nextLine();
        System.out.println("Enter its price:");
        float price = Float.parseFloat(scanner1.nextLine());
        type.addItem(new Item(name, price));
        System.out.println("Purchase was added!\n");
    }
    public static void reduceBalance(float amount){
        balance = balance >= 0F ? balance - amount : 0F;
    }
    protected static void showBalance() {
        System.out.printf("Balance: $%.2f%n%n", balance);
    }
}
