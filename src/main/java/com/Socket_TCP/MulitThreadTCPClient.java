package com.Socket_TCP;

import java.io.*;
import java.net.Socket;

public class MulitThreadTCPClient {
    public static void main(String[] args) throws IOException {

        Socket tcpSocket = new Socket("192.168.1.106",8888);
        OutputStream tcpSocketOutputStream = tcpSocket.getOutputStream();
        // read a file and send to server:
        FileReader fileReader  = new FileReader("file.txt");
        BufferedReader isr = new BufferedReader(fileReader);

        BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(tcpSocketOutputStream));

        String str;
        while((str = isr.readLine())  != null){

            bwr.write(str);
            bwr.newLine();
            bwr.flush();

        }
        tcpSocket.shutdownOutput();
       /* bwr.write("FileSendFinished");
        bwr.newLine();*/
        bwr.flush();

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(tcpSocket.getInputStream())
        );
        String mesg = null;
        mesg = bufferedReader.readLine();
        System.out.println("Get message from server : " + mesg);

    }
}
