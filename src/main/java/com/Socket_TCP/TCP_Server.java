package com.Socket_TCP;

import java.io.*;
import java.net.*;

public class TCP_Server {
    public static void main(String[] args) throws IOException {
        //服务器端，建立服务器套接字
        ServerSocket serverSocket = new ServerSocket(7777);
        byte[] buffer = new byte[1024];

        //握手，建立连接。
        try {
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                int len = inputStream.read(buffer);
                System.out.println("get Client Message " + new String(buffer, 0, len));
                System.out.println("From " + accept.getInetAddress() + " " + accept.getPort());
                OutputStream outputStream = accept.getOutputStream();
                outputStream.write("Server Connected".getBytes());

                BufferedReader bfr = new BufferedReader(
                        new InputStreamReader(inputStream));
                BufferedWriter bfw = new BufferedWriter(
                        new FileWriter("file-TCP-upload.txt")
                );
                try{
                    String str;
                    while (( str = bfr.readLine()) != null) {


                           System.out.println(str);
                           //自己设计结束标记不靠谱
                           /*if(str.equals("FileSendFinished"))
                           {
                               System.out.println(accept.getInetAddress() + " " + accept.getPort() + " Upload Finished");
                               outputStream.write("Upload Finished".getBytes());
                               break;
                           }*/
                           bfw.write(str);
                           bfw.newLine();
                           bfw.flush();


                    }
                }
                finally {
                    System.out.println(accept.getInetAddress() + " " + accept.getPort() + " Upload Finished");
                    outputStream.write("Upload Finished".getBytes());

                    bfr.close();
                    bfw.close();
                }

        }
        finally {
            serverSocket.close();
        }





    }
}
