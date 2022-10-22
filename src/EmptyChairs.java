import java.util.*;
/*
Empty chairs
Problem 469
In a room N chairs are placed around a round table.
Knights enter the room one by one and choose at random an available empty chair.
To have enough elbow room the knights always leave at least one empty chair between each other.
When there aren't any suitable chairs left, the fraction C of empty chairs is determined.
We also define E(N) as the expected value of C.
We can verify that E(4) = 1/2 and E(6) = 5/9.
 */
public class EmptyChairs {
    private List<Boolean> chairs;
    private boolean space;
    public EmptyChairs(int n){
        chairs= new ArrayList<Boolean>(Arrays.asList(new Boolean[n]));
        Collections.fill(chairs,Boolean.FALSE);
        space=true;
    }

    private void printChairs(){
        int i=0;
        for (boolean b: chairs) if(!b) i++;
        double r= (double)i/chairs.size();
        r= (double)Math.round(r*100000000000000d)/100000000000000d;
        System.out.println("The fraction of empty chairs: "+i+"/"+chairs.size()+"\nE: "+r);
    }
    public List fillChairs(){
        Random rn= new Random();
        List<Integer> empty=new ArrayList<Integer>();
        while(space){
            empty=getPossibleChairs();
            if(empty.size()!=0){
                int i= rn.nextInt(empty.size());
                chairs.set(empty.get(i),true);
            }



        }
        return empty;
    }
    private List<Integer> getPossibleChairs(){
        List<Integer> result= new ArrayList<Integer>();
        for(int i=0; i<chairs.size();i++){
            if (!chairs.get(i)){
                if(!checkNeighboursL(i) && !checkNeighboursR(i)){
                    result.add(i);
                }
            }
        }
        if (result.size() == 0) space=false;
        return result;
    }


    private boolean checkNeighboursL(int i){
        if(i==0) return chairs.get(chairs.size()-1);
        else return chairs.get(i-1);
    }
    private boolean checkNeighboursR(int i){
        if(i==chairs.size()-1) return chairs.get(0);
        else return chairs.get(i+1);
    }


    public static void main(String[] args) {
        EmptyChairs test= new EmptyChairs(5);
        test.fillChairs();
        test.printChairs();

    }

}
