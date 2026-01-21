import java.util.ArrayDeque;
import java.util.Scanner;

class Browser{
    private ArrayDeque<String> history ;
    private String currentPage;
    Browser(String page){
        this.history = new ArrayDeque<>();
        this.currentPage = page;
        System.out.println("Starting at "+this.currentPage);
    }

    public boolean isEmpty(){
        return history.isEmpty();
    }

    public void visit(String page){
        history.push(currentPage);
        currentPage = page;
        System.out.println("Visited to : "+ currentPage);
    }

    public void goBack(){
        if(isEmpty()){
            System.out.println("No previous page existed ");
            return;
        }
        currentPage = history.pop();
        System.out.println("Back to : "+currentPage);
    }

    public String getCurrentPage(){
        return currentPage;
    }
}

class MusicPlayer{
    private String currentSong;
    private ArrayDeque<String> history ;
    MusicPlayer(String song){
        history = new ArrayDeque<>();
        currentSong = song;
        System.out.println("Start playing : "+currentSong);
    }

    public void nextSong(String song){
        history.push(currentSong);
        currentSong =song;
        System.out.println("Now playing : "+currentSong);
    }

    public void previousSong(){
        if(history.isEmpty()){
            System.out.println("No previous song Existed ");
            return;
        }
        currentSong = history.pop();
        System.out.println("Now playing : "+currentSong);
        }
}
public class Dec14 {
    public static boolean isPalindrome(String str){
        if(str == null || str.length() == 1){
            return true;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int n = str.length();
        for(int i = 0 ;i< n/2;i++){
            stack.push(str.charAt(i));
        }

        int start = (n%2 == 0)? n/2:n/2+1;

        for(int i =start;i<n;i++){
            if(stack.pop() != str.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static int count(ArrayDeque<Integer> stack){
        int count = 0;
            while (!stack.isEmpty()) {
                stack.pop();
                count++;
            }

        return count;
    }

    public static void printEvenInLIFO(int num){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int digit ;
        while (num != 0) {
            digit = num%10 ;
            if(digit%2 == 0){
                stack.push(digit);
            }
            num = num/10;
        }

        if(!stack.isEmpty()){
         System.out.println("Even number in LIFO order ");
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }
    public static void main(String[] args) {
        // Design a stack to check if a string is a palindrome.
        System.out.println(isPalindrome("aba"));

        // Implement a browser’s BACK operation using a stack.
        Browser browser = new Browser("Google.com");
        browser.visit("Instagram.com");
        browser.visit("Twitter.com");
        System.out.println(browser.getCurrentPage());
        browser.goBack();
        browser.goBack();
        browser.goBack();

        // Count the number of elements in a stack without using size() directly.
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(4);
        stack.push(8);
        stack.push(12);
        System.out.println(count(stack));

        // Push all even numbers from input into a stack and then pop them in LIFO order.
        System.out.println("Enter numbers ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        printEvenInLIFO(num);

        // Implement a stack that stores the history of songs played in a music player.
        MusicPlayer music = new MusicPlayer("Ram stuti");
        music.nextSong("Bhajman radhe ");
        music.nextSong("Shri ram chandra kripalu bhajman ");
        music.previousSong();
        music.previousSong();
        music.previousSong();

        sc.close();
    }
}
