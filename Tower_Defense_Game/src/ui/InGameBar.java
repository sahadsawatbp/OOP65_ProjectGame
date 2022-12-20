/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import helpz.Constant;
import helpz.Constant.Mages;
import static helpz.Constant.Mages.GetCostMage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import static main.GameStates.*;
import objects.MageTower;
import scenes.Playing;

/**
 *
 * @author sahad
 */
public class InGameBar {
    private int x,y,width,height,id;
    private MyButton bMenu,bPause;
    private Images allImage;
    private MyButton[] mageButton;
    private Playing playing;
    private MageTower selectedTower;
    private MageTower mageInfro;
    private final Font font = new Font("Monospaced", Font.BOLD, 15);
    private DecimalFormat formatter;
    private boolean showMage;
    private int imageIndex;
    private int gold = Constant.GOLD;
    private int playerHp = Constant.playerHP;
    private BufferedImage[] mage_Button;
    private MyTextButton sellButton,upgradeButton;
    public InGameBar(int x,int y,int width,int height, Playing playing){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.playing = playing;
        allImage = new Images();
        formatter = new DecimalFormat("0.0");
        initButtons();
    }
    public void draw(Graphics g){
        g.setColor(new Color(0,0,0));
        g.fillRect(x, y, width, height);
        drawButtons(g);
        drawDisplayMageInfro(g);
        //Wave Infromation
        drawWaveInfro(g);
        //Gold Infromation
        drawGoldInfro(g);
        //Mage infro
        drawMageBox(g);
        //Player HP
        drawPlayerHP(g);
    }
   
    private void drawGoldInfro(Graphics g) {
        g.drawString("Gold: "+gold+"$", 10, 780);
    }
    private void drawButtons(Graphics g) {
        bMenu.draw(g);
        bPause.draw(g);
        for(MyButton m : mageButton){
            m.draw(g);
            
        }
    }
    private void drawWaveInfro(Graphics g){
        g.setFont(font);
        g.setColor(Color.WHITE);
        drawWaveLeft(g);
        drawEnemiesLeft(g);
        drawWaveTimerInfro(g);
    }
    private void drawWaveTimerInfro(Graphics g) {
        if(playing.getWaveManager().isWaveTimerStarted()){
            float timeLeft = playing.getWaveManager().getTimeLeft();
            String formatText = formatter.format(timeLeft);
            g.drawString("Time Left: " + formatText, 10, 720);
        }
    }

    private void drawWaveLeft(Graphics g) {
        int current = playing.getWaveManager().getWaveIndex();
        int size = playing.getWaveManager().getWaves().size();
        g.drawString("Wave: "+(current+1)+"/"+size, 10, 740);
    }
    private void drawEnemiesLeft(Graphics g) {
        int remaining = playing.getEnemyManager().getLiveEnemy();
        g.drawString("Enemies left: "+remaining, 10, 760);
    }
    private void initButtons() {
        bMenu = new MyButton(allImage.menu_button,10,644,80,25);
        bPause = new MyButton(allImage.pause_button,10,675,80,25);
        mage_Button = new BufferedImage[4];
        mageButton = new MyButton[4];
        int w = 50;
        int h = 50;
        int xStart = 50;
	int yStart = 644;
	int xOffset = (int) (w * 1.3f);
        mage_Button[0] = allImage.wind_button;
        mage_Button[1] = allImage.fire_button;
        mage_Button[2] = allImage.ice_button;
        mage_Button[3] = allImage.earth_button;
        mageButton[0] = new MyButton(mage_Button[0],xStart + xOffset * 1,yStart,w,h,0);
        mageButton[1] = new MyButton(mage_Button[1],xStart + xOffset * 2,yStart,w,h,1);
        mageButton[2] = new MyButton(mage_Button[2],xStart + xOffset * 3,yStart,w,h,2);
        mageButton[3] = new MyButton(mage_Button[3],xStart + xOffset * 4,yStart,w,h,3);
        sellButton = new MyTextButton("Sell", 460, 700 ,50,20);
        upgradeButton = new MyTextButton("Upgrade", 520, 700 ,80,20);
        
    }
  
    
    
    public void displayMageInfro(MageTower mt) {
        mageInfro = mt;
    }
    private void drawDisplayMageInfro(Graphics g){
        if(mageInfro != null){
            g.drawImage(playing.getMageTowerManager().getMageSprite()[mageInfro.getTowerType()], 400,650 ,48 ,64 ,null);
            g.setFont(font);
            if(mageInfro.getTier() == 1){
                g.setColor(Color.white);
                g.drawString("Common " + Mages.GetNameMage(mageInfro.getTowerType()), 460, 670);
            }else if(mageInfro.getTier() == 2){
                g.setColor(Color.BLUE);
                g.drawString("Mystic " + Mages.GetNameMage(mageInfro.getTowerType()), 460, 670);
            }else{
                g.setColor(Color.ORANGE);
                g.drawString("Legendary " + Mages.GetNameMage(mageInfro.getTowerType()), 460, 670);
            }
//            g.drawString("" + Mages.GetNameMage(mageInfro.getTowerType()), 460, 670);
            //Draw Range
            drawRangeMage(g);
            //Sell
            
            sellButton.draw(g);
            //Upgradea
            if(mageInfro.getTier() < 3){
                upgradeButton.draw(g);
            }
            if(sellButton.isMouseOver()){
                g.setColor(Color.GREEN);
                g.drawString("Receive gold: "+getSellGold(mageInfro)+"$", 460, 690);
            }else if(upgradeButton.isMouseOver()){
                if(!isCanUpgrade(mageInfro.getTowerType())){
                    g.setColor(Color.RED);
                }else{
                    g.setColor(Color.GREEN);
                }
                g.drawString("Upgrade: "+getUpgradeGold(mageInfro)+"$", 460, 690);
            }else {
                g.setColor(Color.WHITE);
                g.drawString(getAbilityMage(mageInfro), 460, 690);
            }
        }
        
    }
    private void drawMageBox(Graphics g){
        int yOffset = 20;
        if(showMage){
            g.drawRect(190, 700, 170, 80);
            g.drawRect(195, 705, 160, 70);
            g.setColor(Color.white);
            g.setFont(font);
            g.drawString("" + getNameMage(), 230, 725);
            g.drawString("Price : " + getCostMage() + "$", 220, 725 + yOffset);
            if(notEnoughGold()){
                g.setColor(Color.RED);
                g.drawString("Not enough gold", 210, 725 + yOffset*2);
            }
        }
        
    }
    public void setMageInfro(MageTower mageInfro) {
        this.mageInfro = mageInfro;
    }

    public void drawRangeMage(Graphics g) {
        int range = (int)mageInfro.getRange()*2;
        g.drawRect(mageInfro.getX(), mageInfro.getY(), 32, 32);
        g.setColor(Color.WHITE);
        g.drawOval(mageInfro.getX() - range/2 + 16, 
                mageInfro.getY() - range/2 + 16, range, range);
    }
    private void drawPlayerHP(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Monospaced", Font.BOLD, 20));
        g.drawImage(allImage.player_hp, 370, 750,32,32,null);
        g.drawString("Player HP: "+this.playerHp, 410, 775);
        g.drawImage(allImage.player_hp, 600, 750,32,32,null);
    }
    public void pause() {
        if(playing.isPause() == false){
            bPause.setImage(allImage.unPause_button);
            playing.setPause(true);
        }else{
            bPause.setImage(allImage.pause_button);
            playing.setPause(false);
        }
        
    }
    private void upgradeTower() {
        playing.upgradeTower(mageInfro);
        this.gold -= getUpgradeGold(mageInfro);
    }
    private void sellTower() {
        playing.sellTower(mageInfro);
        this.gold += GetCostMage(mageInfro.getTowerType())/2 ;
        int upgradeGold = getUpgradeGold(mageInfro) * (mageInfro.getTier()-1);
        upgradeGold *= 0.5f;
        this.gold += upgradeGold;
        mageInfro = null;
    }
    public void giveGold(int amount) {
        this.gold += amount;
    }
    public void payForTower(int towerType) {
        this.gold -= GetCostMage(towerType);
    }
    private boolean isGoldEnough(int towerType) {
        return (gold >= GetCostMage(towerType));
    }
    private boolean isCanUpgrade(int towerType){
        return (gold >= GetCostMage(towerType)*2);
    }
    private boolean notEnoughGold(){
        return getCostMage() > gold;
    }
    private String getNameMage(){
        return Mages.GetNameMage(imageIndex);
    }
    private int getCostMage(){
        return Mages.GetCostMage(imageIndex);
    }

    private int getSellGold(MageTower mageInfro) {
        int upgradeGold = getUpgradeGold(mageInfro) * (mageInfro.getTier()-1);
        upgradeGold *= 0.5f;
        return Mages.GetCostMage(mageInfro.getTowerType())/3 + upgradeGold;
    }

    private int getUpgradeGold(MageTower mageInfro) {
        return Mages.GetCostMage(mageInfro.getTowerType())*2;
    }

    private String getAbilityMage(MageTower mageInfro) {
        return Mages.GetAbilityMage(mageInfro.getTowerType());
    }

    public void attackPlayerHp(int damage){
        this.playerHp -= damage;
        if(playerHp <=0){
            SetGameState(GAMEOVER);
            playing.playSE(2);
            playing.volumeDown(5);
        }
    }
    
    public void mouseClicked(int x, int y) {
        if(bMenu.getBounds().contains(x, y)){
            SetGameState(MENU);
            
        }else if(bPause.getBounds().contains(x,y)){
            pause();
        }else{
            if(sellButton.getBounds().contains(x,y)){
                playing.getGame().playSE(1);
                sellTower();
                return;
            }else if(upgradeButton.getBounds().contains(x,y) && mageInfro.getTier() < 3){
                if(this.isCanUpgrade(mageInfro.getTowerType())){
                    playing.getGame().playSE(1);
                    upgradeTower();
                    return;
                }
            }
            for(MyButton m:mageButton){
                if(m.getBounds().contains(x,y)){
                    if(!isGoldEnough(m.getId())){
                        return;
                    }
                        playing.getGame().playSE(1);
                        selectedTower = new MageTower(x,y,m.getId(),id++);
                        playing.setSelectedTower(selectedTower);
                        return;
                }else{
                    
                }
            }
        }
    }    
    public void mouseMove(int x, int y) {
        bMenu.setMouseOver(false);
        bPause.setMouseOver(false);
        sellButton.setMouseOver(false);
        upgradeButton.setMouseOver(false);
        for(MyButton m : mageButton){
            m.setMouseOver(false);
        }
        
        if(bMenu.getBounds().contains(x, y)){
            bMenu.setMouseOver(true);
        }else if(bPause.getBounds().contains(x,y)){
            bPause.setMouseOver(true);
        }else if(sellButton.getBounds().contains(x,y)){
            sellButton.setMouseOver(true);
        }else if(upgradeButton.getBounds().contains(x,y)){
            upgradeButton.setMouseOver(true);
        }
        else{
            for(MyButton m : mageButton){
                if(m.getBounds().contains(x,y)){
                    m.setMouseOver(true);
                    showMage = true;
                    imageIndex = m.getId();
                }
            }
        }
    }
    public void mousePressed(int x, int y) {
        bMenu.setMousePressed(false);
        bPause.setMousePressed(false);
        sellButton.setMousePressed(false);
        upgradeButton.setMousePressed(false);
        if(bMenu.getBounds().contains(x, y)){
            bMenu.setMousePressed(true);
        }else if(bPause.getBounds().contains(x,y)){
            bPause.setMousePressed(true);
        }else if(sellButton.getBounds().contains(x,y)){
            sellButton.setMousePressed(true);
        }else if(upgradeButton.getBounds().contains(x,y)){
            upgradeButton.setMousePressed(true);
        }
    }
    public void mouseReleased(int x, int y) {
        bMenu.setMousePressed(false);
        sellButton.setMousePressed(false);
        upgradeButton.setMousePressed(false);
        bPause.setMousePressed(false);
    }

    public int getPlayerHp() {
        return playerHp;
    }
    public void reset(){
        playerHp = Constant.playerHP;
        showMage=false;
        imageIndex=0;
        gold=Constant.GOLD;
        mageInfro=null;
        selectedTower=null;
    }
    
    
    
    
}
