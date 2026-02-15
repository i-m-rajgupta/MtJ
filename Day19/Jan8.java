import java.security.KeyStore.Entry;
import java.util.*;
public class Jan8 {
    public static int maxProfit(int []stocks){
           int profit = 0,buy =0;
           boolean isBought = false;
           for(int i = 0;i<stocks.length;i++){
            if(i == stocks.length -1){
                if(isBought && stocks[i]>buy){
                    profit += stocks[i]-buy;
                }
                break;
            }
           if(isBought){
            if(stocks[i+1]<stocks[i]){
               profit += stocks[i] - buy;
               isBought = false;
            }
           }else{
             if(stocks[i]<stocks[i+1]){
                buy = stocks[i];
                isBought = true;
             }
            }
           }
           return profit;
    }

    public static int minTap(int n,int range[]){
        int maxReach[] = new int[n];
        for(int i = 0;i<range.length;i++){
            int left = Math.max(0, i-range[i]);
            int right = Math.min(n,i+range[i]);
            maxReach[left] = Math.max(maxReach[left], right);
        }
       
        int farthest =0,currentEnd =0;
        int taps = 0;
        for(int i =0;i<maxReach.length;i++){
            farthest = Math.max(farthest, maxReach[i]);

            if(farthest <= i){
                return -1;
            }

            if(currentEnd == i){
                currentEnd=farthest;
                taps++;
            }
        }
       return taps;
    }

    public static void partitionLabel(String str){
        if(str.length() == 0){
            return;
        }

        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i<str.length();i++){
             char c = str.charAt(i);
            map.putIfAbsent(c,0);
            map.replace(c, i);
        }

       ArrayList<Integer> res = new ArrayList<>();
       int currBoundary =0;
       int length =0;
        for(int i =0;i<str.length();i++){
            length++;
            char c = str.charAt(i);
            if(map.get(c) > currBoundary){
                currBoundary = map.get(c);
            }
            
            if(currBoundary == i){
                res.add(length);
                length = 0;
                if(i != str.length()-1){
                currBoundary = map.get(str.charAt(i+1));
                }
            }
        }
        System.out.println(res);
    }

    static class Employee implements Comparable<Employee>{
        double quality,wage;
        double ratio;
        Employee(double quality,double wage){
            this.quality = quality;
            this.ratio = wage/quality;
            this.wage = wage;
        }

        public int compareTo(Employee e){
            return (int)( this.ratio - e.ratio);
        }

        public String toString(){
            return "Employee ("+quality+","+wage+","+ratio+")";
        }
    }
    public static double minimumSalary(int quality[],int wage[],int k ){
       if(quality.length == 0){
        return 0;
       }

       if(quality.length != wage.length){
        System.out.println("Some data is missing !!");
        return -1;
       }

       double minSalary = 0;
       if(k == wage.length){
         for(int i = 0;i<wage.length;i++){
            minSalary += wage[i];
         }
         return minSalary;
       }

       Employee employees[] = new Employee[quality.length];
       for(int i = 0;i<employees.length;i++){
        employees[i] = new Employee(quality[i], wage[i]);
       }

       Arrays.sort(employees);

      PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
double totalQuality = 0,minCost = Double.MAX_VALUE;
   for(Employee employee : employees){
    totalQuality += employee.quality;
    System.out.println(employee);
    pq.offer(employee.quality);
    if(pq.size() >k){
      totalQuality -= pq.poll();
    }

    if(pq.size() == k){
        minCost = Math.min(minCost, (totalQuality*employee.ratio));
    }
   }
       return minCost;
    }
    public static void main(String[] args) {
        // Implement buy and sell stock to maximize profit (multiple transactions).
        int stock[] = {12,26,86,78,69};
        int stock1[] = {7,5,3,4,6,9,8,3,1};
        int stock2[] = {2,5,3,4,7,9,6,8,5};
        System.out.println("Max profit : "+maxProfit(stock));
        System.out.println("Max profit : "+maxProfit(stock1));
        System.out.println("Max profit : "+maxProfit(stock2));

        // Write a Java program to minimum number of taps to water a garden.
       int range[] = {1,2,1,0,2,1,0,1};
    // with the help of range we find the radius of spreading the water in each point and then proceed further 
       System.out.println("Total taps : "+minTap(range.length-1, range));

    //    Implement partition labels problem.
    //  To ensure a character only appears in one partition containig the first occrence of c also conatains the last occurence of c
     String str = "ababcbacadefegdehijhklij";
     partitionLabel(str);
     partitionLabel("eccbbbbdec");
     partitionLabel("abc");

    //  Write a Java program to minimum cost to hire K workers.
    // In this each worker must receive the minimum wage expectation and pay must be proportional to the quality witihin the group(
    // same to quality ratio )

    int quality[] = {10,20,5};
    int wage[] = {70,50,30};
     int k =2 ;
    System.out.println( minimumSalary(quality, wage, k));
    }
}
