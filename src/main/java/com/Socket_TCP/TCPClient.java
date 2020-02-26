package com.Socket_TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args)  {

        try(final BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("test.png"));
            final Socket socket = new Socket("127.0.0.1",9988);
            final OutputStream outputStream = socket.getOutputStream();
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);){
            int len = 0;
            byte[] buffer = new byte[1024];
            while((len = bufferedInputStream.read(buffer))!=-1){
                bufferedOutputStream.write(buffer);
                bufferedOutputStream.flush();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
