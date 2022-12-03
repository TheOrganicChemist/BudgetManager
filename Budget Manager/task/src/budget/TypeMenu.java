package budget;

import java.util.Map;

import static budget.Data.types;

abstract public class TypeMenu {
    private static final Menu typeMenu = new Menu("Choose the type of purchase");
    private static boolean isPopulated = false;

    private static final Runnable backRunnable = () -> {};
    public static void populateMenu() {
        for (Map.Entry<Integer,Type> entry: types.entrySet()) {
            Runnable runnable = () -> Data.addPurchase(entry.getValue());
            typeMenu.add(entry.getKey(), new Action(entry.getValue().getName(), runnable));
        }
        typeMenu.add(5, new Action("Back"));
    }

    public static void display() {
        if (!isPopulated) {
            populateMenu();
            isPopulated = true;
        }
        typeMenu.display();
    }
}
