

/**
 *
 * @author Anthony
 */
public class Evaluation {
    public static int evaluate(String[][] board){
        //ok we're gonna tally up a score for white and black, 
        //and return their sum
        int whiteScore = 0;
        int blackScore = 0;
        
        //the first thing we can do is count up material
        int blackPawnCount, blackRookCount, blackBishopCount, blackKnightCount ,blackKingCount, blackQueenCount;
        blackPawnCount = blackRookCount = blackBishopCount = blackKnightCount = blackKingCount = blackQueenCount = 0;
        int whitePawnCount, whiteRookCount, whiteBishopCount, whiteKnightCount,whiteKingCount, whiteQueenCount;
        whitePawnCount = whiteRookCount = whiteBishopCount = whiteKnightCount = whiteKingCount = whiteQueenCount = 0;
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].equals("bP"))
                    blackPawnCount++;
                if(board[i][j].equals("bR"))
                    blackRookCount++;
                if(board[i][j].equals("bN"))
                    blackKnightCount++;
                if(board[i][j].equals("bB"))
                    blackBishopCount++;
                if(board[i][j].equals("bQ"))
                    blackQueenCount++;
                if(board[i][j].equals("bK"))
                    blackKingCount++;
                if(board[i][j].equals("wP"))
                    whitePawnCount++;
                if(board[i][j].equals("wR"))
                    whiteRookCount++;
                if(board[i][j].equals("wN"))
                    whiteKnightCount++;
                if(board[i][j].equals("wB"))
                    whiteBishopCount++;
                if(board[i][j].equals("wQ"))
                    whiteQueenCount++;
                if(board[i][j].equals("wK"))
                    whiteKingCount++;
            }   
        }
        //piece values will be in centipawns
        //1 centi pawn is worth 1/100 of the value of a pawn
        //the king should have a very large value?
        blackScore += (900 * blackQueenCount) + (500 * blackRookCount) + 
                (300 * blackKnightCount) + (300 * blackBishopCount) + 
                (100 * blackPawnCount) + (1000000 * blackKingCount);
        whiteScore += (900 * whiteQueenCount) + (500 * whiteRookCount) + 
                (300 * whiteKnightCount) + (300 * whiteBishopCount) + 
                (100 * whitePawnCount) + (1000000 * whiteKingCount);
        
         
        return whiteScore - blackScore;
    }
}
