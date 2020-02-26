package com.Socket_TCP;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServers {
    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(9988);
        while(true){
            try{
                final Socket accept = serverSocket.accept();
                Thread myAcceptThread = new Thread(new ServerThread(accept));
                myAcceptThread.start();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}

class ServerThread implements Runnable{
    private  Socket accept;
    byte[] buffer = new byte[1024];
    public ServerThread(Socket accept) throws IOException {
        this.accept = accept;
    }

    @Override
    public void run() {
        try {
            final InputStream inputStream = accept.getInputStream();
            final BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream("tcpoutput.png"));
            int len = 0;
            while( (len = inputStream.read(buffer)) != -1){
                    fileOutputStream.write(buffer);
                    fileOutputStream.flush();
            }
            fileOutputStream.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }


}