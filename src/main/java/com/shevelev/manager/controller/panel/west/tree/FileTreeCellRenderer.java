package com.shevelev.manager.controller.panel.west.tree;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.io.File;

/**
 * Displays an entry in a tree.
 */
public class FileTreeCellRenderer extends DefaultTreeCellRenderer {
    private final String OPENICON = "src/main/resources/images/fileopen.png";
    private final String CLOSEICON = "src/main/resources/images/filenew.png";
    private final String LEAFCON = "src/main/resources/images/filenew.png";
    private FileSystemView fileSystemView;

    public FileTreeCellRenderer() {
        fileSystemView = FileSystemView.getFileSystemView();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        File file = (File) node.getUserObject();
        setText(fileSystemView.getSystemDisplayName(file));
        setOpenIcon(new ImageIcon(OPENICON));
        setClosedIcon(new ImageIcon(CLOSEICON));
        setLeafIcon(new ImageIcon(LEAFCON));
        return this;
    }

}
