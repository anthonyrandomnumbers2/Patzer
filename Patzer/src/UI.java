import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//Credit to Logic Crazy Chess; youtube for chess piece image
//and tutorial on awt and swing
public class UI extends JPanel implements MouseListener, MouseMotionListener{
    static int x = 0, y = 0;

    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        Image pieces = new ImageIcon("ChessPieces.png").getImage();
        g.setColor(Color.blue);
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(i%2 ==0 && j%2 != 0){
                    g.fillRect(i*64,j*64 ,64,64);
                }else if( i%2 != 0 && j%2 == 0){
                    g.fillRect(i*64,j*64 ,64,64);
                }
                else
                    g.drawRect(i*64,j*64 ,64,64);
            }
        }   
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(Patzer.board[i][j].equals("bP")){
                    g.drawImage(pieces, j*64, i*64, j*64+64 , i*64+64, 320, 64, 380, 128, this);
                }
                if(Patzer.board[i][j].equals("bB")){
                    g.drawImage(pieces, j*64, i*64, j*64+64 , i*64+64, 192, 64, 256, 128, this);
                }
                if(Patzer.board[i][j].equals("bK")){
                    g.drawImage(pieces, j*64, i*64, j*64+64 , i*64+64, 0, 64, 64, 128, this);
                }
                if(Patzer.board[i][j].equals("bN")){
                    g.drawImage(pieces, j*64, i*64, j*64+64 , i*64+64, 256, 64, 320, 128, this);
                }
                if(Patzer.board[i][j].equals("bR")){
                    g.drawImage(pieces, j*64, i*64, j*64+64 , i*64+64, 128, 64, 190, 128, this);   
                }
                if(Patzer.board[i][j].equals("bQ")){
                    g.drawImage(pieces, j*64, i*64, j*64+64 , i*64+64, 64, 64, 128, 128, this);
                }
                if(Patzer.board[i][j].equals("wQ")){
                    g.drawImage(pieces, j*64, i*64, j*64+64 , i*64+64, 64, 0, 128, 64, this);
                }
                if(Patzer.board[i][j].equals("wP")){
                    g.drawImage(pieces, j*64, i*64, j*64+64 , i*64+64, 320, 0, 384, 64, this);
                }
                if(Patzer.board[i][j].equals("wB")){
                    g.drawImage(pieces, j*64, i*64, j*64+64 , i*64+64, 190, 0, 256, 64, this);
                }
                if(Patzer.board[i][j].equals("wK")){
                    g.drawImage(pieces, j*64, i*64, j*64+64 , i*64+64, 0, 0, 64, 64, this);
                }
                if(Patzer.board[i][j].equals("wN")){
                    g.drawImage(pieces, j*64, i*64, j*64+64 , i*64+64, 256, 0, 320, 64, this);
                }
                if(Patzer.board[i][j].equals("wR")){
                    g.drawImage(pieces, j*64, i*64, j*64+64 , i*64+64, 128, 0, 190, 64, this);
                }
                if(Patzer.board[i][j].equals("wQ")){
                    g.drawImage(pieces, j*64, i*64, j*64+64 , i*64+64, 64, 0, 128, 64, this);
                }
            }
        }
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
         
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
         
    }
}
