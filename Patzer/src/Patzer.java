import javax.swing.*;
import java.util.*;

public class Patzer{
    
    
   static String board[][] = {
            {"bR", "bN", "bB", "bQ", "bK", "bB", "bN", "bR"},
            {"bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP"}, 
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {"wP", "wP", "wP", "wP", "wP", "wP", "wP", "wP"},
            {"wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR"}
    };
   
    static String tempBoard[][] = {
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "}, 
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
    };
    
    public static void main(String[] args) {
        //our window
        JFrame frame = new JFrame("We got graphics!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,640);
        frame.setVisible(true);
        UI user_int = new UI();
        frame.add(user_int);
        
        for(int i = 0; i < board.length; i++){
            System.out.println(Arrays.toString(board[i]));
            //good stuff we now have a representation for the board
            //an array of String arrays
        }
        System.out.println("--------------------------------------------------------------------------");
        
        while(true){
            String move = "";
            move = AlphaBeta.findDecentMove(board,1);
            makeMove(move);
            frame.repaint();
            
            System.out.println("Move: " + move );
            for(int i = 0; i < board.length; i++){
                System.out.println(Arrays.toString(board[i]));
            }
            System.out.println("--------------------------------------------------------------------------");
            move = (AlphaBeta.findDecentMove(board,-1));
            makeMove(move);
            frame.repaint();
            
            System.out.println("Move: " + move);
            for(int i = 0; i < board.length; i++){
                System.out.println(Arrays.toString(board[i]));
            }   
            System.out.println("--------------------------------------------------------------------------");
        }
    }
    
    //returns a string of all the moves one color could make
    //"currentPiece[position] -> currentPiece[newPosition], ..."
    //"wP[6,1] -> wP[7,1], ..."
    public static String generateMoves(String color,String[][] currentBoard){
        String moveList = "";
        ArrayList<String> ourPieces = new ArrayList<>();
        //The plan is to first loop through the whole board and find all of our pieces
        for(int i = 0; i < currentBoard.length; i++){
            for(int j = 0; j < 8; j++){
                if(currentBoard[i][j].startsWith(color)){
                    ourPieces.add(currentBoard[i][j] + "[" + i + "]" + "[" + j + "]");
                }
            }
        }
        
        //great we now have an arraylist of all the pieces we have on the board 
        //we need to take each piece and generate all possible psuedo legal moves they can make
        for(int i = 0; i < ourPieces.size(); i++){
            moveList += getMoves(ourPieces.get(i),currentBoard);
        }
        return moveList;
    }
    
    //get moves takes a piece(a string) and calls methods from MoveGeneration
    //These methods return a String list of all moves that piece can make.
    //see move generation class for format
    public static String getMoves(String currentPiece, String[][] currentBoard){
        if(currentPiece.substring(1,2).equals("K")){
            return MoveGeneration.kingMoves(currentPiece, currentBoard);
        }
        if(currentPiece.substring(1,2).equals("N")){
            return MoveGeneration.knightMoves(currentPiece, currentBoard);
        }
        if(currentPiece.substring(1,2).equals("P")){
            return MoveGeneration.pawnMoves(currentPiece, currentBoard);
        }
        if(currentPiece.substring(1,2).equals("R")){
            return MoveGeneration.rookMoves(currentPiece, currentBoard);
        }
        if(currentPiece.substring(1,2).equals("B")){
            return MoveGeneration.bishopMoves(currentPiece, currentBoard);
        }
        if(currentPiece.substring(1,2).equals("Q")){
            return MoveGeneration.queenMoves(currentPiece, currentBoard);
        }
        return "";
    }
    
    //given a string encoded move
    //update the board with that move
    public static void makeMove(String move){
        if(!move.equals("")){
            int oldRank = Integer.parseInt(move.substring(0,1));
            int oldFile = Integer.parseInt(move.substring(1,2));
            int newRank = Integer.parseInt(move.substring(2,3));
            int newFile = Integer.parseInt(move.substring(3,4));
            board[newRank][newFile] = board[oldRank][oldFile];
            board[oldRank][oldFile] = " ";    
           
        }
    }
    
    //given the PREVIOUS string encoded move
    //return the board to before the move happened
    public static void unmakeMove(String move){
        if(!move.equals("")){
            int oldRank = Integer.parseInt(move.substring(0,1));
            int oldFile = Integer.parseInt(move.substring(1,2));
            int newRank = Integer.parseInt(move.substring(2,3));
            int newFile = Integer.parseInt(move.substring(3,4));
            //space indicates no capture
            String capturedPiece = " ";
            //strings longer than 5 end with the captured piece
            if(move.length() == 6){
                capturedPiece = move.substring(4);
            }    
            board[oldRank][oldFile] = board[newRank][newFile];
            board[newRank][newFile] = capturedPiece;
        }
    }    
        public static void tempMakeMove(String move){
        if(!move.equals("")){
            int oldRank = Integer.parseInt(move.substring(0,1));
            int oldFile = Integer.parseInt(move.substring(1,2));
            int newRank = Integer.parseInt(move.substring(2,3));
            int newFile = Integer.parseInt(move.substring(3,4));
            tempBoard[newRank][newFile] = tempBoard[oldRank][oldFile];
            tempBoard[oldRank][oldFile] = " ";     
        }
    }
    
    //given the PREVIOUS string encoded move
    //revert the board to before the move happened
    public static void tempUnmakeMove(String move){
        if(!move.equals("")){
            int oldRank = Integer.parseInt(move.substring(0,1));
            int oldFile = Integer.parseInt(move.substring(1,2));
            int newRank = Integer.parseInt(move.substring(2,3));
            int newFile = Integer.parseInt(move.substring(3,4));
            //space indicates no capture
            String capturedPiece = " ";
        
            //strings longer than 5 end with the captured piece
            if(move.length() == 6){
                capturedPiece = move.substring(4);
            }    
            tempBoard[oldRank][oldFile] = tempBoard[newRank][newFile];
            tempBoard[newRank][newFile] = capturedPiece;
        }    
    }
}
