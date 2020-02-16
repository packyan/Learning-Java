package com.CollectionTest;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) {

        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream("test.properties"));
            String version = properties.getProperty("version");
            String name = properties.getProperty("name");
            System.out.println(name + " " + version);

            properties.setProperty("store","store properties");
            properties.setProperty("save","saved");
            properties.store(new FileOutputStream("test.properties"), "commit");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
