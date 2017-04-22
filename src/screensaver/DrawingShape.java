/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensaver;

import java.awt.Color;
import java.awt.Graphics;

public class DrawingShape {
    
    private int width, height, x, y;
    private Color color;
    private Shape type;
    
    public enum Shape {
    
        OVAL,
        RECTANGLE,
        FILL_OVAL,
        FILL_RECTANGLE,
    }
    
    public DrawingShape(Shape type, Color color, 
                        int x, int y, 
                        int width, int height) {
    
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void draw(Graphics g) {
    
        g.setColor(color);
        
        switch(type) {
        
            case RECTANGLE:
                g.drawRect(x, y, width, height);
                break;
                
            case OVAL:
                g.drawOval(x, y, width, height);
                break;
                
            case FILL_RECTANGLE:
                g.fillRect(x, y, width, height);
                break;
                
            case FILL_OVAL:
                g.fillOval(x, y, width, height);
                break;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
