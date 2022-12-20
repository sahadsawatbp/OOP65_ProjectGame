/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import enemy.Enemy;
import events.Wave;
import static helpz.Constant.Enemies.BOSS;
import java.util.ArrayList;
import java.util.Arrays;
import scenes.Playing;

/**
 *
 * @author sahad
 */
public class WaveManager {
    private ArrayList<Wave> waves = new ArrayList<>();
    private Playing playing;
    private int spawnTickLimit = 30 * 2;
    private int spawnTick = spawnTickLimit;
    private int waveTickLimit = 60 * 10;
    private int waveTick =0;
    private int enemyIndex,waveIndex;
    private boolean waveStartTimer ;
    private boolean waveTimerOver ;
    public WaveManager(Playing playing){
        this.playing = playing;
        createWaves();
    }
    public void update(){
        if(spawnTick < spawnTickLimit){
            spawnTick++;
        }
        if(waveStartTimer){
            waveTick++;
            if(waveTick >= waveTickLimit){
                waveTimerOver = true;
                getGoldPerWave(15);
            }
        }
    }
    public void incraseWaveIndex(){
        waveIndex++;
        waveTick =0;
        waveTimerOver = false;
        waveStartTimer = false;
    }
     public boolean isWaveTimerOver() {
        return waveTimerOver;
    }
    public int getNextEnemy(){
        spawnTick = 0;
        return waves.get(waveIndex).getEnemyList().get(enemyIndex++);
    }
    public ArrayList<Wave> getWaves() {
        return waves;
    }

    private void createWaves() {
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0)))); //1
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,2,0,2,0,2,2)))); //2
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,2,0,2,0,2,0,2,0,2,0,2)))); //3
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,2,0,2,0,2,0,2,0,2,0,2,1,1,1,1,1,1,1,1,1,1)))); //4
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,2,0,2,0,2,0,2,0,2,0,2,0,1,2,1,2,1,1,1,1,1,1,1,1)))); //5
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2)))); //6
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,2,2,2,2,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2)))); //7
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,BOSS,2,2,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0)))); //8
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0)))); //9
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(BOSS,1,1,1,0,0,0,0,0,0,1,1,1,BOSS,0,0,0,0,0,0,0,0,0,0,1,1,1,BOSS)))); //10
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(BOSS,BOSS,BOSS,1,1,1,1,1,1,1,1,BOSS,BOSS,BOSS,2,2,2,2,2,2,2,2,2,2))));
    }
    public boolean isTimeForNewEnemies() {
        return spawnTick >= spawnTickLimit;
    }
    public boolean isThereMoreEnemyInWave(){
        return enemyIndex < waves.get(waveIndex).getEnemyList().size();
    }

    public boolean isThereMoreWaves() {
        return waveIndex <= waves.size();
    }

    public void startTimer() {
        waveStartTimer =  true;
    }

    public void resetEnemyIndex() {
        enemyIndex = 0;
    }
    public int getWaveIndex(){
        return waveIndex;
    }
    public float getTimeLeft(){
        float timeLeft = waveTickLimit - waveTick;
        return timeLeft / 60.0f;
    }

    public boolean isWaveTimerStarted() {
        return this.waveStartTimer;
    }
    public boolean isWaveIndexDivideByTwo(){
        return (waveIndex+1) % 2 == 0;
    }
    public void getGoldPerWave(int amount){
        playing.getGameBar().giveGold(amount);
    }

    public void reset() {
        waves.clear();
        createWaves();
        waveIndex=0;
        enemyIndex=0;
        waveStartTimer=false;
        waveTimerOver=false;
        waveTick=0;
        spawnTick = spawnTickLimit;
    }
    

    

   
   
}
