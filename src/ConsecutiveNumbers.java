import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*
Create a method in a Java class that accepts an array of numbers as a parameter.
If the array of numbers can be rearranged so that they’re consecutive numbers where no number appears twice, return true.
If this isn’t possible, return false.
 */

public class ConsecutiveNumbers {
    public boolean consecutives(List<Integer> arr){
        arr.sort(Comparator.naturalOrder());
        for(int i=0;i< arr.size()-1;i++){
            if (arr.get(i).equals(arr.get(i+1))) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ConsecutiveNumbers x= new ConsecutiveNumbers();
        List<Integer> t1= new ArrayList<Integer>(Arrays.asList(1,3,4,5,6,7,8,9,1));
        List<Integer> t2= new ArrayList<Integer>(Arrays.asList(1,3,4,5,6,7,8,9));
        System.out.println(x.consecutives(t1));
        System.out.println(x.consecutives(t2));
    }
}
