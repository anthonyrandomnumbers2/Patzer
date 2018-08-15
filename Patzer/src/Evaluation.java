
import java.util.Arrays;



/**
 *
 * @author Anthony
 */
public class Evaluation {
    public static int evaluate(String[][] board){
        //ok we're gonna tally up a score for white and black, 
        //and return their sum
        int totalScore = 0;
        int whiteScore = 0;
        int blackScore = 0;
        
        //the first thing we can do is count up material
        int blackPawnCount, blackRookCount, blackBishopCount, blackKnightCount ,blackKingCount, blackQueenCount;
        blackPawnCount = blackRookCount = blackBishopCount = blackKnightCount = blackKingCount = blackQueenCount = 0;
        int whitePawnCount, whiteRookCount, whiteBishopCount, whiteKnightCount,whiteKingCount, whiteQueenCount;
        whitePawnCount = whiteRookCount = whiteBishopCount = whiteKnightCount = whiteKingCount = whiteQueenCount = 0;
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].equals("bP")){
                    blackScore += PieceTables.pawnTable[i%7][j];
                    blackPawnCount++;
                }
                if(board[i][j].equals("bR")){
                    blackScore += PieceTables.rookTable[i%7][j];
                    blackRookCount++;
                }
                if(board[i][j].equals("bN")){
                    blackScore += PieceTables.knightTable[i%7][j];
                    blackKnightCount++;
                }
                if(board[i][j].equals("bB")){
                    blackScore += PieceTables.bishopTable[i%7][j];
                    blackBishopCount++;
                }
                if(board[i][j].equals("bQ")){
                    blackScore += PieceTables.queenTable[i%7][j];
                    blackQueenCount++;
                }
                if(board[i][j].equals("bK")){
                    blackScore += PieceTables.kingTable[i%7][j];
                    blackKingCount++;
                }
                if(board[i][j].equals("wP")){
                    whiteScore += PieceTables.pawnTable[i][j];
                    whitePawnCount++;
                }
                if(board[i][j].equals("wR")){
                    whiteScore += PieceTables.rookTable[i][j];
                    whiteRookCount++;
                }
                if(board[i][j].equals("wN")){
                    whiteScore += PieceTables.knightTable[i][j];
                    whiteKnightCount++;
                }
                if(board[i][j].equals("wB")){
                    whiteScore += PieceTables.bishopTable[i][j];
                    whiteBishopCount++;
                }
                if(board[i][j].equals("wQ")){
                    whiteScore += PieceTables.queenTable[i][j];
                    whiteQueenCount++;
                }
                if(board[i][j].equals("wK")){
                    whiteScore += PieceTables.kingTable[i][j];
                    whiteKingCount++;
                }
            }   
        }
        //piece values will be in centipawns
        //1 centi pawn is worth 1/100 of the value of a pawn
        //the king should have a very large value?
        blackScore += (900 * blackQueenCount) + (500 * blackRookCount) + 
                (300 * blackKnightCount) + (300 * blackBishopCount) + 
                (100 * blackPawnCount) + (10000 * blackKingCount);
        
        whiteScore += (900 * whiteQueenCount) + (500 * whiteRookCount) + 
                (300 * whiteKnightCount) + (300 * whiteBishopCount) + 
                (100 * whitePawnCount) + (10000 * whiteKingCount);
        totalScore += whiteScore - blackScore;
        
        
        
        return totalScore;
    }
}
