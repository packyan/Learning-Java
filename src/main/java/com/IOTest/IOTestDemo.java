package com.IOTest;

import java.io.*;

public class IOTestDemo {
    public static void main(String[] args) {
        /*
            遍历文件夹内所有文件
         */
        // ListFiles("./src", "");

        /*
            把数据写入文件
         */

        //字节流
        File filePath = new File("IOtest");
        if(!filePath.exists())
            filePath.mkdir();
        File filePath2Save = new File(filePath, "file.txt");
        try{
            filePath2Save.createNewFile();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(filePath2Save.getAbsolutePath());
        OutputStream outputStream = null;
        try{
            // 追加写入
            outputStream =  new FileOutputStream(filePath2Save, true);
            outputStream.write(97);
            outputStream.write('9');
            outputStream.write('7');
            outputStream.write(new byte[]{123,123,98,12,97,98,99});
            outputStream.write(new byte[]{123,123,98,12,97,98,99},2,3);
            for(int i = 0; i < 10; ++i){
                outputStream.write("Hello".getBytes());
                outputStream.write("\n".getBytes());
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //outputStream 没办法获取局部变量
            if (outputStream != null)
                try{
                    outputStream.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }


        }


    }
    public static void ListFiles(String Path, String head){
        File currFile = new File(Path);
        File[] files = currFile.listFiles();
        System.out.println(head + currFile.getName());
        for(var file : files){
            if(file.isFile()){
                System.out.println(head + "\t" + file.getAbsolutePath());
            }
            else
                ListFiles(file.getAbsolutePath(), head + "\t");
        }

    }
}


