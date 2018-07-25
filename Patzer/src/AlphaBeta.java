

/**
 *
 * @author Anthony
 */
//here we go.
//things to think about:
//what are our paramaters?
// (node, depth, alpha, beta, sentinal boolean)
//what are we returning?
//why does alphabeta work?
//how does this algorithm fit into our program so far?
//do not write anything until you can answer these

public class AlphaBeta {
    
    public static int alphaBeta(String[][] currentBoard, int ply, int alpha,int beta,int player){
        //base case
        if(ply == 0){
            return Evaluation.evaluate(currentBoard);
        }
        //the generateMoves method in Patzer.java calls methods from moveGeneration.java
        String color = "w";
        if(player == -1){
            color = "b";
        }
        String movesForCurrentBoard = Patzer.generateMoves(color, currentBoard);
        String[] splitMoves = movesForCurrentBoard.split("|");
        for(int i = 0; i < splitMoves.length; i++){
            if(splitMoves.length > 0){
                Patzer.makeMove(splitMoves[i]);
                int eval = -alphaBeta(currentBoard, ply - 1, -beta, -alpha, -player);
                Patzer.unmakeMove(splitMoves[i]);
                
                if(eval >= beta){
                    return beta;
                }
                
                if(eval > alpha){
                    alpha = eval;
                }
            }
        }
        return alpha;
    }
}
