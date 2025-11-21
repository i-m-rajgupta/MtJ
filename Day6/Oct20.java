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
        //  Find the smallest substring of s that contains all characters of t.
        // System.out.println("Enter the string to be found : ");
        // String t = sc.next();
        int length =Integer.MAX_VALUE;
        String s1 ="";
        // for(int i =0;i<s.length();i++){
        //     for(int j=i+1;j<=s.length();j++){
        //     String str = s.substring(i, j);
        //     char arr[] = t.toCharArray();
        //     for(int k=0;k<str.length();k++){
        //        char ch = str.charAt(k);
        //        for(int l=0;l<arr.length;l++){
        //              if(ch == arr[l]){
        //                 arr[l] = '=';
        //             }
        //        }
                
        //     }
        //     String res = new String(arr);
        //     String check = "";
        //     for(int p=0;p<t.length();p++){
        //         check += "=";
        //     }
        //      if(res.equals(check) && length>str.length()){
        //         length = str.length();
        //         s1 = str;
        //      }
        //     }
        // }

        // System.out.println("Smallest substring of s that contains all characters of t : "+s1);

        //  Count of substrings with exactly k unique characaters 
        // System.out.println("Enter the value of k : ");
        // int k = sc.nextInt();
        // int substring = 0,count=0;
        // for(int i =0;i<s.length();i++){
        //     for(int j=i+1;j<=s.length();j++){
        //      String str = s.substring(i, j);
        //      count =0;
        //      int map[] = new int[256];
        //      for(int l=0;l<str.length();l++){
        //         char ch = str.charAt(l);
        //       if(map[ch] == 0){
        //         map[ch]++;
        //         count++;
        //       }
        //      }
        //        if(count == k){
        //         substring++;
        //       }
        //     }
        // }
        // System.out.println("Count of substrings with exactly k unique characaters "+substring);

        // Longest substring with vowels only
        // length =0;
        //   for(int i =0;i<s.length();i++){
        //     for(int j=i+1;j<=s.length();j++){
        //      String str = s.substring(i, j);
        //     str =  str.toLowerCase();
        //     String res = "";
        //     for(int p=0;p<str.length();p++){
        //       char ch = str.charAt(p);
        //       if(ch == 'a'|| ch == 'e'||ch=='i'||ch == 'o'||ch=='u'){
        //         res += ch;
        //       }else{
        //         break;
        //       }
        //     }
        //     if(res.length()>length){
        //         length = res.length();
        //         s1 = res;
        //     }
        //     }
        // }
        // System.out.println("Longest substring with vowels only : "+s1);

        // Longest substring with Distinct characters in lexicographical order 
        length = 0;
        s1 ="";
        for(int i =0;i<s.length();i++){
         for(int j=i+1;j<=s.length();j++){
          String str = s.substring(i,j);
          String res = "";
           for(int p=0;p<str.length();p++){
            char ch = str.charAt(p);
            if(p == str.length()-1){
                res += ch; 
                break;
            }
            if(ch < str.charAt(p+1)){
               res += ch;    
            }else{
              break;
            }
           }
           if(length<res.length()){
            length = res.length();
            s1 = str;
           }
         }
        }
        System.out.println("Longest substring with Distinct characters in lexicographical order : "+s1);
    } 
}