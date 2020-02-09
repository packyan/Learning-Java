package com.ExceptionTest;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
    功能： 异常测试
 */
public class DemoTest {
    public static void main(String[] args) throws IOException {

        try {
            BufferedReader bfr = new BufferedReader(new FileReader("file.txt"));
        }
        catch (IOException e){
            System.out.println(" 你文件呢？？？");
            e.printStackTrace();
        }
        finally {
            System.out.println("Finished file open");
        }
        ListDir("./src", "");
        try{
            getDate("2020-09-13");
        }
        catch (ParseException e){
            e.printStackTrace();
        }
    }


    /*
    自定义 异常
     */


    /*
    通过 throws 抛出异常 而不处理。
     */
    public static void getDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.parse(date));
    }
    public static void  ListDir(String dir, String head) throws IOException{
        try{
            File floder = new File(dir);
            System.out.println(head + floder.getName() + '/');
            File[] filelists = floder.listFiles();
            for(File file : filelists){
                if(file.isFile())
                    System.out.println(head + "\t" + file.getName());
                else
                    ListDir(file.getAbsolutePath(), head+"\t");
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
