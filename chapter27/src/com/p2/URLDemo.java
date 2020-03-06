package com.p2;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * URL & URLConnection
 */
public class URLDemo {
    public static void main(String[] args) throws IOException {
        String str_url = "http://192.168.1.102:8089/html/index.html?name=lisi";
        URL url = new URL(str_url);
//        System.out.println("getProtocol:" + url.getProtocol());
//        System.out.println("getHost:" + url.getHost());
//        System.out.println("getPort:" + url.getPort());
//        System.out.println("getFile:" + url.getFile());
//        System.out.println("getPath:" + url.getPath());
//        System.out.println("getQuery:" + url.getQuery());
        // 获取url对象的URL连接器对象：java中内置的可以解析的具体协议对象+socket
        URLConnection conn = url.openConnection();
        System.out.println(conn);
        String value = conn.getHeaderField("Content-Type");
        System.out.println(value);
        System.out.println("===============================");
        InputStream in = conn.getInputStream();
//        InputStream in = url.openStream();
//
//
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String data = new String(buf, 0, len);
        System.out.println(data);

        in.close();
    }

}
