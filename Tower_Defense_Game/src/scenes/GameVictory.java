/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scenes;

import java.awt.Graphics;
import java.util.Random;
import main.Game;
import static main.GameStates.MENU;
import static main.GameStates.SetGameState;

import ui.Images;
import ui.MyButton;
import ui.MyImage;

/**
 *
 * @author sahad
 */
public class GameVictory extends GameScene implements SceneMethods{
    private Images images;
    private MyImage gameVictoryBg;
    private MyButton bMenu;
    
    public GameVictory(Game game) {
        super(game);
        images = new Images();
        initButtons();
    }
    private void initButtons() {
        int w = 150;
        int x = 640 / 2 - w / 2;
        int y = 250;
        int yOffset = 80;
        gameVictoryBg = new MyImage(images.gameVictory,-20,0,672,800);
        bMenu = new MyButton(images.backToMenu,170,500,300,30);
    }
    @Override
    public void render(Graphics g) {
        gameVictoryBg.draw(g);
        bMenu.draw(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
       if(bMenu.getBounds().contains(x,y)){
           SetGameState(MENU);
           game.getPlaying().reset();
       }
    }

    @Override
    public void mouseMove(int x, int y) {
        bMenu.setMouseOver(false);
        if(bMenu.getBounds().contains(x,y)){
            bMenu.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if(bMenu.getBounds().contains(x,y)){
            bMenu.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        bMenu.setMousePressed(false);
    }

    
    
}
