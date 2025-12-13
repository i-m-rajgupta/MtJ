package shopping;

public class Cart1 {
    // Product p = new Product(); This all are unaccessible now due to 
    // public void showCart(){
    //     System.out.println(p.name);
    //     System.out.println(p.price);
    //     p.display();
    // }

   public Cart1(){
        System.out.println("This is another cart in different package in which we have not access to product class");
    }

}
