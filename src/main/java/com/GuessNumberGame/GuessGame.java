package com.GuessNumberGame;

import java.io.*;
import java.util.Properties;

public class GuessGame {
    private static String path = "src\\com\\GuessNumberGame\\GameCounter.txt";
    public static void main(String[] args) {
        int count = loadCounter(path);
        if(count < 3){
            System.out.println("PLAY gaming");
            count++;
            store(count,path);
        }
        else{
            System.out.println("请充值");
        }

    }
    public static int loadCounter(String PropertisPath){
        int counter = 0;
        Properties ppr = new Properties();
        try(FileReader fr = new FileReader(PropertisPath);){

            ppr.load(fr);

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        counter =Integer.parseInt(ppr.getProperty("count"));
        return counter;

    }

    public static void store(int count,String path){
        Properties ppr = new Properties();
        ppr.setProperty("count",Integer.toString(count));
        try(FileWriter fileWriter = new FileWriter(path);){
            ppr.store(fileWriter,"save Count");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

}
