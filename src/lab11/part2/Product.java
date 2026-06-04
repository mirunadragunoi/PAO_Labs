package lab11.part2;

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int stock;

    // constructor fara id pt insert
    public Product(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // constructor complet pt citirile din db
    public Product(int id, String name, String category, double price, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // getteri
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    // setteri
    public void setId(int id) { this.id = id; }
    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "[PRODUS!!!] --->> id = " + id + " name = " + name + " category = "
                + category + " price = " + price + " stock = " + stock;
    }
}