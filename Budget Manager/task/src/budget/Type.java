package budget;

import java.util.Collections;
import java.util.LinkedHashSet;

import static budget.Data.reduceBalance;

public class Type implements Comparable<Type> {
    private final String name;
    private final LinkedHashSet<Item> items = new LinkedHashSet<>() {
    };
    private float total = 0;

    public Type(String name) {
        this.name = name;
    }

    public void addItem(Item item) {
        items.add(item);
        updateTotal(item.getPrice());
    }

    public String toSortedList(){
        StringBuilder result = new StringBuilder();
        if (this.size() != 0) {
            result.append("%s:%n".formatted(this.name));
            items.stream().sorted(Collections.reverseOrder()).forEach(item -> result.append("%s%n".formatted(item.toString(" $"))));
            result.append("Total sum: $%.2f%n".formatted(this.total));
        } else {
            result.append("The purchase list is empty!\n");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("%s:%n".formatted(this.name));
        if (this.size() != 0) {
            result.append(getItemsList(" $"));
            result.append("Total sum: $%.2f%n".formatted(this.total));
        } else {
            result.append("The purchase list is empty!\n");
        }
        return result.toString();
    }

    public String getName() {
        return this.name;
    }

    public String getItemsList(String separator) {
        StringBuilder itemsList = new StringBuilder();
        this.items.forEach(item -> itemsList.append("%s%n".formatted(item.toString(separator))));
        return itemsList.toString();
    }

    public LinkedHashSet<Item> getItems(){
        return items;
    }

    public void updateTotal(float value) {
        this.total += value;
        reduceBalance(value);
    }

    public float getTotal() {
        return total;
    }

    public int size() {
        return items.size();
    }

    @Override
    public int compareTo(Type type) {
        return Float.compare(this.getTotal(), type.getTotal());
    }
}
