/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import enemy.Enemy;
import helpz.Constant;
import static helpz.Constant.Enemies.*;
import static helpz.Constant.Mages.*;
import static helpz.Constant.Projectiles.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import objects.MageTower;
import objects.MagicProjectile;
import scenes.Playing;
import ui.Images;

/**
 *
 * @author sahad
 */
public class ProjectileManager {
    private Playing playing;
    private ArrayList<MagicProjectile> magic = new ArrayList<>();
    private ArrayList<Effect> effect = new ArrayList<>();
    private Image[] projectImg;
    private BufferedImage[] effectWind;
    private Images image = new Images();
    private int proj_id;
    private int tier;
    public ProjectileManager(Playing playing){
        this.playing = playing;
        importImage();
    }
    
    private void importImage(){
        projectImg = new Image[4];
        projectImg[0] = image.windSpell;
        projectImg[2] = image.iceBolt;
        projectImg[3] = image.rockSpell;
        projectImg[1] = image.fireBolt;
        importEffect();
    }
    private void importEffect() {
        effectWind = new BufferedImage[21];
        for(int i=0;i<4;i++){
            effectWind[i] = image.wind_effect.getSubimage(50 * i, 0, 50, 50);
        }
    }
    public void newProjectile(MageTower m, Enemy e){
        int type = getProjectileType(m);
        
        int xDistance = (int)(m.getX() - e.getX());
        int yDistance = (int)(m.getY() - e.getY());
        int totalDistance = Math.abs(xDistance)+Math.abs(yDistance);
        
        float xPercent = (float)Math.abs(xDistance) / totalDistance;
        float yPercent = 1.0f - xPercent;
        
        float xSpeed = xPercent * Constant.Projectiles.GetSpeed(type);
        float ySpeed = yPercent * Constant.Projectiles.GetSpeed(type);
        
        if(m.getX() > e.getX()){
            xSpeed *= -1;
        }
        if(m.getY() > e.getY()){
            ySpeed *= -1;
        }
        float arcValue = (float)Math.atan(yDistance / (float)xDistance);
        float rotate=(float)Math.toDegrees(arcValue);
        if(xDistance < 0){
            rotate += 180;
        }
        magic.add(new MagicProjectile(m.getX() + 16,m.getY() +16,xSpeed,ySpeed,m.getDamage(),rotate,proj_id++,type,m.getTier()));
    } 
    public void update(){
        for(MagicProjectile m : magic){
            if(m.isActive()){
                m.move();
                if(isHitEnemy(m)){
                    m.setActive(false);
                    effect.add(new Effect(m.getPos()));
                    if(m.getMagicType() == WIND){
                        
                        if(isTier3(m)){
                            AoEonEnemies(m);
                        }
                        
                    }
                    else if(m.getMagicType() == FIRE){
                        
                    }
                }else if(isNotHitEnemy(m)){
                    m.setActive(false);
                }
            }
        }
         for(Effect e:effect){
             e.update();
                    
         }
    }
    private boolean isHitEnemy(MagicProjectile m) {
        for(Enemy e:playing.getEnemyManager().getEnemies()){
            if(e.isAlive()){
                if(e.getBounds().contains(m.getPos())){
                    if(m.getMagicType() == ICE)
                        e.slow();
                    
                    else if(isEnemyHasShield(e)){
                        if(!(m.getMagicType() == EARTH)){
                            e.attacked(m.getDmg()/2);
                            
                        }else{
                            e.attacked(m.getDmg()*3);
                            
                        }
                    }
                    else{
                        e.attacked(m.getDmg());
                    }
                    return true;
                }
            }
        }
        return false;
    }
     private boolean isNotHitEnemy(MagicProjectile m) {
        if(m.getPos().x >= 0){
            if(m.getPos().x <= 640){
                if(m.getPos().y >= 0){
                    if(m.getPos().y <= 630){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean isEnemyHasShield(Enemy e){
        return e.getEnemyType() == TANKY;
    }
    private void AoEonEnemies(MagicProjectile m) {
        for(Enemy e:playing.getEnemyManager().getEnemies()){
            if(e.isAlive()){
                float radius = 40f;
                float xDist = Math.abs(m.getPos().x - e.getX());
                float yDist = Math.abs(m.getPos().y - e.getY());
                float realDist = (float)Math.hypot(xDist, yDist);
                if(realDist<=radius){
                    e.attacked(m.getDmg());
                }    
            }
            
        }
    }
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        
        for(MagicProjectile m : magic){
                if(m.isActive()){
                g2d.translate(m.getPos().x, m.getPos().y);
                g2d.rotate(Math.toRadians(m.getRotate()));
                g2d.drawImage(projectImg[m.getMagicType()], -16, -16,20,20, null);
                g2d.rotate(-Math.toRadians(m.getRotate()));
                g2d.translate(-m.getPos().x, -m.getPos().y);
                }
                drawEffect(g2d);
            }
    }
    private void drawEffect(Graphics2D g2d) {
        int w = 40;
        int h =40;
        for(Effect e:effect){
            if(e.getIndex() < 11){
                g2d.drawImage(effectWind[e.getIndex()], (int)e.getPos().x-w/2, (int)e.getPos().y-h/2,w,h,null);
            }
        }
    }
    public int getProjectileType(MageTower m){
        switch(m.getTowerType()){
            case ICE:
                return ICE_SPELL;
            case EARTH:
                return EARTH_SPELL;
            case WIND:
                return WIND_SPELL;
            case FIRE:
                return FIRE_SPELL;
        }
        return 0;
    }

    private boolean isTier3(MagicProjectile m) {
        if(m.getTier() == 3){
            return true;
        }
        return false;
    }

    public void reset() {
        magic.clear();
        effect.clear();
        proj_id=0;
    }

   

    

    

    public class Effect{
        private Point2D.Float pos;
        private int effectTick=0,effectIndex=0;
        public Effect(Point2D.Float pos){
            this.pos = pos;
        }
        public void update(){
            effectTick++;
            if(effectTick >= 7){
                effectTick = 0;
                effectIndex++;
            }
        }
        public int getIndex(){
            return effectIndex;
        }
        public Point2D.Float getPos(){
            return pos;
        }
    }

    
}
