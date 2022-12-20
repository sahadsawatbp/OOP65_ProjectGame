/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author sahad
 */
public class MyTextButton {
    private int x,y,width,height,id;
    private String text;
    private Rectangle bounds;
    private boolean mouseOver,mousePressed,mouseReleased;
    public MyTextButton(String text,int x,int y,int width,int height){
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initBounds();
    }
    public MyTextButton(String text,int x,int y,int width,int heigh,int id){
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
        initBounds();
    }
    
    private void initBounds(){
        this.bounds = new Rectangle(x,y,width,height);
    }
    public void draw(Graphics g){
        if (mouseOver)
            g.setColor(Color.gray);
        else
            g.setColor(Color.WHITE);
        if(mousePressed){
            g.setColor(Color.GREEN);
        }
        g.fillRect(x, y, width, height);
        
        int w = g.getFontMetrics().stringWidth(text);
        int h = g.getFontMetrics().getHeight();
        g.setColor(Color.BLACK);
	g.drawString(text, x - w / 2 + width / 2, y + h/4  + height / 2);	
        
        
    }
    public Rectangle getBounds(){
        return bounds;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
    
    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public void setMouseReleased(boolean mouseReleased) {
        this.mouseReleased = mouseReleased;
    }

    public int getId() {
        return id;
    }

    public boolean isMouseOver() {
        return mouseOver;
    }
    
    
}
