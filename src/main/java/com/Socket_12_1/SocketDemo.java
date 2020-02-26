package com.Socket_12_1;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SocketDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress[] inetAddresses = Inet4Address.getAllByName("DESKTOP-DKBAG7H");
        // 可能会返回ipv4 和ipv6地址 所以是一个数组

        for(var iad : inetAddresses){
            System.out.println(iad);
            System.out.println(iad.getAddress());
            System.out.println(iad.getHostName());
            System.out.println(iad.getHostAddress());
            System.out.println(iad.getCanonicalHostName());
        }
        System.out.println();

    }
}
