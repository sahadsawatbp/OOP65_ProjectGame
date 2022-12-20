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
public class MyButton {
    private int x,y,width,height,id;
    private String text;
    private BufferedImage img;
    private Rectangle bounds;
    private boolean mouseOver,mousePressed,mouseReleased;
    public MyButton(BufferedImage img,int x,int y,int width,int height){
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initBounds();
    }
    public MyButton(BufferedImage img,int x,int y,int width,int height,int id){
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
        initBounds();
    }
    
    public void setImage(BufferedImage img){
        this.img = img;
    }
    private void initBounds(){
        this.bounds = new Rectangle(x,y,width,height);
    }
    public void draw(Graphics g){
        if(mousePressed){
            g.drawImage(img, x+2, y+1,width-4,height-2,null);
        }
        else if(mouseOver){
            g.drawImage(img, x-2, y-1,width+4,height+2,null);
        }
        else{
            g.drawImage(img, x, y,width,height,null);
        }
        
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
    
    
}
