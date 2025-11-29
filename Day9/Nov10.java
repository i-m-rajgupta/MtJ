class Matrix{
       int arr1[][] ;
       int arr2[][] ;

       Matrix(int arr1[][] ,int[][] arr2){
        this.arr1 = arr1;
        this.arr2 = arr2;
       }

       boolean isEqualDimensions(int a[][],int b [][]){
           if(a.length != b.length){
            return false;
           }

           for(int i=0;i<a.length;i++){
            if(a[i].length != b[i].length){
            return false;
            }
           }

           return true;
       }
       int[][] add(){
        if(!isEqualDimensions(arr2, arr1)){
            System.out.println("Enter the same dimensions of matrix before using add().");
            return null;
        }
    
        int[][] sum = new int[arr1.length][];
        for(int i = 0;i<arr1.length;i++){
            sum[i] = new int[arr1[i].length];
            for(int j=0;j<arr1[i].length;j++){    
                sum[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return sum;
       }

       void print(int arr[][]){
        if(arr == null){
            System.out.println("Nothing to print .");
            return;
        }
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println(arr[i][j]);
            }
        }
       }
}

class Pen{
    String name ;
    int price ;
    String color;

    Pen(String name ,int price,String color){
        this.name = name;
        this.price = price;
        this.color = color;
    }

    void getColor(){
        System.out.println(color+" color pen ");
    }
}

class Agechecker {
    int age;

    Agechecker(int age){
        this.age = age;
        if(age<18){
            System.out.println("You are minor ");
        }else{
            System.out.println("You are an adult");
        }
    }
}
class Temperature{
    double celsius;
    double fahrenheit;
    Temperature(double celsius){
        this.celsius = celsius;
        this.fahrenheit = celsius*9/5 + 32;
        System.out.println(celsius+" celcus temperature in fahrenheit is : "+fahrenheit);
    }
}

class Square{
  
  Square(double side){
        System.out.println("Perimeter is "+4*side);
    }
}
public class Nov10 {
    public static void main(String[] args) {
        //  Create a class Matrix with constructor that accepts 2D array and a method to add matrices.
       int arr1[][] = {{1,2},{3,4,5}};
       int arr2[][] =  {{1,2},{3,4,5}};

       Matrix m = new Matrix(arr1, arr2);
       int sum[][] = m.add();
       m.print(sum);

    //    Create a class Pen with a constructor that initializes color. Print color.
    Pen p = new Pen("Butterflow", 10, "Blue");
    p.getColor();

//  Create a class AgeChecker with constructor that prints if person is adult or minor.
 Agechecker a = new Agechecker(19);
 Agechecker a2 = new Agechecker(14);

//  Create a class Temperature with constructor converting Celsius → Fahrenheit.
  Temperature t = new Temperature(37.5);

//   Create a class Square with constructor taking side. Method prints perimeter.
     Square side = new Square(4);
     
    }
}
