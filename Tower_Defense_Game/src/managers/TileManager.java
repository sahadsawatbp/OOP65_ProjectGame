package managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import static helpz.Constant.Tiles.*;
import helpz.LoadSave;
import objects.Tile;
import ui.Images;

public class TileManager {

	public Tile GRASS, WATER, ROAD_LR,ROAD_UD,ROAD_LD,ROAD_LU,ROAD_RD,ROAD_RU,WALL,DOOR,TOWER;
        public Tile TREE,cutTree,bigBrush,farm,verBrush,horBrush;
	private BufferedImage atlas,farmImage;
	public ArrayList<Tile> tiles = new ArrayList<>();
        public Images allImage;
	public TileManager() {
            allImage = new Images();
            createTiles();
	}

	private void createTiles() {
            tiles.add(GRASS = new Tile(getSprite(2, 0),GRASS_TILE));
            tiles.add(WATER = new Tile(getSprite(2, 0), WATER_TILE));
            tiles.add(ROAD_LR = new Tile(getSprite(6, 0), ROAD_TILE));
            tiles.add(ROAD_UD = new Tile(getSprite(7, 0), ROAD_TILE));
            tiles.add(ROAD_LD = new Tile(getSprite(0,0), ROAD_TILE));
            tiles.add(ROAD_LU = new Tile(getSprite(1,0), ROAD_TILE));
            tiles.add(ROAD_RD = new Tile(getSprite(4,0), ROAD_TILE));
            tiles.add(ROAD_RU = new Tile(getSprite(5,0), ROAD_TILE));
            tiles.add(WALL = new Tile(getSprite(8,0), WALL_TILE));
            tiles.add(DOOR = new Tile(getSprite(4,1), DOOR_TILE));
            tiles.add(TOWER = new Tile(getSprite(3,0), TOWER_TILE));
	}
	public BufferedImage getSprite(int id) {
            return tiles.get(id).getSprite();
	}
        public BufferedImage getAniSprite(int id,int animationIndex) {
            return tiles.get(id).getSprite(animationIndex);
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
        public boolean isSpriteAnimation(int spriteID){
            return tiles.get(spriteID).isAnimation();
        }
        public Tile getTile(int id){
            return tiles.get(id);
        }
}
