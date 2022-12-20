/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import enemy.Enemy;
import helpz.Utilz;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import objects.MageTower;
import scenes.Playing;
import ui.Images;

/**
 *
 * @author sahad
 */
public class MageTowerManager {
    private Playing playing;
    private BufferedImage[] mageButtonSprite;
    private Image[] mageSprite;
    private ArrayList<MageTower> mages = new ArrayList<>();
    private Images images;
    private int id;
    public MageTowerManager(Playing playing){
        this.playing = playing;
        images = new Images();
        drawMageSprite();
    }
    
    public void draw(Graphics g){
        for(MageTower m:mages){
            g.drawImage(mageSprite[m.getTowerType()], m.getX(), m.getY()-26,32,48, null);
        }
    }

    

    private void drawMageSprite() {
        mageSprite = new Image[4];
        mageSprite[0] = images.wind_mage;
        mageSprite[1] = images.fire_mage;
        mageSprite[2] = images.ice_mage;
        mageSprite[3] = images.earth_mage;
        
        
    }
    
    public void update() {
        for(MageTower m:mages){
            m.update();
            spellEnemy(m);
        }
    }
    private void spellEnemy(MageTower m) {
        for(Enemy e: playing.getEnemyManager().getEnemies()){
            if(e.isAlive()){
                if(isEnemyInRange(m,e)){
                    if(m.isCooldownOver()){
                        //attack
                        playing.shootEnemy(m,e);
                        m.resetCooldown();

                    }
                }
            }
        }
    }
    private boolean isEnemyInRange(MageTower m, Enemy e) {
        int range = Utilz.GetHypoDistance(m.getX(), m.getY(), e.getX(), e.getY());
        return range < m.getRange();
    }
    
    public void addTower(MageTower selectedTower, int x, int y) {
        mages.add(new MageTower(x,y,selectedTower.getTowerType(),id++));
    }
    public void upgradeTower(MageTower mageInfro) {
        for(MageTower m:mages){
            if(m.getId() == mageInfro.getId()){
                m.upgradeTower();
            }
        }
    }
    public void sellTower(MageTower mageInfro) {
        for(int i = 0;i<mages.size();i++){
            if(mageInfro.getId() == mages.get(i).getId()){
                mages.remove(i);
            }
        }
    }
    public MageTower getPosTower(int x, int y) {
        for(MageTower m:mages)
            if(m.getX() == x)
                if(m.getY() == y)
                    return m;
        return null;
    }
    public BufferedImage[] getMageButtonSprite() {
        return mageButtonSprite;
    }

    public Image[] getMageSprite() {
        return mageSprite;
    }

    public void reset() {
        mages.clear();
        id=0;
    }

    

    
    

   
}
    

