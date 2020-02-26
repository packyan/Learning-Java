package com.Socket_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Scanner;

public class UDP_SendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress ip = Inet4Address.getByName("192.168.1.106");
        //构造 datagramSocket
        String sendStr = "厉害了，hello666";
        byte[] sendata = sendStr.getBytes();
        int datalength = sendata.length;
        for (int i = 0; i < 5; i++) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            byte[] strBytes = str.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(strBytes,strBytes.length,
                    ip,6666);

            datagramSocket.send(datagramPacket);
        }

        datagramSocket.close();
    }
}
