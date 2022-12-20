/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import helpz.Constant;
import static helpz.Constant.Mages.*;

/**
 *
 * @author sahad
 */
public class MageTower {
    private int x,y,cdTick;
    private int towerType;
    private int damage;
    private double range,cooldown;
    private int id;
    private int tier;
    public MageTower(int x, int y,int towerType,int id){
        this.x = x;
        this.y = y;
        this.towerType = towerType;
        this.id = id;
        this.tier = 1;
        setDamage();
        setRange();
        setCooldown();
    }
    public void upgradeTower(){
        tier++;
        switch(towerType){
            case ICE:
                range += 10;
                cooldown -= 5;
                break;
            case EARTH:
                damage *= 2;
                range += 10;
                cooldown -= 5;
                break;
            case WIND:
                damage *= 2;
                range += 10;
                cooldown -= 5;
                break;
            case FIRE:
                damage *= 2;
                range += 10;
                cooldown -= 5;
                break;
        }
    }
    public void update(){
        cdTick++;
    }
    public boolean isCooldownOver() {
        
        return cdTick >= cooldown;
    }

    public void resetCooldown() {
        cdTick = 0;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTowerType() {
        return towerType;
    }

    private void setDamage() {
        damage = Constant.Mages.GetDamageMage(towerType);
    }

    private void setRange() {
        range = Constant.Mages.GetRangeMage(towerType);
    }

    private void setCooldown() {
        cooldown = Constant.Mages.GetCooldownMage(towerType);
    }

    public int getDamage() {
        return damage;
    }

    public double getRange() {
        return range;
    }

    public double getCooldown() {
        return cooldown;
    }

    public int getId() {
        return id;
    }

    public int getTier() {
        return tier;
    }
    
    
   

   

    
        
    
}
