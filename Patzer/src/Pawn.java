
import java.util.ArrayList;
import java.util.Arrays;


public class Pawn extends Piece{
    public Pawn(int x, int y, String color){
        super(x,y, color);
    }
    
    @Override
    public ArrayList<int[]> getMoveList(){
        ArrayList<int[]> moveList = new ArrayList<>();
        int pos_x = getX();
        int pos_y = getY();
        String col = getColor();
        //x is row
        //y is column
        //When can a pawn move forward?
        int[] temp_move = new int[2];
        if(col.equals("W") && pos_x > 0){
            if(pos_x == 6){
                //one space forward
                temp_move[0] = pos_x - 1;
                temp_move[1] = pos_y;
                moveList.add(temp_move.clone());
                //two spaces forward at the start
                temp_move[0] = pos_x - 2;
                moveList.add(temp_move.clone());
                //System.out.println(Arrays.toString(temp_move));
            }
            if(pos_x < 6){
                temp_move[0] = pos_x - 1; 
                moveList.add(temp_move.clone());
            }
            //When can a pawn move diagonally?
            if(pos_y != 0 && pos_y != 7){
                temp_move[0] = pos_x - 1;
                temp_move[1] = pos_y - 1;
                moveList.add(temp_move.clone());               
                temp_move[1] = pos_y + 1;
                moveList.add(temp_move.clone());
            }
            if(pos_y == 0){
                temp_move[1] = pos_y + 1;
                moveList.add(temp_move.clone());
            }
            if(pos_y == 7){
                temp_move[1] = pos_y - 1;
                moveList.add(temp_move.clone());
            }
        }
        for(int i = 0; i < moveList.size(); i++){
            System.out.println(Arrays.toString(moveList.get(i)));
        }
        if(col.equals("B") && pos_x < 7){
            if(pos_x == 1){
                //one space forward
                temp_move[0] = pos_x + 1;
                temp_move[1] = pos_y;
                moveList.add(temp_move.clone());
                //two spaces forward at the start
                temp_move[0] = pos_x + 2;
                moveList.add(temp_move.clone());
            }
            if(pos_x > 1){
                temp_move[0] = pos_x + 1; 
                moveList.add(temp_move.clone());
            }
            //When can a pawn move diagonally?
            if(pos_y != 0 && pos_y != 7){
                temp_move[0] = pos_x + 1;
                temp_move[1] = pos_y - 1;
                moveList.add(temp_move.clone());
                temp_move[1] = pos_y + 1;
                moveList.add(temp_move.clone());
            }
            if(pos_y == 0){
                temp_move[1] = pos_y + 1;
                moveList.add(temp_move.clone());
            }
            if(pos_y == 7){
                temp_move[1] = pos_y - 1;
                moveList.add(temp_move.clone());
            }
        }
        //gotta deal with en passant at some point..
        return moveList;
    }
}
