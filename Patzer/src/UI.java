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
                    g.fillRect(i*60,j*60 ,60,60);
                }else if( i%2 != 0 && j%2 == 0){
                    g.fillRect(i*60,j*60 ,60,60);
                }
                else
                    g.drawRect(i*60,j*60 ,60,60);
            }
        }   
        //g.drawImage(pieces, 200, 300,40,50, this);
       //g.drawI
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
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
