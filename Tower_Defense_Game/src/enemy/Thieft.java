/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemy;

import static helpz.Constant.Enemies.THIEFT;
import managers.EnemyManager;

/**
 *
 * @author sahad
 */
public class Thieft extends Enemy{
    public Thieft(float x,float y,EnemyManager eManager){
        super(x,y,THIEFT,eManager);
    }
}
