package com.p2;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 模拟一个浏览器获取信息
 */
public class MyBrowser {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.1.102", 8089);
        // 模拟浏览器，给tomcat服务端发送符合http协议的请求信息
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        out.println("GET /html/index.html HTTP/1.1");
        out.println("Accept: */*");
        out.println("Host:192.168.1.102:8089");
        out.println("Connection:close");
        out.println();
        out.println();

        InputStream in = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String data = new String(buf, 0, len);
        System.out.println(data);
        socket.close();
        // http://192.168.1.102:8089/html/index.html
    }
}
