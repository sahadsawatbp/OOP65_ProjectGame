/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemy;

import java.awt.Rectangle;
import static helpz.Constant.Direction.*;
import helpz.Constant.Enemies;
import static helpz.Constant.Enemies.*;
import managers.EnemyManager;
/**
 *
 * @author sahad
 */
public abstract class Enemy {
    protected float x,y;
    protected Rectangle bounds;
    protected int HP,maxHP,temHP;
    protected float speed;
    protected int enemyType;
    protected int lastDir;
    protected boolean alive = true;
    protected int slowTickLimit = 50;
    protected int slowTick=slowTickLimit;
    protected EnemyManager enemyManager;
    public Enemy(float x,float y,int enemyType,EnemyManager enemyManager){
        this.enemyManager = enemyManager;
        this.x=x;
        this.y=y;
        this.speed = Enemies.GetSpeed(enemyType);
        this.enemyType=enemyType;
        bounds = new Rectangle((int)x,(int)y,32,32);
        this.lastDir = -1;
        setEnemieHealth();
    }
    private void setEnemieHealth(){
        HP = Enemies.GetHealth(enemyType);
        maxHP = HP;
    }
    private void increaseEnemyHp(){
        HP = maxHP;
        if(enemyManager.isWaveIndexDivideByTwo()){
            HP *= 1.35;
        }
    }
    public float getHPBar(){
        return HP/(float)maxHP;
    }
    public void slow() {
        slowTick = 0;
    }
    public void kill() {
        //reach the end
        this.alive = false;
        this.HP = 0;
    }
    public void move(float speed,int dir){
        lastDir = dir;
        if(slowTick < slowTickLimit){
            slowTick ++;
            speed *= 0f;
        }
        switch(dir){
            case LEFT:
                this.x -= speed;
                break;
            case UP:
                this.y -= speed;
                break;
            case RIGHT:
                this.x += speed;
                break;
            case DOWN:
                this.y += speed;
                break;
        }
        updateHitBox();
    }
    
    private void updateHitBox() {
        bounds.x = (int)x;
        bounds.y = (int)y;
    }
    
    public void setPos(int x,int y){
        //for fix pos not fir moving
        this.x = x;
        this.y = y;
    }
    public void attacked(int dmg) {
//        if(enemyType == TANKY){
//            this.HP -= dmg/2;
//        }else
            this.HP -= dmg;
        
        if(this.HP <= 0){
            alive = false;
            enemyManager.giveGold(enemyType);
        }
    }
    
    public Rectangle getBounds() {
        return bounds;
    }
    
    public int getHP() {
        return HP;
    }
    
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getSpeed() {
        return speed;
    }

    public int getEnemyType() {
        return enemyType;
    }

    public int getLastDir() {
        return lastDir;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public boolean isAlive() {
        return alive;
    }
    public boolean isSlow(){
        return slowTick < slowTickLimit;
    }

    
    

    
    
    
    
    
}
