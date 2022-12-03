package budget;

import java.util.Map;

import static budget.Data.types;

public class SortTypeMenu {
    private static final Menu sortListMenu = new Menu("Choose the type of purchases", false);
    private static boolean isPopulated = false;


    public static void populateMenu() {
        for (Map.Entry<Integer,Type> entry: types.entrySet()) {
            Runnable runnable = () -> System.out.println(entry.getValue().toSortedList());
            sortListMenu.add(entry.getKey(), new Action(entry.getValue().getName(), runnable));
        }
    }

    public static void display() {
        if (!isPopulated) {
            populateMenu();
            isPopulated = true;
        }
        sortListMenu.display();
    }
}
