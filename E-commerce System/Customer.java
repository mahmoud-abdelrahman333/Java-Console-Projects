public class Customer {
   private int customerID = 23011142;
    private  String name = "Mahmoud Abdelrahman Mahmoud";
    private String address;


    public Customer() {
        name = "Mahmoud Abdelrahman Mahmoud";
        customerID = 23011142;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = Math.abs(customerID);
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void CustomerInfo() {
        System.out.println("Customer name : "+getName());
        System.out.println("Customer ID : "+getCustomerID());
        System.out.println("Address : "+getAddress());
    }
}