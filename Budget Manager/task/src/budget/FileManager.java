package budget;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static budget.Data.balance;
import static budget.Data.types;

public class FileManager {
    private static final File file = new File(".\\purchases.txt");

    public static void save() {
        StringBuilder text = new StringBuilder("%d%n".formatted(types.size()));
        types.values().forEach(type -> text.append("%d%n%s".formatted(type.size(), type.getItemsList("\n"))));
        text.append("%.2f".formatted(balance));
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(text.toString());
        } catch (IOException e) {
            System.out.printf("An exception occurred %s", e.getMessage());
        }
        System.out.println("Purchases were saved!\n");
    }

    public static void load() {
        try (Scanner scanner = new Scanner(file)) {
            int typesSize = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= typesSize; i++) {
                int itemsSize = Integer.parseInt(scanner.nextLine());
                for (int j = 0; j < itemsSize; j++) {
                    types.get(i).addItem(
                            new Item(scanner.nextLine(),
                                    Float.parseFloat(scanner.nextLine().replace(',', '.'))));
                }
            }
            balance = Float.parseFloat(scanner.nextLine().replace(',', '.'));
        } catch (IOException e) {
            System.out.printf("An exception occurred %s", e.getMessage());
        }
        System.out.println("Purchases were loaded!\n");
    }
}