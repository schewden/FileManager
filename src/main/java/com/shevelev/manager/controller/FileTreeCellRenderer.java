package com.shevelev.manager.controller;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.io.File;

/**
 * Created by denis on 31.10.17.
 */
public class FileTreeCellRenderer extends DefaultTreeCellRenderer {
    private FileSystemView fileSystemView;

    public FileTreeCellRenderer() {
        fileSystemView = FileSystemView.getFileSystemView();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus){
        super.getTreeCellRendererComponent(tree,value,selected,expanded,leaf,row,hasFocus);
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        File file = (File)node.getUserObject();
        setText(fileSystemView.getSystemDisplayName(file));
        setOpenIcon(new ImageIcon("src/main/resources/images/fileopen.png"));
        setClosedIcon(new ImageIcon("src/main/resources/images/filenew.png"));
        setLeafIcon(new ImageIcon("src/main/resources/images/filenew.png"));
        return this;
    }

}
