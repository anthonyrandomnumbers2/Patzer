import javax.swing.*;
import java.util.*;
public class Patzer {
   
    public static void main(String[] args) {
        //our window
        JFrame frame = new JFrame("We got graphics!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        UI user_int = new UI();
        frame.add(user_int);
        initializeBoard();
        System.out.println(Board[6][4].getColor());
        generateMoves(Board[6][4]);
        
    }
    
    //we need to keep track of:
    //whose turn it is 
    static String turn_to_move = "W";
    //what pieces are left 
    static ArrayList<Piece> pieces_left = new ArrayList<>();
    //who can castle
    static Boolean black_castle = true;
    static Boolean white_castle = true;
    //status of the fifty move draw rule
    //that is, if each player moves 50 times: 100 moves all together
    //without a piece being captured
    //the game is drawn
    //here a turn is considered a move from one player
    //followed by a move from the other player
    static int turns_without_capture = 0;
    
    //a common and easy to understand way to represent the board is with
    //a string based array of arrays
    //we're gonna do it with piece objects
    /*
    [
    [a8 b8 c8 d8 e8 f8 g8 h8]
    [a7 b7 c7 d7 e7 f7 g7 h7]
    [a6 b6 c6 d6 e6 f6 g6 h6]
    [a5 b5 c5 d5 e5 f5 g5 h5]
    [a4 b4 c4 d4 e4 f4 g4 h4]
    [a3 b3 c3 d3 e3 f3 g3 h3]
    [a2 b2 c2 d2 e2 f2 g2 h2]
    [a1 b1 c1 d1 e1 f1 g1 h1]
    ]
    */
    static Piece[][] Board = new Piece[8][8];
    public static void initializeBoard(){
        for(int i = 0; i < 8; i++){
            //x = row, y = column
            Board[1][i] = new Pawn(1,i,"B");
            pieces_left.add(Board[1][i]);
        }
        Board[0][0] = new Rook(0,0,"B");
        Board[0][1] = new Knight(0,1,"B");
        Board[0][2] = new Bishop(0,2,"B");
        Board[0][3] = new Queen(0,3,"B");
        Board[0][4] = new King(0,4,"B");
        Board[0][5] = new Bishop(0,5,"B");
        Board[0][6] = new Knight(0,6,"B");
        Board[0][7] = new Rook(0,7,"B");
        for(int i = 0; i < 8; i++){
            pieces_left.add(Board[0][i]);
        }
        for(int i = 0; i < 8; i ++){
            Board[6][i] = new Pawn(6,i,"W");
            pieces_left.add(Board[6][i]);
        }
        Board[7][0] = new Rook(7,0,"W");
        Board[7][1] = new Knight(7,1,"W");
        Board[7][2] = new Bishop(7,2,"W");
        Board[7][3] = new Queen(7,3,"W");
        Board[7][4] = new King(7,4,"W");
        Board[7][5] = new Bishop(7,5,"W");
        Board[7][6] = new Knight(7,6,"W");
        Board[7][7] = new Rook(7,7,"W");
        for(int i = 0; i < 8; i++){
            pieces_left.add(Board[7][i]);
        }
    }
    
    //we need a way to generate legal moves for a given piece
    public static String generateMoves(Piece p){
        String moveList = "";
        //lets find out where we are on the board
        int x_pos = p.getX();
        int y_pos = p.getY();
        //lets get a list of all the squares we can move to
        //with this piece
        ArrayList<int[]> squares_we_can_get_to = new ArrayList<>();
        squares_we_can_get_to = p.getMoveList();
        
        return moveList;
    }
    
    public boolean isEmpty(int x, int y){
        if(Board[x][y] == null){
            return true;
        //if the square is occupied by an enemy piece
        //you can move there
        }else if(!Board[x][y].getColor().equals(turn_to_move)){
            return true;
        }
        return false;
    }
}
