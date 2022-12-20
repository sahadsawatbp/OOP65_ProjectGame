/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author sahad
 */
public class MyImage {
    private BufferedImage img;
    private int x,y,width,height;
    public MyImage(BufferedImage img,int x,int y,int width,int height){
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void draw(Graphics g){
        g.drawImage(img, x, y,width,height,null);
    }
}
