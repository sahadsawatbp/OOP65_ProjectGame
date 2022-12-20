/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import static helpz.Constant.Tiles.GRASS_TILE;
import helpz.LoadSave;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import objects.Decoration;
import objects.Tile;
import ui.Images;

/**
 *
 * @author sahad
 */
public class DecorationManager {
    public Decoration GRASS,TREE,cutTree,bigBrush,farm,verBrush,horBrush;
    private BufferedImage atlas,farmImage;
    public Images allImage;
    public ArrayList<Decoration> tiles_decoration = new ArrayList<>();
    public DecorationManager(){
        allImage = new Images();
        createDecoration();
    }
    private void createDecoration(){
        tiles_decoration.add(GRASS = new Decoration(getSprite(8, 1),0));
        tiles_decoration.add(TREE = new Decoration(allImage.big_Tree,0));
        tiles_decoration.add(cutTree = new Decoration(allImage.cut_Tree,0));
        tiles_decoration.add(bigBrush = new Decoration(allImage.big_Brush,0));
        tiles_decoration.add(farm = new Decoration(allImage.farm,0));
        tiles_decoration.add(verBrush = new Decoration(allImage.ver_brush,0));
        tiles_decoration.add(horBrush = new Decoration(allImage.hor_brush,0));
    }
    public boolean isSpriteAnimation(int spriteID){
        return tiles_decoration.get(spriteID).isAnimation();
    }
    public BufferedImage getTree(int id){
        return tiles_decoration.get(id).getSprite();
    }
    public BufferedImage getSprite(int id) {
        return tiles_decoration.get(id).getSprite();
    }
    public BufferedImage getAniSprite(int id,int animationIndex) {
        return tiles_decoration.get(id).getSprite(animationIndex);
    }
    private BufferedImage[] getAniSprites(int xCord, int yCord) {
        BufferedImage[] arr = new BufferedImage[4];
        for(int i=0;i<4;i++){
            arr[i] = getSprite(xCord+i,yCord);
        }
        return arr;
    }
    private BufferedImage getSprite(int xCord, int yCord) {
        return allImage.img.getSubimage(xCord * 32, yCord * 32, 32, 32);
    }
    public Decoration getTile(int id){
        return tiles_decoration.get(id);
    }
}
