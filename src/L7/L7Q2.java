package L7;

public class L7Q2 {
    public static void main(String[] args) {
        String[] text={"abccba", "aabbcc", "hehehe", "heheheh"};
        for (String text_check:text){
            System.out.println(text_check + "is palindrome? :"+ (checkPalindrome(text_check)?" Yes":" No"));
        }
    }

    public static boolean checkPalindrome(String text){
        MyQueue<Character> stringToChar=new MyQueue<>();
        char [] text_char=text.toCharArray();
        for (char e:text_char){
            stringToChar.enqueue(e);
        }

        for (int i=text.length()-1;i>0;i--){
            if(text.charAt(i)!=stringToChar.dequeue()){
                return false;
            }
        }
        return true;
    }
}