package budget;

import java.util.Map;

import static budget.Data.types;

abstract public class ShowListMenu {
    private static final Menu showListMenu = new Menu("Choose the type of purchases");
    private static boolean isPopulated = false;
    private static final Runnable showAllRunnable = () -> {
        System.out.println("All:");
        float total = 0;
        for (Type type : types.values()) {
            System.out.print(type.getItemsList(" $"));
            total += type.getTotal();
        }
        System.out.printf("Total sum: $%.2f%n%n", total);
    };

    public static void populateMenu() {
        for (Map.Entry<Integer,Type> entry: types.entrySet()) {
            Runnable runnable = () -> System.out.println(entry.getValue().toString());
            showListMenu.add(entry.getKey(), new Action(entry.getValue().getName(), runnable));
        }
        showListMenu.add(5, new Action("All", showAllRunnable));
        showListMenu.add(6, new Action("Back"));
    }

    public static void display() {
        if (!isPopulated) {
            populateMenu();
            isPopulated = true;
        }
        showListMenu.display();
    }
}
