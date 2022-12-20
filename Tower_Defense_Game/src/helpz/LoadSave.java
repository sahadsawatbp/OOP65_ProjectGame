package helpz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class LoadSave {
    public static BufferedImage getSpriteAtlas() {
        BufferedImage img = null;
	InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("res/map.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
	}
        return img;
    }
    
    public static void CreateFile(){
        File txtFile = new File("testTextFile.txt");
        try{
            txtFile.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void CreateLevel(String name,int[] idArr){
        File newLevel = new File(name + ".txt");
        if(newLevel.exists()){
            System.out.println("File: "+name+" already exists");
            return;
        }else{
            try{
                newLevel.createNewFile();
                
            }catch(IOException e){
                e.printStackTrace();
            }
            WriteFile(newLevel, idArr);
        }
    }
    private static void WriteFile(File f,int[] idArr){
        try(PrintWriter pw = new PrintWriter(f);){
            for(Integer i : idArr){
                pw.println(i);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
    }
    public static void SaveLevel(String name,int[][] idArr){
        File levelFile = new File(name + ".txt");
        if(levelFile.exists()){
            WriteFile(levelFile, Utilz.TwoDTo1DArr(idArr));
        }else{
            System.out.println("File: "+name+" doesn't exists");
            return;
        }
    }
    private static ArrayList<Integer> ReadFile(File file){
        ArrayList<Integer> list = new ArrayList<>();
        try(Scanner sc = new Scanner(file);){
            while(sc.hasNextLine()){
                list.add(Integer.parseInt(sc.nextLine()));
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }
    public static int[][] GetLevelData(String name){
        File lvlFile = new File(name + ".txt");
        if(lvlFile.exists()){
            ArrayList<Integer> list = ReadFile(lvlFile);
            return Utilz.ArrayListTo2D(list, 20, 20);
        }else{
            System.out.println("File: "+name+" doesn't exists");
            return null;
        }
        
    }
    
}
