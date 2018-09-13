
import java.util.Arrays;



/**
 *
 * @author Anthony
 */


public class AlphaBeta {
    
    static String bestMoveP1 = "";
    static String bestMoveP2 = "";
    public static String findDecentMove(String[][] currentBoard,int player){
       updateTempBoard(currentBoard);
       alphaBeta(Patzer.tempBoard, -100000, 100000, 5, player);
       if(player == 1)
           return bestMoveP1;
       else 
           return bestMoveP2;   
    }
    
    public static int alphaBeta(String[][] currentBoard, int alpha, int beta, int ply, int player){
        //base case
        if(ply == 0){
            int b  = Evaluation.evaluate(currentBoard);
            return b;    
        }
        
        String color = "w";
        if(player == -1){
            color = "b";
        }
        
        String movesForCurrentBoard = Patzer.generateMoves(color, Patzer.tempBoard);
        String[] splitMoves = movesForCurrentBoard.split("\\|");
        String bestMove = "";
        String move = "";
        
        //maximizing player
        if(player == 1){
            int minScore = -10000000;
            for(int i = 0; i < splitMoves.length; i++){
                if(splitMoves.length > 0){
                    move = splitMoves[i];
                    Patzer.tempMakeMove(move);
                    int tempScore = minScore;
                    minScore = Math.max(minScore,alphaBeta(currentBoard, alpha, beta, ply - 1, -player));
                    alpha = Math.max(alpha,minScore);
                    if(minScore > tempScore){
                        bestMove = move;
                    }
                    Patzer.tempUnmakeMove(move);
                    if(alpha >= beta){
                        return minScore;
                    }
                }
            } 
            bestMoveP1 = bestMove;
            if(bestMoveP1.equals("")){
                bestMoveP1 = move;
            }
            return minScore;
        }
        //minimizing player
        else{
            int maxScore = 10000000;
            for(int i = 0; i < splitMoves.length; i++){
                if(splitMoves.length > 0){
                    move = splitMoves[i];
                    Patzer.tempMakeMove(move);
                    int tempScore = maxScore;
                    maxScore = Math.min(maxScore,alphaBeta(currentBoard, alpha, beta, ply - 1, -player));
                    beta = Math.min(beta, maxScore);
                    if(maxScore < tempScore){    
                        bestMove = move;
                    }
                    Patzer.tempUnmakeMove(move);
                    if(alpha >= beta){
                        return maxScore;
                    }
                }
            }
            bestMoveP2 = bestMove;
            if(bestMoveP2.equals("")){
                bestMoveP2 = move;
            }
            return maxScore;
        }
       
    }
    
    public static void updateTempBoard(String[][] currentBoard){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                Patzer.tempBoard[i][j] = currentBoard[i][j];
            }
        }
    }
}
