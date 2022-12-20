/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpz;

import java.util.ArrayList;

/**
 *
 * @author sahad
 */
public class Utilz {
    public static int[][] ArrayListTo2D(ArrayList<Integer> list, int ySize, int xSize){
        int[][] newArr = new int[ySize][xSize];
        for(int j=0;j<newArr.length;j++){
            for(int i=0;i<newArr[j].length;i++){
                int index = j*ySize +i;
                newArr[j][i] = list.get(index); 
            }
        }
        return newArr;
    }
    public static int[] TwoDTo1DArr(int[][] twoArr){
        int[] oneArr = new int[twoArr.length * twoArr[0].length];
        for(int j=0;j<twoArr.length;j++){
            for(int i=0;i<twoArr[j].length;i++){
                int index = j*twoArr.length +i;
                oneArr[index] = twoArr[j][i]; 
            }
        }
        return oneArr;
    }
    
    public static int GetHypoDistance(float x1,float y1,float x2,float y2){
        float xDiff = Math.abs(x1 - x2);
        float yDiff = Math.abs(y1 - y2);
        return (int)Math.hypot(xDiff, yDiff);
    }
}
