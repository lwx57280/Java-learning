package com.blocking;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * 此任务枚举目录和此子目录中的所有文件。
 */
public class FileEnumerationTask implements Runnable {
    public static File DUMMY = new File("");
    private BlockingQueue<File> queue;
    private File startingDirectory;

    public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory) {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }

    @Override
    public void run() {
        try{
            enumerate(startingDirectory);
            queue.put(DUMMY);

        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    /**
     * 递归枚举给定目录及其子目录中的所有文件。
     * @param directory
     * @throws InterruptedException
     */
    private void enumerate(File directory) throws InterruptedException{
        File[] files = directory.listFiles();
        for (File file:files){
            if(file.isDirectory())
                enumerate(file);
            else
                queue.put(file);
        }
    }
}
