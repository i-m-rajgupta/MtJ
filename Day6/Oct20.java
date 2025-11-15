import java.util.Scanner;

public class Oct20 {
    public static void main(String[] args) {
        //  Find the longest substring with all unique characters.

        int start =0,end=0,startIdx=0,endIdx=0;
        int  maxLength=0;
        int freq[] = new int[256];

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String s = sc.next();
        // for(end =0;end<s.length();end++){
        //     char ch= s.charAt(end);
        //     if(freq[ch] != 0){
        //         for(int i=start;i<end;i++){
        //           freq[s.charAt(i)] = 0;
        //         }
        //         freq[ch]++;
        //         start = end;
        //     }else{
        //         freq[ch]++;
        //     }
        //         if(maxLength<end-start+1 ){
        //             maxLength = end-start+1;
        //             startIdx = start;
        //             endIdx = end;  
        //         }
        // }
        // System.out.println("Length of Longest substring with all unique chars : "+maxLength+" and substring : ");
        // for(int i=startIdx;i<=endIdx;i++){
        //     System.out.print(s.charAt(i));
        // }

         start =0;end=0;startIdx=0;endIdx=0;
         int minLen =Integer.MAX_VALUE,count=0;
         int reqFreq[] = new int[256];
        //  Find the smallest substring of s that contains all characters of t.
        System.out.println("Enter the string to be found : ");
        String t = sc.next();
        for(int i=0;i<t.length();i++){
             reqFreq[t.charAt(i)]++; 
        }

           for(int i=0;i<t.length();i++){
            System.out.print( t.charAt(i)+""+reqFreq[t.charAt(i)]+" "); 
        }
        
        for(end =0;end<s.length();end++){
            char ch = s.charAt(end);

            if(reqFreq[ch] != 0){
                freq[ch]++;
                if(reqFreq[ch] == freq[ch]){
                count++;
                }
            }
            if(reqFreq[ch] != 0 && count == t.length()-1 && reqFreq[ch] < freq[ch]) {
                for(int i=start;i<end;i++){
                    char c = s.charAt(i);
                    if(reqFreq[c] != 0 && reqFreq[c] == freq[c]){
                        break;
                    }
                    if(reqFreq[c] !=0 && reqFreq[c] < freq[c]){
                        freq[c]--;
                        start = i+1;
                    }           
                }
            }
          if(count == t.length()-1 && minLen>end-start+1){
               minLen = end-start+1;
               startIdx = start;
               endIdx = end;
          }
        }
        System.out.println("Minimum length of substring containing all chars of t : "+minLen+" and substring : ");
        for(int i=startIdx;i<=endIdx;i++){
            System.out.print(s.charAt(i));
        }
    } 
}