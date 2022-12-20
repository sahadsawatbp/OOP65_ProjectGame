/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import enemy.*;
import static helpz.Constant.Direction.*;
import static helpz.Constant.Enemies.*;
import static helpz.Constant.Tiles.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import scenes.Playing;
import ui.Images;

public class EnemyManager {
    private Playing playing;
    private BufferedImage enemyImage;
    private BufferedImage[] enemyImgs;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Images allImage;
    private Enemy normal,tanky,thieft,boss;
    private Random random = new Random();
    private int startX = 0,startY = 10,endX = 18,endY = 8;
    private int HpWidth=20;
    public EnemyManager(Playing playing){
        this.playing = playing;
        allImage = new Images();
        enemyImgs = new BufferedImage[4];
    }
    public void draw(Graphics g){
        for(Enemy e: enemies){
            if(e.isAlive()){
                drawEnemy(e,g);
                drawHpBar(e,g);
                drawEffect(e,g);
                
            }
        }
    }
    public void update(){
        for(Enemy e: enemies){
            if(e.isAlive()){
                //e.move(e.getSpeed(), 0);
                //Check what next is roat (position, direction of enemies)
                updateEnemyMove(e);
            }
        }
    }
    
    public void updateEnemyMove(Enemy e){
        if(e.getLastDir() == -1){
            setNewDirectionAndMove(e);
        }
        int newX = (int)(e.getX() + getXSpeedAndWidth(e.getLastDir(),e.getSpeed()));
        int newY = (int)(e.getY() + getYSpeedAndHeight(e.getLastDir(),e.getSpeed()));
        if(getTileType(newX, newY) == ROAD_TILE){
            //Moving same direction
            e.move(e.getSpeed(),e.getLastDir());
        }
        else if(isTheEnd(e)){
            e.kill();
            playing.attackPlayerHp(e.getEnemyType());
        }else{
            setNewDirectionAndMove(e);
        }
        
    }
    public void setNewDirectionAndMove(Enemy e){
        int dir = e.getLastDir();
        //move into current tile 100%
        int xCord = (int)e.getX()/32;
        int yCord = (int)e.getY()/32;
        
        fixEnemyOffsetTile(e,dir,xCord,yCord);
        if(isTheEnd(e)){
            return;
        }
        if(dir == LEFT || dir == RIGHT){
            int newY = (int)(e.getY() + getYSpeedAndHeight(UP,e.getSpeed()));
            if(getTileType((int)e.getX(),newY) == ROAD_TILE){
                e.move(e.getSpeed(),UP);
            }else{
                e.move(e.getSpeed(),DOWN);
            }
        }else{
            int newX = (int)(e.getX() + getXSpeedAndWidth(RIGHT,e.getSpeed()));
            if(getTileType(newX,(int)e.getY())==ROAD_TILE){
                e.move(e.getSpeed(),RIGHT);
            }else{
                e.move(e.getSpeed(),LEFT);
            }
        }
    }
    
    public void fixEnemyOffsetTile(Enemy e,int dir, int xCord, int yCord){
        switch(dir){
            case RIGHT:
                if(xCord < 19){
                    xCord++;
                }
                break;
            case DOWN:
                if(yCord < 19){
                    yCord++;
                }
                break;
        }
        e.setPos(xCord*32, yCord*32);
        
    }
    public boolean isTheEnd(Enemy e){
        if(e.getX() == endX * 32){
            if(e.getY() == endY * 32){
                return true;
            }
        }
        return false;
    }
    public void spawnEnemy(int nextEnemy) {
        addEnemy(nextEnemy);
    }
    public void addEnemy(int enemyType){
        int x = startX*32;
        int y = startY*32;
        switch(enemyType){
            case NORMAL:
                enemies.add(new Normal(x,y,this));
                break;
            case TANKY:
                enemies.add(new Tanky(x,y,this));
                break;
            case THIEFT:
                enemies.add(new Thieft(x,y,this));
                break;
            case BOSS:
                enemies.add(new Boss(x,y,this));
                
                break;
        }
    }
    
    public double getYSpeedAndHeight(int dir,double speed){
        if(dir == UP){
            return -speed;
        }
        else if(dir == DOWN){
            return speed + 32;
        }
        return 0;
    }
    public double getXSpeedAndWidth(int dir,double speed){
        if(dir == LEFT){
            return -speed;
        }
        else if(dir == RIGHT){
            return speed + 32;
        }
        return 0;
    }

    private void drawEnemy(Enemy e,Graphics g) {
        switch (e.getEnemyType()) {
            case NORMAL:
                g.drawImage(allImage.normal_enemy, (int)e.getX(), (int)e.getY(), 32,32,null);
                break;
            case TANKY:
                g.drawImage(allImage.tanky_enemy, (int)e.getX(), (int)e.getY(), 32,32,null);
                break;
            case THIEFT:
                g.drawImage(allImage.thieft_enemy, (int)e.getX(), (int)e.getY(), 32,32,null);
                break;
            case BOSS:
                g.drawImage(allImage.boss_enemy, (int)e.getX(), (int)e.getY(), 32,32,null);
                break;
            default:
                break;
        }
    }

    private void drawHpBar(Enemy e, Graphics g) {
        g.setColor(Color.red);
        int yOffset=0;
        int xWidth = 0;
        switch (e.getEnemyType()) {
            case NORMAL:
                yOffset = 32;
                xWidth =16;
                break;
            case TANKY:
                yOffset = 32;
                xWidth = 16;
                break;
            case THIEFT:
                yOffset = 32;
                xWidth = 16;
                break;
            case BOSS:
                yOffset = 32;
                xWidth = 16;
                break;
            default:
                break;
        }
        g.fillRect((int)e.getX() + xWidth - (getNewHpBar(e)/2), (int)e.getY()+yOffset+2, getNewHpBar(e), 3);
    }
    
    private void drawEffect(Enemy e, Graphics g) {
        if(e.isSlow()){
            g.drawImage(allImage.freeze_effect, (int)e.getX(), (int)e.getY(), null);
        }
    }

    private int getTileType(int x, int y) {
        return playing.getTileType(x, y);
    }
    
    private int getNewHpBar(Enemy e){
        return (int)(HpWidth * e.getHPBar());
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
     public int getLiveEnemy() {
        int size= 0;
        for(Enemy e:enemies){
            if(e.isAlive()){
                size++;
            }
        }
        return size;
    }

    public void giveGold(int enemyType) {
        playing.giveGold(enemyType);
    }
    public void attackPlayerHp(int enemyType){
        playing.attackPlayerHp(enemyType);
    }
    public boolean isWaveIndexDivideByTwo(){
        return playing.getWaveManager().isWaveIndexDivideByTwo();
    }
    public int getWaveIndeex(){
        return playing.getWaveManager().getWaveIndex();
    }

    public void reset() {
        enemies.clear();
    }
    
}
