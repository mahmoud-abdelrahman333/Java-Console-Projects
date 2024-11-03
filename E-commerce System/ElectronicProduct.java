public class ElectronicProduct extends Product{

    private String brand;
    private int warrantyPeriod;


    public ElectronicProduct(int productID, String name, double price, String brand, int warrantyPeriod) {
        super(productID, name, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyPeriod() {

        return Math.abs(warrantyPeriod);
    }

    public void setWarrantyPeriod(int warrantyPeriod)
    {
        this.warrantyPeriod = Math.abs(warrantyPeriod);
    }
}
