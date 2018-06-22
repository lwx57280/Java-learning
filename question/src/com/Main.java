package com;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 读文件：
 */
public class Main {
    /**
     * D:\\ question.txt  遍历查找统计"－"在文件中出现的次数
     * 1、 明确体系：
     *      源：InputStream ，Reader
     * 2、明确数据：
     *      源：是纯文本吗？是 Reader
     * 3、明确设备：
     *      源：硬盘文件，FileReader。
     *
     * @param args
     */
    public static void main(String[] args) {
        String txtContent = readTxtContent();
        System.out.println("txtContent=:" + txtContent);
        System.out.println("txtContent=:" + txtContent.length());
        if (null != txtContent && txtContent.length() != 0) {

            findText("－", txtContent);
            findText("级", txtContent);
            findText("理1", txtContent);
        }
    }

    /**
     * 统计指定字符出现的次数
     *
     * @param txtContent
     */
    private static void findText(String findTxt, String txtContent) {
        int num = 0;
        String flag = "－";
        // 正则表达式
        Pattern p = Pattern.compile(findTxt);
        // 操作的字符串
        Matcher matcher = p.matcher(txtContent);
        while (matcher.find()) {
            num++;
        }
        if (findTxt.equals(flag)) {
            System.out.println(findTxt + " 一共出现" + num + "次数");
        } else if (findTxt.equals("级")) {
            System.out.println(findTxt + " 一共出现" + num + "次数");
        } else {
            System.out.println(findTxt + " 一共出现" + num + "次数");
        }
    }

    /**
     * 读取文本文件
     *
     * @return
     */
    private static String readTxtContent() {
        // 使用转换流
        InputStreamReader read = null;
        // 缓冲区的缓冲字符输入流
        BufferedReader in = null;
        String fileContent = "";

        try {
            // D:\\user\\question.txt
            // 数据源:硬盘
            File file = new File("D:\\question.txt ");
            if (file.isFile() && file.exists()) {
                // 在读取txt文本文件时如果内容包含中文字符，需要指定编码格式与txt文本文件字符编码格式一致
                // 否则读取到的中文会发生乱码
                // 如果对操作的文本文件需要使用指定编码表进行编/解码操作，这时必须使用转换流来完成。
                read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                in = new BufferedReader(read);
                String line;
                while ((line = in.readLine()) != null) {
                    fileContent += line;
                }
            } else {
                System.out.println("文件不存在!");
            }
        } catch (IOException e) {
            System.out.println("文件读取错误!" + e);
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != read) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fileContent;
    }
}
