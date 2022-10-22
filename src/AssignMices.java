import java.util.*;

//Assign Mice to Holes
/*
    Problem:
    There are x mice and x holes placed in a straight line.
    Each hole can accommodate only 1 mouse.
    The position of the mouse is such that it can stay at his position or move towards right one step from x to x + 1, or move towards left one step from x to x - 1.
    It takes only 1 minute to follow any of these moves.
    Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.
 */
class AssignMice {
    List<Integer> holes = new ArrayList<>();
    List<Integer> mices = new ArrayList<>();

    private boolean checkM(int n) {
        for (int i : mices) {
            if (i == n) return true;
        }
        return false;
    }

    private boolean checkH(int n) {
        for (int i : holes) {
            if (i == n) return true;
        }
        return false;
    }

    public AssignMice(int n, int maxpositions) {
        for (int i = 0; i < n; i++) {
            Random rand;
            int m = new Random().nextInt(5 + 5) - 5;
            int h = new Random().nextInt(5 + 5) - 5;
            while (checkH(h)) {
                h = new Random().nextInt(5 + 5) - 5;
            }
            holes.add(h);
            while (checkM(m)) {
                m = new Random().nextInt(5 + 5) - 5;
            }
            mices.add(m);
        }
    }

    public int mouseTime() {
        int result = 0;
        Collections.sort(holes);
        Collections.sort(mices);
        for (int i = 0; i < mices.size(); i++) {
            if (result < Math.abs(mices.get(i) - holes.get(i))) {
                result = Math.abs(mices.get(i) - holes.get(i));
            }
        }
        printR(result);
        return result;
    }
    private void printR(int result){
        System.out.println("Max time: "+result+"\nMices: "+mices+"\nHoles: "+holes);
    }
}
public class AssignMices {
    public static void main(String[] args) {
        AssignMice x= new AssignMice(2,5);
        x.mouseTime();
    }
}
