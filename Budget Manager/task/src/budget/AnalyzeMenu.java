package budget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static budget.Data.types;

public class AnalyzeMenu {
    private static final Menu analyzeMenu = new Menu("How do you want to sort?");
    private static boolean isPopulated = false;

    private static final Runnable sortAllRunnable = () -> {
        float total = 0;
        List<Item> items = new ArrayList<>();
        for (Type type : types.values()) {
            items.addAll(type.getItems());
            total += type.getTotal();
        }
        if (items.size() != 0){
            System.out.println("All:");
            items.sort(Collections.reverseOrder());
            items.forEach(item -> System.out.println(item.toString(" $")));
            System.out.printf("Total sum: $%.2f%n%n", total);
        } else {
            System.out.println("The purchase list is empty!\n");
        }
    };

    private static final Runnable sortByTypeRunnable = () -> {
        System.out.println("Types:");
        float total = 0;
        List<Type> typeList = new ArrayList<>();
        for (Map.Entry<Integer, Type> entry : types.entrySet()) {
            typeList.add(entry.getValue());
            total += entry.getValue().getTotal();
        }
        typeList.sort(Collections.reverseOrder());
        typeList.forEach(type -> System.out.printf("%s - $%.2f%n", type.getName(), type.getTotal()));
        System.out.printf("Total sum: $%.2f%n%n", total);
    };

    public static void populateMenu() {
        analyzeMenu.add(1, new Action("Sort all purchases", sortAllRunnable));
        analyzeMenu.add(2, new Action("Sort by type", sortByTypeRunnable));
        analyzeMenu.add(3, new Action("Sort certain type", SortTypeMenu::display));
        analyzeMenu.add(4, new Action("Back"));
    }

    public static void display() {
        if (!isPopulated) {
            populateMenu();
            isPopulated = true;
        }
        analyzeMenu.display();
    }
}
