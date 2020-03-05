package com.uploadpic;

import java.io.*;
import java.net.Socket;

public class UploadTask implements Runnable {

    private Socket accept;

    public UploadTask(Socket accept) {
        this.accept = accept;
    }

    @Override
    public void run() {
        String ip = accept.getInetAddress().getHostAddress();
        System.out.println(ip + "......connected");
        int count = 0;
        FileOutputStream fos = null;
        try {
            // 读取客户端发来的数据。
            InputStream in = accept.getInputStream();
            // 将读取到数据存储到一个文件中
            File dir = new File("C:\\temp");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, ip + ".JPG");
            // 如果文件已经存在与服务端
            if (file.exists()) {
                file = new File(dir, ip + "(" + (++count) + ").JPG");
            }
            fos = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            // 获取socket输出流，将上传成字样发给客户端
            OutputStream out = accept.getOutputStream();
            out.write("上传成功".getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
