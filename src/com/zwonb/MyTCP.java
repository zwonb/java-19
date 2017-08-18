package com.zwonb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zyb on 2017/8/18.
 */
public class MyTCP {

    private BufferedReader reader;
    private ServerSocket serverSocket;
    private Socket socket;

    void getServer() {
        try {
            serverSocket = new ServerSocket(8998);
            System.out.println("服务器套接字已经创建成功");
            while (true) {
                System.out.println("登录客户机的连接");
                socket = serverSocket.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                getClientMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getClientMessage() {
        try {
            while (true) {
                System.out.println("客户机："+reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (reader != null) {
                reader.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        MyTCP myTCP = new MyTCP();
        myTCP.getServer();
    }
}
