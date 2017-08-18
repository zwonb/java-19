package com.zwonb;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zyb on 2017/8/18.
 */
public class Address {

    public static void main(String[] args) {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost(); //实例化对象
            System.out.println("本机名" + ip.getHostName());
            System.out.println("本地IP地址" + ip.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
