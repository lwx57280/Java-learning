package com.logging;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 显示图像的框架
 */
public class ImageViewerFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;

    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;

    private static Logger logger = Logger.getLogger("com.horstmann.corejava");


    public ImageViewerFrame() throws HeadlessException {


        logger.entering("ImageViewerFrame", "<init>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // 设置菜单栏
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());
        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                logger.fine("Exiting");
                System.exit(0);
            }
        });
        // 使用标签来显示图像
        label = new JLabel();
        add(label);
        logger.entering("ImageViewerFrame", "<init>");

    }

    private class FileOpenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", e);
            // 设置文件选择器
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));
            // 接受所有以.gif结尾的文件

            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF Images";
                }
            });

            // 显示文件选择器对话框
            int r = chooser.showOpenDialog(ImageViewerFrame.this);

            // 如果接受图像文件，将其设置为标签的图标

            if(r==JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE,"Reading file{0}",name);
                label.setIcon(new ImageIcon(name));
            }else {
                logger.fine("File open dialog canceled");
                logger.exiting("ImageViewerFrame.FileOpenListener","actionPerFormed");
            }
        }
    }
}
