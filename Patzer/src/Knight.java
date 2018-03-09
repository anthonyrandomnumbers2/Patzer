
import java.util.ArrayList;


public class Knight extends Piece{
    public Knight(int x, int y, String color){
        super(x,y,color);
    }
    
    @Override
    public ArrayList<int[]> getMoveList(){
        ArrayList<int[]> moveList = new ArrayList<>();
        return moveList;
    }
}
