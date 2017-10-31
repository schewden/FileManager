package com.shevelev.manager.view;

import com.shevelev.manager.controller.FileTreeCellRenderer;
import com.shevelev.manager.controller.TreeFileManager;
import com.shevelev.manager.model.FileInDirectory;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;

/**
 * Created by denis on 29.10.17.
 */
public class PanelTree {
    private JTree treeDirectory;
    private JScrollPane scrollPane;
    private FileInDirectory fileInDirectory;
    private TreeFileManager treeFileManager;
    private File fileRoot;
    private DefaultTreeModel defaultTreeModel;

    public PanelTree(JPanel panel){
        treeFileManager = new TreeFileManager();
        fileRoot = new File("/home/denis/eclipse");
        fileInDirectory = new FileInDirectory();
        fileInDirectory.setFile(fileRoot);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(fileRoot);
        treeFileManager = new TreeFileManager();
        treeFileManager.createChild(fileInDirectory.getFile(),root);
        defaultTreeModel = new DefaultTreeModel(root);
        treeDirectory = new JTree(defaultTreeModel);
        treeDirectory.setCellRenderer(new FileTreeCellRenderer());
        scrollPane = new JScrollPane(treeDirectory);
        Dimension preferredSize = scrollPane.getPreferredSize();
        Dimension widePreferred = new Dimension(200, (int)preferredSize.getHeight());
        scrollPane.setPreferredSize(widePreferred);

        panel.add(scrollPane);
    }
}
