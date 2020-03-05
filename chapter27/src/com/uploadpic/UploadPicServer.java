package com.uploadpic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端多线程技术
 */
public class UploadPicServer {
    public static void main(String[] args) {
        try {
            // 创建tcp的socket服务端
            ServerSocket socket = new ServerSocket(8888);
            while (true) {
                // 获取客户端
                Socket accept = socket.accept();
                new Thread(new UploadTask(accept)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
