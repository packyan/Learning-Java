package com.Socket_TCP;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TCPServerThread implements Runnable{
    private  Socket s;
    public TCPServerThread(Socket accept) {
        this.s = accept;
    }

    @Override
    public void run() {
        Date d = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd-HH-mm-ss");
        String data_str = simpleDateFormat.format(d);
        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(s.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter("file-MultiThreadTCPServer "
                            + data_str + ".txt")
            )) {
            String str;
            while((str = bufferedReader.readLine()) != null){
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

            //给出反馈
            BufferedWriter bfw = new BufferedWriter(
                    new OutputStreamWriter(s.getOutputStream()));
            System.out.println("a file upload form ip: "+
                    s.getInetAddress() + " port: " + s.getPort());
            bfw.write("文件上传成功！");
            bfw.newLine();
            bfw.flush();
            bfw.close();



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
