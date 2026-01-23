import java.util.*;

class LocationTracker{
    private static class LocationPoint{
    int longitude;
    int latitude;
    LocationPoint(int longitude,int latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String toString(){
        return "("+longitude+","+latitude+")";
    }
}

private LocationPoint currentLocationPoint;
   private ArrayDeque<LocationPoint> locations;
     
   LocationTracker(int longitude,int latitude){
       locations = new ArrayDeque<>();
       currentLocationPoint = new LocationPoint(longitude, latitude);
       locations.push(currentLocationPoint);
   }

   public void visit(int longitude,int latitude){
    LocationPoint newLocation = new LocationPoint(longitude,latitude);
    locations.push(newLocation);
    currentLocationPoint = newLocation;
    System.out.println("Visited : "+currentLocationPoint);
   }
    
   public LocationPoint back(){
    if(locations.size() > 1){
     locations.pop();
     currentLocationPoint = locations.peek();
     return currentLocationPoint;
    }
    return null;
   }

   public LocationPoint getCurrentLocation(){
    return currentLocationPoint;
   }

   public boolean isEmpty(){
    return locations.isEmpty();
   }
}
public class Dec16 {
    public static void print(Stack<Integer> stack){
       if(stack.isEmpty()){
        return;
       }
        System.out.println("After filtering the Deck : ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }
    public static void deckFilter(Stack<Integer> stack , int val){
        if(stack.isEmpty()){
            return;
        } 

        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            if(stack.peek() <= val){
              temp.push(stack.pop());
            }else{
                stack.pop();
            }
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        print(stack);
    }
    public static void greaterTemp(int[] temp){
         int[] res = new int[temp.length];
         Stack<Integer> stack = new Stack<>();

         for(int i = 0;i<temp.length;i++){
            while (!stack.empty() && temp[i]>temp[stack.peek()]) {
                int index = stack.pop();
                res[index] = i-index;
            }
            stack.push(i);
         }

         for(int i=0;i<temp.length;i++){
            if(res[i] != 0){
            System.out.println("Next warmer temp for "+temp[i]+" is "+temp[i+res[i]]+" and is after "+res[i]+" days ");
            }else{
                System.out.println("No next warmer day exists for "+temp[i]);
            }
         }
    }

    class CarParking{
        private Stack<String> lane = new Stack<>();
        CarParking(String car){
           enters(car);
        }
 
        public void enters(String car){
            lane.push(car);
            System.out.println("Car enters "+car);
        }

        public void leaves(){
            if(!lane.empty()){
            System.out.println("Car leaves : "+lane.pop());
            }else{
                System.out.println("No car is parked in the lane ");
            }
        }

        public String lastCar(){
            if(isEmpty()){
             System.out.println("No car is parked in the lane");
             return null;
            }
            return lane.peek();
        }

        public boolean isEmpty(){
            return lane.empty();
        }
    }


    class Drawing{
        private class Stroke {
            private String description;
        
           public Stroke(String desc){
                description = desc;
            }
            public String getDescription(){
                return description;
            }

            public String toString(){
                return description;
            }
        }

        public class DrawingApp{
          private  Stack<Stroke> undo ;
          private Stack<Stroke> redo ;

          public DrawingApp(){
            undo = new Stack<>();
            redo = new Stack<>();
          }

            public void draw(String desc){
                 Stroke newStroke = new Stroke(desc);
                 undo.push(newStroke);
                 redo.clear();
            }

            public void undo(){
                if(undo.empty()){
                    System.out.println("Nothing to undo ");
                    return;
                }
                Stroke lastStroke = undo.pop();
                redo.push(lastStroke);
                updateCanvas();
            }

            public void redo(){
                if(redo.empty()){
                    System.out.println("Nothing to redo ");
                    return;
                }
                Stroke redoStroke = redo.pop();
                undo.push(redoStroke);
                updateCanvas();
            }

            public void updateCanvas(){
                System.out.println("Canvas updated : "+ undo);
            }
        }

    }
    public static void main(String[] args) {
        // Implement a stack to track visited locations in a map navigation app.
        LocationTracker tracker = new LocationTracker(52, 58);
        tracker.visit(58, 89);
             System.out.println(tracker.getCurrentLocation());
        System.out.println(tracker.back());
        System.out.println(tracker.getCurrentLocation());
        System.out.println(tracker.back());
        System.out.println(tracker.getCurrentLocation());
       System.out.println( tracker.isEmpty());

    //    Using a stack, remove all cards greater than a given value from a deck.
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(8);
        stack.push(2);
        stack.push(7);
        stack.push(6);
        stack.push(4);
        deckFilter(stack, 4);

        // Find the next greater/warmer temperature for each day using a stack.
        int temp[] = {60,62,65,61,64,70};
        greaterTemp(temp);

        //  Simulate parking cars in a narrow lane where cars leave in reverse order.
        Dec16 obj = new Dec16();
         CarParking lane = obj.new CarParking("maruti");
         lane.enters("Bmw");
         lane.enters("Mercedes");
         lane.leaves();
         System.out.println(lane.lastCar());
        System.out.println(lane.isEmpty());
        lane.leaves();
        lane.leaves();
        System.out.println(lane.lastCar());

        // Implement an undo-redo feature for a drawing mobile app using two stacks.
        Drawing d = obj.new Drawing();
        Drawing.DrawingApp app = d.new DrawingApp();

        app.draw("Line a to b");
        app.draw("circle of dia 2.5");
        app.draw("rectangle of length 7 and breadth 8");
        app.undo();
        app.undo();
        app.redo();
        app.draw("sqaure of length 4");
        app.redo();
        app.undo();
           app.undo();
              app.undo();
                 app.undo();
    }
}
