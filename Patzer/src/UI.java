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
        g.drawImage(pieces, x, y, this);
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
