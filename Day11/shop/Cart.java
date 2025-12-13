package shop;

public class Cart {
    Product p = new Product(); 
    public void showCart(){
        System.out.println(p.name);
        System.out.println(p.price);
        p.display();
    }
}
