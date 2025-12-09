package ecommerce.product;

 public class Product {
    String name;
    int price;

   public Product(String name,int price){
       this.name = name;
       this.price = price;
    }

    public void display(){
        System.out.println("Product is  "+name+" and  price is "+price);
    }
}



