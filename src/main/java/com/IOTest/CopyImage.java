package com.IOTest;

import java.io.*;

public class CopyImage {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try{
            fileInputStream = new FileInputStream("image.gif");
            fileOutputStream = new FileOutputStream("image-copy.gif");
            byte[] imageData = new byte[1024];
            int len = 0;
            while((len = fileInputStream.read(imageData)) != -1){
                fileOutputStream.write(imageData,0,len);
            }

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if( fileInputStream != null && fileOutputStream != null){

                try{
                    fileInputStream.close();
                    fileOutputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
