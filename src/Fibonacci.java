public class Fibonacci {
    /**
     * Program that calculates Sum of Even Fibonacci.
     * @param maxN
     * @return
     */
    public long EvenFibonacci(int maxN){
        return calculateFi(maxN,1,2,1);
    }
    public long calculateFi(int max, long x, long y,long result){
        if(max>0){
            if (y%2==0) result+=y;
            return calculateFi(max-1,y,x+y,result);
        }
        return result-1;
    }

    public static void main(String[] args) {;
        Fibonacci x= new Fibonacci();
        System.out.println((x.EvenFibonacci(5)));
    }
}
