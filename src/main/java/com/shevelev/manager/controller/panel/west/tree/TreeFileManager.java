package com.shevelev.manager.controller.panel.west.tree;


import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

/**
 * Created by denis on 21.10.17.
 */
public class TreeFileManager {

    public void createChild(DefaultMutableTreeNode node){
        File currentFile = (File) node.getUserObject();
        File[] files = currentFile.listFiles();
        if (files != null){
            for (File nodeFile : files){
                if (nodeFile.isDirectory()){
                    DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(nodeFile);
                    node.add(childNode);
                }
            }
        }
    }
}
