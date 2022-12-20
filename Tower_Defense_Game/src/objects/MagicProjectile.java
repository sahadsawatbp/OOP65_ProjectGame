package objects;

import java.awt.geom.Point2D;

/**
 *
 * @author sahad
 */
public class MagicProjectile {
    private Point2D.Float pos;
    private int id,magicType,dmg;
    private float xSpeed,ySpeed;
    private boolean active = true;
    private float rotate;
    private int tier;
    public MagicProjectile(float x, float y,float xSpeed,float ySpeed,int dmg,float rotate ,int id, int magicType,int tier){
       pos = new Point2D.Float(x,y);
       this.xSpeed = xSpeed;
       this.ySpeed = ySpeed;
       this.rotate = rotate;
       this.id = id;
       this.dmg = dmg;
       this.magicType = magicType;
       this.tier = tier;
    }
    public void move(){
        pos.x += xSpeed;
        pos.y += ySpeed;
    }

    public Point2D.Float getPos() {
        return pos;
    }

    public int getId() {
        return id;
    }

    public int getMagicType() {
        return magicType;
    }

    public boolean isActive() {
        return active;
    }

    public void setPos(Point2D.Float pos) {
        this.pos = pos;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getDmg() {
        return dmg;
    }

    public float getRotate() {
        return rotate;
    }

    public int getTier() {
        return tier;
    }
    
   
    
}
