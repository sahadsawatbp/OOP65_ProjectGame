/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author sahad
 */
public class Images {
    public BufferedImage img,start_button,logoImage,quit_button,background;
    public BufferedImage menu_button,pause_button,unPause_button;
    public BufferedImage gameOver,defeat,backToMenu,vUp_button,vDown_button,gameVictory;
    public Image normal_enemy,tanky_enemy,thieft_enemy,boss_enemy;
    public Image wind_mage,fire_mage,earth_mage,ice_mage;
    public Image fireBolt,rockSpell,iceBolt,windSpell;
    public BufferedImage big_Tree,cut_Tree,big_Brush,farm,ver_brush,hor_brush;
    public BufferedImage wind_button,ice_button,fire_button,earth_button;
    public BufferedImage wind_effect,freeze_effect,fire_effect;
    public Image player_hp;
    public int x,y,width,height;
    public Images(){
        importImg();
    }
    private void importImg() {
        InputStream logo = getClass().getResourceAsStream("/res/logo.png");
        InputStream bg = getClass().getResourceAsStream("/res/background.png");
        //Enemies
        File normalEnemy = new File("src/res/enemy/Normal.gif");
        File tankyEnemy = new File("src/res/enemy/Tanky.gif");
        File thieftEnemy = new File("src/res/enemy/Thieft.gif");
        File bossEnemy = new File("src/res/enemy/Boss.gif");
        //Mages
        File windMage = new File("src/res/mage/WindMage.gif");
        File iceMage = new File("src/res/mage/IceMage.gif");
        File earthMage = new File("src/res/mage/EarthMage.gif");
        File fireMage = new File("src/res/mage/FireMage.gif");
        //Mage buttons
        InputStream windButton = getClass().getResourceAsStream("/res/button/wind_button.png");
        InputStream fireButton = getClass().getResourceAsStream("/res/button/fire_button.png");
        InputStream iceButton = getClass().getResourceAsStream("/res/button/ice_button.png");
        InputStream earthButton = getClass().getResourceAsStream("/res/button/earth_button.png");
        //UI
        InputStream startButton = getClass().getResourceAsStream("/res/button/start_button.png");
        InputStream quitButton = getClass().getResourceAsStream("/res/button/quit_button.png");
        InputStream menu = getClass().getResourceAsStream("/res/button/menu.png");
        InputStream pause = getClass().getResourceAsStream("/res/button/pause.png");
        InputStream unPause = getClass().getResourceAsStream("/res/button/unpause.png");
        InputStream gameOverBg = getClass().getResourceAsStream("/res/gameover.png");
        InputStream vUp = getClass().getResourceAsStream("/res/vUp.png");
        InputStream vDown = getClass().getResourceAsStream("/res/vDown.png");
        File playerHP = new File("src/res/heart.gif");
        InputStream defeatImg = getClass().getResourceAsStream("/res/defeat.png");
        InputStream backMenu = getClass().getResourceAsStream("/res/backtomenu.png");
        InputStream gameVictoryBg = getClass().getResourceAsStream("/res/gamevictory.png");
        //Magic spell
        File fire_Bolt = new File("src/res/mage/spell/firebolt.gif");
        File rock_Spell = new File("src/res/mage/spell/rock.gif");
        File ice_Bolt = new File("src/res/mage/spell/icebolt.gif");
        File wind_Spell = new File("src/res/mage/spell/windspell.gif");
        //Magic Effect
        InputStream windEffect = getClass().getResourceAsStream("/res/effect/wind_effect.png");
        InputStream freezeEffect = getClass().getResourceAsStream("/res/effect/freeze_effect.png");
        InputStream fireEffect = getClass().getResourceAsStream("/res/effect/fire_effect.png");
        
        
        //Map
        InputStream is = getClass().getResourceAsStream("/res/decoration_map/map.png");
        InputStream farmFile = getClass().getResourceAsStream("/res/decoration_map/Farm.gif"); 
        InputStream bigTree = getClass().getResourceAsStream("/res/decoration_map/big_tree.png");
        InputStream cutTree = getClass().getResourceAsStream("/res/decoration_map/cut_tree.png");
        InputStream bigBrush = getClass().getResourceAsStream("/res/decoration_map/big_brush.png");
        InputStream verBrush = getClass().getResourceAsStream("/res/decoration_map/vertical_brush.png");
        InputStream horBrush = getClass().getResourceAsStream("/res/decoration_map/horizontal_brush.png");
        try {
            logoImage = ImageIO.read(logo);
            background = ImageIO.read(bg);
            //Enemies
            normal_enemy = new ImageIcon(normalEnemy.getAbsolutePath()).getImage();
            tanky_enemy = new ImageIcon(tankyEnemy.getAbsolutePath()).getImage();
            thieft_enemy = new ImageIcon(thieftEnemy.getAbsolutePath()).getImage();
            boss_enemy = new ImageIcon(bossEnemy.getAbsolutePath()).getImage();
            //Mages
            wind_mage = new ImageIcon(windMage.getAbsolutePath()).getImage();
            fire_mage = new ImageIcon(fireMage.getAbsolutePath()).getImage();
            earth_mage = new ImageIcon(earthMage.getAbsolutePath()).getImage();
            ice_mage = new ImageIcon(iceMage.getAbsolutePath()).getImage();
            //Mage buttons
            wind_button = ImageIO.read(windButton);
            ice_button = ImageIO.read(iceButton);
            fire_button = ImageIO.read(fireButton);
            earth_button = ImageIO.read(earthButton);
            //UI
            menu_button = ImageIO.read(menu);
            start_button = ImageIO.read(startButton);
            quit_button = ImageIO.read(quitButton);
            pause_button = ImageIO.read(pause);
            unPause_button = ImageIO.read(unPause);
            player_hp = new ImageIcon(playerHP.getAbsolutePath()).getImage();
            gameOver = ImageIO.read(gameOverBg);
            defeat = ImageIO.read(defeatImg);
            backToMenu = ImageIO.read(backMenu);
            vUp_button = ImageIO.read(vUp);
            vDown_button = ImageIO.read(vDown);
            gameVictory = ImageIO.read(gameVictoryBg);
            //Magic spell
            fireBolt = new ImageIcon(fire_Bolt.getAbsolutePath()).getImage();
            rockSpell = new ImageIcon(rock_Spell.getAbsolutePath()).getImage();
            iceBolt = new ImageIcon(ice_Bolt.getAbsolutePath()).getImage();
            windSpell = new ImageIcon(wind_Spell.getAbsolutePath()).getImage();
            //Magic effect
            wind_effect = ImageIO.read(windEffect);
            freeze_effect = ImageIO.read(freezeEffect);
            fire_effect = ImageIO.read(fireEffect);
            //Map
            img = ImageIO.read(is);
            big_Tree = ImageIO.read(bigTree);
            cut_Tree = ImageIO.read(cutTree);
            big_Brush = ImageIO.read(bigBrush);
            farm = ImageIO.read(farmFile);
            ver_brush = ImageIO.read(verBrush);
            hor_brush = ImageIO.read(horBrush);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
