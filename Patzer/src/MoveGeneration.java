/*
All <piece>moves methods in this class return a string of the format:
<oldRank><oldFile><newRank><newFile><captured piece>...
this string represents all psuedo legal moves a piece can make
example: king from e1(rank 7, file 4) to e2(rank 6, file 4) 
when e2 is an empty square represented by a space:
"7464 "
king from rank 7 file 4 to rank 6 file 4 capturing nothing,
so the string ends in a space.
*/

public class MoveGeneration {
    static int newRank,newFile;
    static int currentPieceRank,currentPieceFile;
    
    public static String kingMoves(String currentPiece,String[][] board){
        currentPieceRank = Integer.parseInt(currentPiece.substring(3,4));
        currentPieceFile = Integer.parseInt(currentPiece.substring(6,7));
        String color = currentPiece.substring(0,1);
        String moves = "";

        int[] kingOffsets = {0,1,0,-1,1,1,1,-1,1,0,-1,0,-1,1,-1,-1};
        for(int i = 0; i < 16; i+=2){
            newRank = currentPieceRank + kingOffsets[i];
            newFile = currentPieceFile + kingOffsets[i+1];
            if(isInBoard(newRank,newFile)){
                if(!board[newRank][newFile].startsWith(color)){
                    moves += "|" + currentPieceRank + currentPieceFile + newRank + newFile + board[newRank][newFile];
                }
            }
        }
        //toDO: castling, checking
        return moves;
    }
    
    public static String knightMoves(String currentPiece,String[][] board){
        currentPieceRank = Integer.parseInt(currentPiece.substring(3,4));
        currentPieceFile = Integer.parseInt(currentPiece.substring(6,7));
        String color = currentPiece.substring(0,1);
        String moves = "";
        
        int[] knightOffsets = {2,1,2,-1,-2,1,-2,-1,1,2,1,-2,-1,2,-1,-2};
        for(int i = 0; i < 16; i+=2){
            newRank = currentPieceRank + knightOffsets[i];
            newFile = currentPieceFile + knightOffsets[i+1];
            if(isInBoard(newRank,newFile)){
                if(board[newRank][newFile].equals(" ") || !board[newRank][newFile].startsWith(color)){
                    moves += "|" + currentPieceRank + currentPieceFile + newRank + newFile + board[newRank][newFile];
                }  
            }
        }
        return moves;
    }
    
    public static String bishopMoves(String currentPiece,String[][] board){
        currentPieceRank = Integer.parseInt(currentPiece.substring(3,4));
        currentPieceFile = Integer.parseInt(currentPiece.substring(6,7));
        String color = currentPiece.substring(0,1);
        String moves = "";
        
        //It's ugly but it works!
        int[] bishopVectors = {1,-1,1,1,-1,-1,-1,1};
        for(int i = 0; i < 8; i+=2){
            for(int j = 1; j < 9; j++){
                newRank = currentPieceRank+ j * bishopVectors[i];
                newFile = currentPieceFile + j*bishopVectors[i+1];
                if(isInBoard(newRank,newFile)){
                    //are we moving to an empty square?
                    if(board[newRank][newFile].equals(" ")){
                       moves += "|" + currentPieceRank + currentPieceFile + newRank + newFile + board[newRank][newFile];
                    }else{
                        //are we moving to a square with one of our pieces?
                        //stop checking in that direction
                        if(board[newRank][newFile].startsWith(color)){
                            break;
                        }else{
                            //are we taking an enemy piece?
                            //add the move to the list and stop checking in that direction
                            if(!board[newRank][newFile].startsWith(color) &&!board[newRank][newFile].equals(" ")){
                                moves += "|" + currentPieceRank + currentPieceFile + newRank + newFile + board[newRank][newFile];
                                break;
                            }
                        }
                    }
                }else
                    break;
            }
        }
        return moves;
    }
    
    public static String rookMoves(String currentPiece,String[][] board){
        currentPieceRank = Integer.parseInt(currentPiece.substring(3,4));
        currentPieceFile = Integer.parseInt(currentPiece.substring(6,7));
        String color = currentPiece.substring(0,1);
        String moves = "";
        //Rook movement
        //alright let's try to make this one cleaner than the bishop
        int[] rookVectors = {0,1,0,-1,1,0,-1,0};
        //find our vectors
        for(int i = 0; i < 8; i+=2){
            //how far are we moving?
            for(int j = 1; j < 9; j++){
                newRank = currentPieceRank + j * rookVectors[i];
                newFile = currentPieceFile + j * rookVectors[i+1];
                if(isInBoard(newRank,newFile)){
                    //are we moving to a square that contains one of our pieces?
                    if(board[newRank][newFile].startsWith(color)){
                        break;
                    //empty square?
                    }else if(board[newRank][newFile].equals(" ")){
                        moves += "|" + currentPieceRank + currentPieceFile + newRank + newFile + board[newRank][newFile];
                        //enemy piece?
                    }else if(!board[newRank][newFile].startsWith(color)){
                        moves += "|" + currentPieceRank + currentPieceFile + newRank + newFile + board[newRank][newFile];
                        break;
                    }
                }else
                    //we are trying to move off the board
                    //go to the outer for loop and find a new vector
                    break;       
            }
        }
        return moves;
    }
    
    public static String queenMoves(String currentPiece,String[][] board){
        //a queen is essentially a rook and bishop combined
        return bishopMoves(currentPiece,board) + rookMoves(currentPiece,board);
    }
    
    public static String pawnMoves(String currentPiece,String[][] board){
        currentPieceRank = Integer.parseInt(currentPiece.substring(3,4));
        currentPieceFile = Integer.parseInt(currentPiece.substring(6,7));
        String color = currentPiece.substring(0,1);
        String moves = "";
        
        //black pawns move down the board
        int[] pawnOffsets = {1,0,1,1,1,-1};
        if(color.equals("w")){
            //white pawns move up the board
            pawnOffsets[0] = -1;
            pawnOffsets[2] = -1;
            pawnOffsets[4] = -1;
        }
        for(int i = 0; i < 6; i+=2){
            //moving forward
            if(pawnOffsets[i+1] == 0){
                newRank = currentPieceRank + pawnOffsets[i];
                newFile = currentPieceFile;
                if(isInBoard(newRank,newFile) && board[newRank][newFile].equals(" ")){
                    moves += "|" + currentPieceRank + currentPieceFile + newRank + newFile + board[newRank][newFile];
                }
                //special cases for pawns that have not moved yet
                //they can move 2 spaces to start
                if(color.equals("b") && currentPieceRank == 1){
                    if(board[2][currentPieceFile].equals(" ") && board[3][currentPieceFile].equals(" ")){
                        moves += "|" + currentPieceRank + currentPieceFile + 3 + currentPieceFile + board[3][currentPieceFile];
                    }
                }
                if(color.equals("w") && currentPieceRank == 6){
                    if(board[5][currentPieceFile].equals(" ") && board[4][currentPieceFile].equals(" ")){
                        moves += "|" + currentPieceRank + currentPieceFile + 4 + currentPieceFile + board[5][currentPieceFile];
                    }
                }
            }else{
                //capturing enemy pieces
                newRank = currentPieceRank + pawnOffsets[i];
                newFile = currentPieceFile + pawnOffsets[i+1];
                if(isInBoard(newRank,newFile)){
                    if(!board[newRank][newFile].startsWith(color) && !board[newRank][newFile].equals(" ")){
                        moves += "|" + currentPieceRank + currentPieceFile + newRank + newFile + board[newRank][newFile];
                    }
                }
            }
        }
        //toDO: promotion, enpassant?
        return moves;
    }
    
    public static boolean isKingSafe(String psuedoLegalMoves,String[][] board,int x, int y){
        //stub
        //what if we give the king an enourmous value..
        //alpha beta shouldn't pick a node that allows the king to be captured anyway...
        return true;
    }
    
    public static boolean isInBoard(int x, int y){
        if(x < 0 || x > 7){
            return false;
        }
        if(y < 0 || y > 7){
            return false;
        }
        return true;
    }
}
