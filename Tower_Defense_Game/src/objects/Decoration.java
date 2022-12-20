/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import java.awt.image.BufferedImage;

/**
 *
 * @author sahad
 */
public class Decoration {
    private BufferedImage[] sprite;
    private int id;
    public Decoration(BufferedImage sprite,int id){
        this.sprite = new BufferedImage[1];
        this.sprite[0] = sprite;
        this.id = id;
    }
    public Decoration(BufferedImage[] sprite,int id){
        this.sprite = sprite;
        this.id = id;
    }
    public BufferedImage getSprite(int animationIndex) {
        return sprite[animationIndex];
    }
    public BufferedImage getSprite() {
        return sprite[0];
    }
    public boolean isAnimation(){
        return sprite.length > 1;
    }
    
}
