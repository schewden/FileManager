package com.shevelev.manager.controller;


import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.FileFilter;

/**
 * Created by denis on 21.10.17.
 */
public class TreeFileManager {

    public void createChild(File fileRoot, DefaultMutableTreeNode node){
        File[] files = fileRoot.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return !pathname.isHidden();
            }
        });
        if (files != null){
            for (File nodeFile : files){

                if (nodeFile.isDirectory()){
                    DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(nodeFile);
                    node.add(childNode);
                    System.out.println(childNode);
                    createChild(nodeFile,childNode);
                }
            }
        }
    }
}
