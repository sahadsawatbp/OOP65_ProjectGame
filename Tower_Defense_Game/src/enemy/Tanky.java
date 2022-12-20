/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemy;

import static helpz.Constant.Enemies.TANKY;
import managers.EnemyManager;

/**
 *
 * @author sahad
 */
public class Tanky extends Enemy{
    public Tanky(float x,float y,EnemyManager eManager){
        super(x,y,TANKY,eManager);
        
    }
}
