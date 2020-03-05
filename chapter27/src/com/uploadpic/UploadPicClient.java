package com.uploadpic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 【网络编程(TCP协议-练习)上传图片发送发送到服务端】
 */
public class UploadPicClient {

    public static void main(String[] args) throws IOException {


        // 1.创建客户端socket
        Socket socket = new Socket("192.168.1.102", 8888);
        // 2. 读取客户端要上传的图片文件。
        FileInputStream fis = new FileInputStream("C:\\Users\\licongzhi\\Pictures\\FLAMING MOUNTAIN.JPG");
        // 3. 获取socket输出流，将读到图片数据发送给服务端

        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        // 告诉服务端说：这边的数据发送完毕。让服务端停止读取。
        socket.shutdownOutput();
        // 读取服务端发回的内容
        InputStream inputStream = socket.getInputStream();
        byte[] bufIn = new byte[1024];
        int lenIn = inputStream.read(bufIn);
        String text = new String(bufIn, 0, lenIn);
        System.out.println(text);
        outputStream.close();
        socket.close();

    }
}
