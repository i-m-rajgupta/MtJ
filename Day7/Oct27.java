public class Oct27 {
    public static void main(String[] args) {
        // Split a sentence into words using split(" "). 
        String s = "I like to be consistent with my work";
        s = s.trim();
        String arr[] = s.split(" ");
        for(String word : arr){
            System.out.println(word);
        }
    //   Count the number of words in a sentence. 
       System.out.println("Total no. of words in sentence : "+arr.length);

    //    Reverse each word in a sentence. 
    String reverse[] = new String[arr.length];
    for(int i=0;i<arr.length;i++){
        String word = arr[i];
        reverse[i] = "";
        for(int j=word.length()-1;j>=0;j--){
             reverse[i] = reverse[i] + word.charAt(j);
        }
    }
    
    System.out.println("Reverse of each word in sentence : ");
    for(String word : reverse){
        System.out.println(word);
    }

    // Reverse the order of words in a sentence. 
    int start =0,end = arr.length-1;
    for(int i=0;i<arr.length/2;i++){
        String last = arr[end];
        arr[end--] = arr[start];
        arr[start++] = last;
    }

        for(String word : arr){
        System.out.println(word);
    }

    s = String.join(" ", arr);
    System.out.println(s);
    }
}
