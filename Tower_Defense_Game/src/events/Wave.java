/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import java.util.ArrayList;

/**
 *
 * @author sahad
 */
public class Wave {
    private ArrayList<Integer> enemyList = new ArrayList<>();
    public Wave(ArrayList<Integer> enemyList){
        this.enemyList = enemyList;
    }
    
    public ArrayList<Integer> getEnemyList() {
        return enemyList;
    }
    
}
