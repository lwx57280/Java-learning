package com.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer {
    public static void main(String[] args) {
        try {
            // 创建tcp的socket服务端
            ServerSocket socket = new ServerSocket(8888);
            // 获取客户端
            Socket accept = socket.accept();
            String ip = accept.getInetAddress().getHostAddress();
            System.out.println(ip+"......connected");
            // 读取客户端发来的数据。
            InputStream in = accept.getInputStream();
            // 将读取到数据存储到一个文件中
            File dir = new File("C:\\temp");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, ip + ".JPG");
            FileOutputStream fos = new FileOutputStream(file);

            byte[] buf = new byte[1024];
            int len =0;
            while ((len = in.read(buf)) != -1) {
                fos.write(buf,0,len);
            }
            // 获取socket输出流，将上传成字样发给客户端
            OutputStream out = accept.getOutputStream();
            out.write("上传成功".getBytes());
            fos.close();
            accept.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
