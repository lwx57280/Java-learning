package com.p2;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端和服务器端原理
 */
public class MyTomcat {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Socket accept = ss.accept();
        System.out.println(accept.getInetAddress().getHostAddress()+ "........connected");
        InputStream in = accept.getInputStream();

        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String text = new String(buf, 0, len);
        System.out.println(text);
        //给客户端一个反馈信息。
        PrintWriter out = new PrintWriter(accept.getOutputStream(),true);

        out.println("<font color='red' size='7'>欢迎光临</font>");
        out.flush();
        accept.close();
        ss.close();
    }
}
