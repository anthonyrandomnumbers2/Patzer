
import java.util.ArrayList;


public class Piece{
    private int x;
    private int y;
    private String color;
    
    
    public Piece(int x, int y, String color){
        super();
        this.x = x;
        this.y = y;
        this.color = color;
    } 
    @Override
    public String toString(){
        return this.color;
    }
    
    public ArrayList<int[]> getMoveList(){
        //[x,y]
        ArrayList<int[]> moveList = new ArrayList<>();
        return moveList;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public String getColor(){
        return color;
    }
}


