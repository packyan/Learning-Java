package com.Socket_TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP_Client {
    public static void main(String[] args) throws IOException {
        //初始化套接字
        Socket tcpSocket = new Socket(InetAddress.getByName("192.168.1.106"), 7777);
        //指定主机，端口

        //建立字节输出流
        OutputStream tcpSocketOutputStream = tcpSocket.getOutputStream();
        byte[] data = "TCP Client Online".getBytes();
        tcpSocketOutputStream.write(data);

        byte[] buffer = new byte[1024];
        InputStream inputStream = tcpSocket.getInputStream();
        int len = inputStream.read(buffer);
        System.out.println("Get message from server : " + new String(buffer,0,len));


        // read a file and send to server:
        FileReader fileReader  = new FileReader("file.txt");
        BufferedReader isr = new BufferedReader(fileReader);

        BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(tcpSocketOutputStream));

        String str;
        while((str = isr.readLine()) != null){

            bwr.write(str);
            bwr.newLine();
            bwr.flush();

        }
        tcpSocket.shutdownOutput();
       /* bwr.write("FileSendFinished");
        bwr.newLine();*/
        bwr.flush();
        inputStream = tcpSocket.getInputStream();

        //阻塞式的读取方法
        len = inputStream.read(buffer);
        System.out.println("Get message from server : " + new String(buffer,0,len));


        tcpSocket.close();
    }
}
