IO流概述
--------

IO流转换流的字符编码
--------------------
	
	(1)字符流的出现为了方便操作字符，更重要的是加入了编码转换
	
	(2)通过子类转换流来完成
		InputStreamReander
		OutputStreamWriter
		
	(3)在两个子类对象进行构造的时候可以加入编码表
	
	(4)编码表：
		将各个国家的文字用二进制数字表示并一一对应，形成一张表，这就是编码表
	
	(5)常见的编码表：
		**ASCII：美国标准信息交换码，用一个字节的七位表示
		**ISO8859-1：拉丁码表，欧洲码表，用一个字节的八位表示
		**GB2312：中文编码表，用两个字节表示
		**GBK：中文编码表升级，融合录入更多的中文字符，用两个字节表示，为避免和老美重复
		       两字节的最高位都是1，即汉字都是用负数表示
		**Unicode：国际标准码，融合了多种文字，所有文字都用两个字节表示
		**UTF-8：用一个字节到三个字节表示。
		注：Unicode能识别中文，UTF-8也能识别中文，但两种编码表示一个汉字所用的字节数不同
		Unicode用两个字节，UTF-8用三个字节，故涉及到编码转换。
	
	(6)在流中涉及编码表的转换只有转换流：
		InputStreamReander
		OutputStreamWriter
		
    (7)代码示例：
            public static void write() throws IOException
            {
                OutputStreamWriter osw1 = new OutputStreamWriter(new FileOutputStream("gbk.txt"),"GBK");
                osw1.write("你好");
                osw1.close();
    
                OutputStreamWriter osw2 = new OutputStreamWriter(new FileOutputStream("utf-8.txt"),"UTF-8");
                osw2.write("你好");
                osw2.close();
            }
            public static void read() throws IOException
            {
                InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk.txt"),"GBK");
                byte[] buf = new byte[1024];
                int len = isr.read(buf);
                sop(new String(buf,0,len));
            }
        
        (8)编码解码
            编码：字符串变成字节数组：String-->getBytes()-->byte[]()
            解码：字节数组变成字符串：byte[]-->new String(byte[],0,len)-->String
        
        (9)代码示例：
            public static void main(String[] args)
            {
                //编码解码1：默认编码
                String str1 = "你好";
                byte[] buf1 = str1.getBytes();//默认解码：Unicode，四个字节
    
                //编码解码2：指定编码
                String str2 = "你好";
                byte[] buf2 = str2.getBytes("UTF-8");//指定解码：UTF-8,六个字节
    
                
                //编码解码3：编码正确解码错误
                String str3 = "你好";
                byte[] buf3 = str3.getBytes("GBK");//指定编码：GBK,四个字节
                String str3 = new String(buf3,"ISO8859-1");//错误解码
    
                //编码解码4：错误编码正确解码
                String str4 = "你好";
                byte[] buf4 = str4.getBytes("ISO8859-1");//错误编码
                String str4 = new String(buf4,"GBK");//正确解码，读不出来
    
                //编码解码5：编码对了，但是解码错误了，怎么办呢？
                //此时可以将错误的解码再错编回去，载用正确编码解码
                String str5 = "你好";
                byte[] buf5 = str5.getBytes("GBK");//正确编码
                String str6 = new String(buf5,"ISO8859-1");//错误解码，读不出来
                byte[] buf6 = str6.getBytes("ISO8859-1");//再错误编码
                String str7 = new String(buf6,"GBK");//再正确解码，这样就可以读出来了
            }
        
IO流的操作规律总结：
-------------------
       
        1，明确体系：
        	数据源：InputStream ，Reader
        	数据汇：OutputStream，Writer
        	
        2，明确数据：因为数据分两种：字节，字符。
        	数据源：是否是纯文本数据呢？
        		是：Reader
        		否：InputStream
        		
        	数据汇：
        		是：Writer
        		否：OutputStream
        到这里就可以明确具体要使用哪一个体系了。
        剩下的就是要明确使用这个体系中的哪个对象。
        
        3，明确设备：
        
        	数据源：
        		键盘：System.in
        		硬盘：FileXXX
        		内存：数组。
        		网络：socket  socket.getInputStream();
        	
        	数据汇：
        		控制台：System.out
        		硬盘：FileXXX
        		内存：数组
        		网络：socket socket.getOutputStream();
        		
        4，明确额外功能：
        	1，需要转换？是，使用转换流。InputStreamReader OutputStreamWriter
        	2，需要高效？是，使用缓冲区。Buffered
        	3，需要其他？
