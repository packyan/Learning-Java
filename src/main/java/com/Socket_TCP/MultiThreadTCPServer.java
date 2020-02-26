package com.Socket_TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadTCPServer {
    public static void main(String[] args) throws IOException {
        //服务器指定端口即可
        ServerSocket serverSocket = new ServerSocket(8888);
        while(true)
        {
            Socket accept = serverSocket.accept();

            new Thread(new TCPServerThread(accept)).start();
        }

    }
}
