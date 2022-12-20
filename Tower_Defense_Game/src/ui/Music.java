/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.net.URL;
import java.util.HashSet;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author sahad
 */
public class Music {
    Clip clip;
    URL soundURL[] = new URL[30];
    FloatControl fc;
    float currentVolume;
    public Music(){
        soundURL[0] = getClass().getResource("/sound/SoundBG.wav");
        soundURL[1] = getClass().getResource("/sound/buySound.wav");
        soundURL[2] = getClass().getResource("/sound/gameoverSound.wav");
        soundURL[3] = getClass().getResource("/sound/gamevictorySound.wav");
    }
    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        }catch(Exception e){
        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
    public void volumeDown(){
       currentVolume -=10.0f;
       if(currentVolume < -80.0f){
           currentVolume = -80.0f;
       }
       fc.setValue(currentVolume);
    }
    public void volumeDown(int i){
       currentVolume -=i;
       if(currentVolume < -80.0f){
           currentVolume = -80.0f;
       }
       fc.setValue(currentVolume);
    }
    public void volumeUp(){
        currentVolume +=10.0f;
        if(currentVolume > 6.0f){
            currentVolume = 6.0f;
        }
        fc.setValue(currentVolume);
    }
    public void volumeUp(int i){
        currentVolume +=i;
        if(currentVolume > 6.0f){
            currentVolume = 6.0f;
        }
        fc.setValue(currentVolume);
    }
}
