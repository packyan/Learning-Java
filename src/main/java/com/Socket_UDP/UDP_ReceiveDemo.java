package com.Socket_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP_ReceiveDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(6666);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(
                bytes, bytes.length
        );
        //阻塞
        while(true) {
            datagramSocket.receive(datagramPacket);
            String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(str);
            if(str.equals("886"))
                break;

        }

        datagramSocket.close();
    }
}
