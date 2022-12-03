package budget;

abstract public class MainMenu {
    private static final Menu mainMenu = new Menu("Choose your action:");
    private static boolean isPopulated = false;
    public static void populateMenu() {
        mainMenu.add(1, new Action("Add income", Data::addIncome));
        mainMenu.add(2, new Action("Add purchase", TypeMenu::display));
        mainMenu.add(3, new Action("Show list of purchases", ShowListMenu::display));
        mainMenu.add(4, new Action("Balance", Data::showBalance));
        mainMenu.add(5, new Action("Save", FileManager::save));
        mainMenu.add(6, new Action("Load", FileManager::load));
        mainMenu.add(7, new Action("Analyze (Sort)", AnalyzeMenu::display));
        mainMenu.add(0, new Action("Exit"));
        Data.populateTypes();
    }

    public static void display() {
        if (!isPopulated) {
            populateMenu();
            isPopulated = true;
        }
        mainMenu.display();
    }
}
