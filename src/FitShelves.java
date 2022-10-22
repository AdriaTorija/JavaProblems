import java.util.ArrayList;
import java.util.List;
/* Problem:It is given that the length of the wall is 'w' and the lengths of the two shelves is 'm' and 'n', respectively.
It is required to find the number of each type of shelves that must be used to cover the wall with minimum empty space left.
The larger of the two shelves is cheaper in price and is hence preferrable over the other.
However, the priority is to minimize the empty space.
 */

/**
 * Class to fit Shelves
 */
class FittingShelves{
    float x, y, result;
    List<Integer> end;

    /**
     * Constructor
     * @param x size of shelve
     * @param y size of shelve2
     * @param result total dimension
     */
    public FittingShelves(float x, float y, float result){
        this.x=x;
        this.y=y;
        this.result=result;

    }

    /**
     * Checks the calculated dimension with tables with the real dimension
     * @param space
     * @return boolean if it fits
     */
    public boolean check(float space){
        return space < result;
    }

    /**
     * Gets the optimal number of shelves for Its dimension
     * @return List: At index 0 the biggest shelves, index 1 smallest
     */
    public List fit() {
        List<Integer> end = new ArrayList<>();
        float space;
        float l,s;
        if (x<y) {
            s=x;
            l=y;
        }
        else{
            s = y;
            l = x;
        }
        space= result%l;
        for(int i=0; i<=(int)result/l;i++){
            float space2=0;
            int j=0;
            space2= l*i + s*j;
            while(check(space2)){
                if (space2>=space){
                    space=space2;
                    end.clear();
                    end.add(i);
                    end.add(j);
                }
                j++;
                space2= l*i + s*j;
            }
        }
        this.end=end;
        return end;
    }

    /**
     * Prints the result obtained
     */
        public void print(){
        float s,l;
            if (x<y) {
                s=x;
                l=y;
            }
            else{
                s = y;
                l = x;
            }
            System.out.println(end.get(0).getClass());
            float left= result - (l * (float)end.get(0) + s * (float)end.get(1));
            System.out.println("Dimensions: "+result+"cm\nLeft: "+left+"\n"+end.get(0)+ " Tables of: "+l+"cm\n"+end.get(1)+" Tables of: "+s);
        }
}




public class FitShelves {
    public static void main(String[] args) {
        FittingShelves x= new FittingShelves(2,3,40);
        x.fit();
        x.print();

    }
}

