#java学习之路

> finally 子句


      
    不管是否有异常被捕获，finally 子句中的代码都被执行。在下面的示例中，程序将在所有情况下关闭文件。
    
    InputStream in = new InputStream(....);
    try{
        //1
        code that might throw exceptions
        //2
    }catch(IOException e){
        //3
        show error message
        // 4
    }finally{
        // 5
        in.close();
    }
        // 6
    在上面这段代码中，有下列3种情况会执行finally子句：
    1）代码没有抛出异常。在这种情况下，程序首先执行try语句块中的全部代码，然后执行finally子句中的代码。随后，继续执行try语句块之后
    的第一条语句。也就是说，执行标注1 、2、5、6处。
    
    2）抛出一个在catch子句中捕获异常。在上面的示例中IOException异常。在这种情况下，程序
    
    
    
    有时候，finally子句也会带来麻烦，例如，清理资源的方法也有可能抛出异常。假设希望能够确保在流处理代码中遇到异常时将流关闭。
    
    InputStream in =....;
    try{
        code that might throw exceptions
    }finally{
        in.close();
    }
    
    
    
    