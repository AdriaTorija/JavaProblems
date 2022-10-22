/*
Write a method in Java that accepts a string as a parameter.
This method should return a string that reverses the letters in the string sent as a parameter
but keep all the numbers in order.
 */
public class ReverseLetters {
    public String reverseLetters(String x){
        String aux="";
        String result="";
        for(int i=0;i<x.length();i++) {
            char l = x.charAt(i);
            if ((l >= 'a' && l <= 'z') || (l <= 'Z' && l >= 'A')) {
                aux = l + aux;
            }
        }
        int n=0;
        for(int i=0;i<x.length();i++){
            char l=x.charAt(i);
            if (((l>='a' && l<='z') || (l<='Z' && l>='A'))&& n<aux.length()){
                result += aux.charAt(n);
                n++;
            }
            else result += l;

        }
        return result;
    }

    public static void main(String[] args) {
        ReverseLetters t= new ReverseLetters();
        System.out.println(t.reverseLetters("Geeks332sds"));
    }
}
