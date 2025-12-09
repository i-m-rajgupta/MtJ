package ecommerce.cart;
import java.util.ArrayList;
import java.util.List;
import ecommerce.product.Product;

public class Cart {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product pro){
        products.add(pro);
    }

    public void showCart(){
        if(products.size() == 0){
            System.out.println("No product added to cart");
            return;
        }
        System.out.println(" Your cart");
        for(Product p:products){
            p.display();
        }
    }
}
