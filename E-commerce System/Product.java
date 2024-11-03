public class Product {

     int productID;
    String  name;
    double price;

    public Product() {
    }

    public Product(int productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = Math.abs(productID);
    }

    public String getName() {
        return name;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public  void setPrice(float price) {
        this.price = Math.abs(price);
    }
}
