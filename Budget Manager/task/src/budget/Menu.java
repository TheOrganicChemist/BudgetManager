package budget;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final String header;
    private final boolean displayMenuAgain;

    public Menu(String header){
        this(header, true);
    }
    public Menu(String header, boolean displayMenuAgain){
        this.header = header;
        this.displayMenuAgain = displayMenuAgain;
    }
    private final Scanner scanner = new Scanner(System.in);
    private final LinkedHashMap<Integer, Action> actions = new LinkedHashMap<>();

    public void add(int optNum, Action action) {
        action.setMenu(this);
        actions.put(optNum, action);
    }

    public String getActionsList() {
        StringBuilder list = new StringBuilder();
        for (Map.Entry<Integer, Action> entry : this.actions.entrySet()) {
            list.append(String.format("%d) %s\n", entry.getKey(), entry.getValue().getName()));
        }
        return list.toString();
    }

    public Action getAction(int optNum) {
        return this.actions.get(optNum);
    }

    public void display() {
        System.out.println(header);
        System.out.print(this.getActionsList());
        this.chooseAction();
    }

    public void chooseAction() {
        int action = scanner.nextInt();
        System.out.println();
        if (actions.containsKey(action)) {
            this.getAction(action).execute(this.displayMenuAgain);
        } else {
            System.out.println("Wrong selection!\n");
        }
    }
}
