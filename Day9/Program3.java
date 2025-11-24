
class Animal{
    int legs ;
    String color ;
    void show(){
        System.out.println("This is an animal");
    }
}

class Dog extends Animal{
    void print(){
        System.out.println("This is a dog");
    }
    void sound(){
        System.out.println("Dog sound barks");
    }
}

class Cat extends Animal{
    void print(){
        System.out.println("This is a cat");
    }
    void sound(){
        System.out.println("Cat sound meow ");
    }
}
class Vehicle{
    int wheels = 4;
    int max_speed  ;
    void show(){
        System.out.println(this.wheels+" "+this.max_speed);
    }
} 

class Bike extends Vehicle{
    int model_no;
    String model_name;
    String color;
    
    void print(){
        System.out.println(model_no+" "+model_name+" "+color);
    }
}

class Truck extends Vehicle{
    int model_no;
    String model_name;
    String color;
    
    void print(){
        System.out.println(model_no+" "+model_name+" "+color);
    }
}

class Person{
    int legs =2 ;
    String gender = "Male" ;
    int height = 170;

    Person(){
        System.out.println("Person is called ");
    }
     void show(){
        System.out.println(legs+" "+gender+" "+height);
     }
}

class Man extends Person{
    String color ;
    int age;
    String name;
    String nature;

    Man(String n,String c,String na,int a){
     System.out.println("Hello "+n);
      color = c;
      age = a;
      nature = na;
      name = n;
    }

    void print(){
    System.out.println("MAn details "+name+" "+color+" "+nature+" "+age);
    }

}



public class Program3{
public static void main(String[] args) {
//  Inheritance in Oops -> Simple , multilevel ,heirachical ,hybrid and multiple

// Simple Inhertance Person -> Man

Man m1 = new Man("Anu", "fair", "sweet", 89);
m1.height = 167;
m1.legs = 2;
m1.show();
m1.print();

//    Animal -> Dog     Simple Inheritance 1 parent class -> 1 single child class
//    Animal -> Dogs ,Animal -> cat Heirierchical Inheritance  1 parent class -> mltiple child class
    // Dog d1 = new Dog();
    // Dog d2 = new Dog();

    // Cat c1 = new Cat();
    // Cat c2 = new Cat();

    // d1.legs = 4;
    // d1.color = "black";
    // d2.legs =4;
    // d2.color = "brown";
    // System.out.println("D1 details "+d1.legs+" and "+d1.color);
    //     System.out.println("D2 details "+d2.legs+" and "+d2.color);
    // d1.show();
    // d2.show();
    // d1.print();
    // d2.sound();

    // c1.legs = 4;
    // c1.color = "white";
    // c1.show();
    // c1.sound();
    // System.out.println(c1.color+" "+c1.legs);
    // c2.color = "red";
    // c2.legs = 3;
    // c2.show();
    // c2.print();

    // Vehicle  wheels max speed show -> bike model no color model name truck 
    //  Bike b1 = new Bike();
    //  b1.model_name = "Hero";
    //  b1.model_no = 123;
    //  b1.color = "black";
    //  b1.wheels = 2;
    //  b1.max_speed = 160;

    //  b1.show();
    //  b1.print();

    //  Truck t1 = new Truck();
    //  t1.color = "brown";
    //  t1.model_name = "Ashok leyland";
    //  t1.model_no =456;
    //  t1.max_speed = 150;
    //  t1.wheels = 16;

    //  t1.show();
    //  t1.print();
    
}
 }




