package com.IOTest;

import java.io.*;

public class BufferedStreamTest {
    public static void main(String[] args) throws IOException {

        // 需要一个普通的输入输出流作为 缓冲输入输出流的 输入参数

        //DEFAULT_BUFFER_SIZE = 8192 默认buffer 的大小
        copyFileBytes("image.gif","image-byte.gif");
        copyFileBytesArray("image.gif","image-bytesArray.gif");
        copyFileBufferedBytes("image.gif","image-Buffered-byte.gif");
        copyFileBufferedBytesArray("image.gif","image-Buffered-byteArray.gif");


    }
    public static void copyFileBytes(String src, String dst) throws IOException {
        InputStream inputStream = new FileInputStream(src);
        OutputStream outputStream = new FileOutputStream(dst);
        /*
            4 ways to copy a file
            1 基本字节流读写一个字节
            记录时间
         */
        long start = System.currentTimeMillis();
        int b;
        while((b =  inputStream.read()) != -1){
            outputStream.write(b);
        }
        long end  = System.currentTimeMillis();
        System.out.println("Comsuming " + (end - start) + " ms");
        inputStream.close();
        outputStream.close();
    }

    public static void copyFileBytesArray(String src, String dst) throws IOException {
        InputStream inputStream = new FileInputStream(src);
        OutputStream outputStream = new FileOutputStream(dst);
        /*
            4 ways to copy a file
            1 基本字节流读写一个字节
            记录时间
         */
        long start = System.currentTimeMillis();
        byte[] b = new byte[8192];
        int len = 0;
        while((len = inputStream.read(b)) != -1){
            outputStream.write(b,0,len);
        }
        long end  = System.currentTimeMillis();
        System.out.println("Comsuming " + (end - start) + " ms");
        inputStream.close();
        outputStream.close();
    }

    public static void copyFileBufferedBytes(String src, String dst) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream(src));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream(dst));

        int b;
        /*
            4 ways to copy a file
            3 缓冲读写一个字节
            记录时间

         */
        long start = System.currentTimeMillis();
        while((b = bufferedInputStream.read()) != -1){
            bufferedOutputStream.write(b);
        }
        long end  = System.currentTimeMillis();
        System.out.println("Comsuming " + (end - start) + " ms");
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    public static void copyFileBufferedBytesArray(String src, String dst) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream(src));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream(dst));

        byte[] bytes = new byte[8192];
        int len = 0;
        /*

            4 缓冲读写字节数组
            记录时间
         */
        long start = System.currentTimeMillis();
        while((len = bufferedInputStream.read(bytes)) != -1){
            bufferedOutputStream.write(bytes,0,len);
            //System.out.println("write " + len + " bytes");
            //bufferedOutputStream.flush();
        }
        long end  = System.currentTimeMillis();
        System.out.println("Comsuming " + (end - start) + " ms");
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

}
