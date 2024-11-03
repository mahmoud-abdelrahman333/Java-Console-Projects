import java.util.*;

public class Cart  {
   private int customerID;
    private int nProduccts;
    Product []products = new Product[nProduccts+20];
    Scanner in = new Scanner(System.in);

    public int getCustomerID() {

        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = Math.abs(customerID);
    }

    public int getnProduccts() {
        return nProduccts;
    }

    public void setnProduccts(int nProduccts) {
        this.nProduccts = Math.abs(nProduccts);
    }

    public void addProduct(){
        for (int i=0 ; i<nProduccts ; i++){
            products[i]=new Product();
            System.out.println("Enetr the product "+(i+1)+" name , id ans price :");
            String name=in.next();
            int id=in.nextInt();
            double price=in.nextDouble();
            products[i].name=name;
            products[i].productID=id;
            products[i].price=price;
        }
    }
    public void getProducts(){
        for (int i=0 ; i<nProduccts ; i++){
            if(products[i].productID==-1)
                continue;
            if(i==0) System.out.println("products list :");
            System.out.println("Product "+(i+1)+" :");
            System.out.println("ID : "+products[i].productID);
            System.out.println("Name : "+products[i].name);
            System.out.println("Price : "+products[i].price+"\n");
        }

    }

    public void removeProduct(){
        System.out.println("Enter the ID of product to be removed :");
        int id=in.nextInt();
        for (int i=0 ; i<nProduccts ; i++){
            if(products[i].productID==id){
                products[i].productID=-1;
                break;
            }
        }
    }


    public void calculatePrice(){
        double totalPrice=0;
        for (int i=0 ; i<nProduccts ; i++)
            if(products[i].productID!=-1)
            totalPrice+=products[i].price;

        System.out.println( "Total price : "+totalPrice);
    }

    public boolean placeOrder(int x){
        if(x==1) return true;
        else return false;
    }

}





