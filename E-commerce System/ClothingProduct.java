public class ClothingProduct extends Product{
    private  String size;
    private  String fabric;


    public ClothingProduct(int productID, String name, double price, String size, String fabric) {
        super(productID, name, price);
        this.size = size;
        this.fabric = fabric;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }
}
