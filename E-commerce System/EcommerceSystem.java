import java.util.*;
import java.lang.*;

public class EcommerceSystem {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Welcome to the E-commerce System :");

        ElectronicProduct ep=new ElectronicProduct(1,"smartphone",599.9,"samsung",1);
        ClothingProduct cp=new ClothingProduct(2,"T-shirt",19.9,"Medium","cotton");
        BookProduct bp=new BookProduct(3,"oop",39.99,"O'reily","X publications");

        Customer customer=new Customer();
        System.out.println("Please enter customer name : ");
        String customerName=in.nextLine();
        customer.setName(customerName);

        System.out.println("Please enter customer address : ");
        String customeraddress=in.nextLine();
        customer.setAddress(customeraddress);

        System.out.println("Please enter customer ID : ");
        int customerID=in.nextInt();
        customer.setCustomerID(customerID);

        Cart cr1=new Cart();
        System.out.println("How many products do you want to add to your cart :");
        int nproducts=in.nextInt();
        cr1.setnProduccts(nproducts);
        cr1.addProduct();
        System.out.print("Your total price is ");
        cr1.calculatePrice();
        System.out.println();
        if(nproducts>0) {
            System.out.println("DO you want to place order ? \n 1- Yes 2- No");
            int placeOrde = in.nextInt();
            if(cr1.placeOrder(placeOrde)==true) {
                Order order1 = new Order();
                order1.printOrderInfo();
                customer.CustomerInfo();
                System.out.println();
                cr1.getProducts();
                cr1.calculatePrice();

            }
            else System.out.println("Orde canceled.");

        }

































    }
}


