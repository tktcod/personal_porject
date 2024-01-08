package kiosk;

public class Product extends Menu {
    private Integer price;

    public Product(String name, Integer price, String description, String category) {
        super(name, description, category);
        setPrice(price);
    }

    // get 메소드
    public Integer getPrice() {
        return price;
    }

    // set 메소드
    public void setPrice(Integer price) {
        this.price = price;
    }
}

