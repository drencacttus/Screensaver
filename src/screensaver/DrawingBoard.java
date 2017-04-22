package screensaver;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.Timer;

public class DrawingBoard extends JFrame {
    
    private DrawingShape drawingShape = new DrawingShape(DrawingShape.Shape.FILL_OVAL, 
                                                        Color.red, 
                                                        0, 0, 50, 50);
    
    private Point position = new Point();
    private Point velocity = new Point();
    
    private Timer tmrTime = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            drawingShape.setX(drawingShape.getX() + velocity.x);
            drawingShape.setY(drawingShape.getY() + velocity.y);
            
            if(drawingShape.getX() > getWidth() - drawingShape.getWidth()) {
            
                velocity.x = -velocity.x;
            }
            
            if(drawingShape.getX() < 0) {
            
                velocity.x = -velocity.x;
            }
            
            
            if(drawingShape.getY() > getHeight() - drawingShape.getHeight()) {
            
                velocity.y = -velocity.y;
            }
            
            if(drawingShape.getY() < 0) {
            
                velocity.y = -velocity.y;
            }
            
            repaint();
        }
    });
    
    public DrawingBoard() {
    
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tmrTime.start();
       
        velocity.x = 3;
        velocity.y = 4;
    }
    
    @Override
    public void paint(Graphics g) 
    {
        //Krijo nje image per Double Buffering
        BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        
        
        //E pastron dritaren
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        //Vizato drejtkendeshin
        drawingShape.draw(g2d);

        
        //Vizato image per Double Buffering
        Graphics2D g2dComponent = (Graphics2D) g;
        g2dComponent.drawImage(bufferedImage, null, 0, 0);  
    }
}
