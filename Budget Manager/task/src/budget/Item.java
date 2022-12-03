package budget;

public class Item implements Comparable<Item> {
    private String name;
    private float price;

    public Item(String name, float price) {
        setName(name);
        setPrice(price);
    }

    public float getPrice() {
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString(String separator) {
        return "%s%s%.2f".formatted(this.name, separator, this.price);
    }

    @Override
    public int compareTo(Item item) {
        return Float.compare(this.price, item.price);
    }
}
