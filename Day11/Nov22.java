abstract class ATM{
    abstract void withdraw(int amount);
    abstract void checkBalance();

    public void welcomeMessage(){
        System.out.println("Welcome to the ATM");
    }
}

class SBIATM extends ATM{
    private String name = "SBI";
    private int balance =50000;

    void withdraw(int amount){
        if(amount<balance){
           balance -= amount;
           System.out.println("You have successfully withdraw the amount from "+name+" ATM ");
        }else{
            System.out.println("Not enough balance ");
        }
    }

    void checkBalance(){
        System.out.println("Your balance is : "+balance);
    }
}

class HDFCATM extends ATM{
    private String name = "HDFC";
    private int balance =80000;

    void withdraw(int amount){
        if(amount<balance){
           balance -= amount;
           System.out.println("You have successfully withdraw the amount from "+name+" ATM ");
        }else{
            System.out.println("Not enough balance ");
        }
    }

    void checkBalance(){
        System.out.println("Your balance is : "+balance);
    }
}

abstract class Vehicle{
    String fuel;
    abstract void start();
    abstract void stop();

    void fuelType(){
        System.out.println("This vehicle run on "+fuel);
    }
}

class Car extends Vehicle{
    Car(String fuelType){
        super.fuel = fuelType;
    }

    void start(){
        System.out.println("Car is starting..");
    }

    void stop(){
        System.out.println("Car is Stopped..");
    }
}

class Bike extends Vehicle{
    Bike(String fuelType){
        super.fuel = fuelType;
    }

    void start(){
        System.out.println("Bike is starting..");
    }

    void stop(){
        System.out.println("Bike is Stopped..");
    }
}

abstract class Payment{
    private String status = "success";
    abstract void pay(int amount);

    void paymentStatus(){
        System.out.println("Your payment status is : "+status);
    }
}

class UPIPayment extends Payment{
      void pay(int amount){
        System.out.println("You have paid the "+amount+" using the UPI payment");
      }
}

class CardPayment extends Payment{
      void pay(int amount){
        System.out.println("You have paid the "+amount+"  using the Card ");
      }
}

abstract class MediaPlayer{
    abstract void play();
    abstract void download();

    void connectToNetwork(){
        System.out.println("Connected to the network");
    }
}

class Spotify extends MediaPlayer{
   void play(){
    System.out.println("Song is played..");
   }

   void download(){
    System.out.println("Song is downloaded..");
   }
}

class YouTubeMusic extends MediaPlayer{
   void play(){
    System.out.println("Song is played..");
   }

   void download(){
    System.out.println("Song is downloaded..");
   }
}

abstract class DeliveryService{
    abstract void packOrder();
    abstract void shipOrder();

    void trackOrder(){
        System.out.println("Your order is reaching soon to you..");
    }
} 

class AmazonDelivery extends DeliveryService{
    void packOrder(){
        System.out.println("Your order is packed by Amazon ");
    }

    void shipOrder(){
        System.out.println("Your order is shipped ");
    }
}

class FlipkartDelivery extends DeliveryService{
    void packOrder(){
        System.out.println("Your order is packed by Flipkart ");
    }

    void shipOrder(){
        System.out.println("Your order is shipped ");
    }
}
public class Nov22 {
    public static void main(String[] args) {
        // Create an abstract class ATM with abstract methods:  abstract methods: withdraw(), checkBalance() implemented method: welcomeMessage() 
// And Create two child classes: SBIATM and HDFCATM 
       SBIATM s = new SBIATM();
       HDFCATM h = new HDFCATM();
           s.welcomeMessage();
       s.withdraw(500);
       h.welcomeMessage();
       h.withdraw(1000);
   
       s.checkBalance();
       h.checkBalance();

    //     Create an abstract class Vehicle with:  abstract methods: start(), stop() implemented method: fuelType() 
// Child classes: Car and Bike 
     Car c = new Car("Diesel");
     Bike b = new Bike("Petrol");
     c.start();
     c.stop();
     c.fuelType();
     b.start();
     b.stop();
     b.fuelType();
      
    //   Create an abstract class Payment with: abstract method: pay() implemented method: paymentStatus() 
// Child classes: UPIPayment and CardPayment 
    UPIPayment upi = new UPIPayment();
    CardPayment card = new CardPayment();
    upi.pay(5000);
    upi.paymentStatus();
    card.pay(60000);
    card.paymentStatus();

    // Create an abstract class MediaPlayer with: abstract methods: play(), download() implemented method: connectToNetwork() 
// Child classes: Spotify and YouTubeMusic 
     Spotify spotify = new Spotify();
     YouTubeMusic y = new YouTubeMusic();
     spotify.connectToNetwork();
     spotify.play();
     spotify.download();

     y.connectToNetwork();
     y.play();
     y.download();

    //   Create an abstract class DeliveryService with: abstract methods: packOrder(), shipOrder() implemented method: trackOrder() 
    // Child classes: AmazonDelivery and FlipkartDelivery 
     AmazonDelivery amazon = new AmazonDelivery();
     amazon.packOrder();
     amazon.shipOrder();
     amazon.trackOrder();

     FlipkartDelivery f = new FlipkartDelivery();
     f.packOrder();
     f.shipOrder();
     f.trackOrder();
    }
}
