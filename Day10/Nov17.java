
class Calculator{
    String model;

    Calculator(String model){
        this.model = model;
    }

    int operation(int a,int b){
        class Addition{
            int add(int a,int b){
               return a+b;
            }
        }

        Addition ad = new Addition();
        return ad.add(a, b);
    }
}

class Shop{
    String name;

    Shop(String name){
        this.name = name;
    }

    int bill(){
        class Item{
            String name;
            int price;
            int quantity;

            Item(String name,int price,int quantity){
                this.name = name;
                this.price = price;
                this.quantity = quantity;
            }

            int calc(){
               return price*quantity;
            }
        }

        Item i = new Item("Bread", 50, 25);
        return i.calc();
    }
}

class Messenger{
    String app;
    Messenger(String app){
        this.app = app;
    }

   void sendMessage(){
    class Message{
        void print(){
            System.out.println("Sending Message by "+Messenger.this.app);
        }
    }

    Message msg = new Message();
    msg.print();
   }
}

class Maths{
   static class Factorial{
       static long compute(int n){
            long factorial =1;
            for(int i=n;i>0;i--){
               factorial *= i;
            }
            return factorial;
        }
    }
}

class Mobile{
    static class SimCard {
    String network ;
    SimCard(String network){
        this.network = network;
    }

    void showDetails(){
        System.out.println("This sim has network of "+network);
    }
    }
}

class Database{
    static class Config{
        void config(){
            System.out.println("Configuration details ..");
        }
    }
}
public class Nov17 {
    public static void main(String[] args) {
        // In a class Calculator, create a method operation() Inside it declare a local inner class Addition which adds two numbers. 
         Calculator calc = new Calculator("F-8080");
         System.out.println("Addition is "+calc.operation(10, 20));

        //  Create a class Shop with method bill(). Inside it create a method-local inner class Item having price and quantity. 
        // Return total bill.

        Shop s1 = new Shop("Asha Bakery");
        System.out.println("Amount to be paid "+s1.bill());

        // Create a method-local inner class Message inside Messenger.sendMessage() which prints “Sending message…”.
        Messenger m = new Messenger("Whatsapp");
        m.sendMessage();

        // Create a static nested class Maths.Factorial to compute factorial. Call it without creating object of outer class. 
        System.out.println("Factorial is "+Maths.Factorial.compute(5));

        //  Create a class Mobile with a static nested class SimCard. SimCard prints network name. 
        Mobile.SimCard sim = new Mobile.SimCard("Airtel");
        sim.showDetails();

        // Create a static nested class Database.Config Print configuration details. 
         Database.Config c = new Database.Config();
         c.config(); 
    }
}
