package com.shevelev.manager.view;

import com.shevelev.manager.controller.panel.west.tree.FileTreeCellRenderer;
import com.shevelev.manager.controller.panel.west.tree.TreeListener;
import com.shevelev.manager.model.DirectoryFile;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.io.File;

/**
 * Created by denis on 29.10.17.
 */
public class PanelTree {
    private JTree treeDirectory;
    private JScrollPane scrollPane;
    //private TreeFileManager treeFileManager;
    private File fileRoot;
    private DefaultTreeModel defaultTreeModel;
    private TreeSelectionModel selectionModel;

    public PanelTree(JFrame frame,PanelInfoAboutDirectory panelInfoDir, JPanel panelInfo, PanelDisplayDirectory panelDisplayDirectory, JPanel panel, DirectoryFile pathToDirectory){
        fileRoot = pathToDirectory.getDirectoryFile();


        DefaultMutableTreeNode root = new DefaultMutableTreeNode(fileRoot);
        defaultTreeModel = new DefaultTreeModel(root);
        initialSystemFiles(root);
        treeDirectory = new JTree(defaultTreeModel);

        treeDirectory.setCellRenderer(new FileTreeCellRenderer());
        selectionModel = new DefaultTreeSelectionModel();
        selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        treeDirectory.addTreeSelectionListener(new TreeListener(frame,panelInfoDir,panelInfo,pathToDirectory,panelDisplayDirectory));
        scrollPane = new JScrollPane(treeDirectory);
        scrollPane.setPreferredSize(new Dimension(200,390));

        panel.add(scrollPane);
    }

    private void initialSystemFiles(DefaultMutableTreeNode root){
        File[] files = fileRoot.listFiles();
        if (files != null){
            for (File nodeFile : files){

                if (nodeFile.isDirectory()){
                    DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(nodeFile);
                    root.add(childNode);
                    System.out.println(childNode);
                }
            }
        }
    }

    public DefaultTreeModel getDefaultTreeModel() {
        return defaultTreeModel;
    }

    public JTree getTreeDirectory() {
        return treeDirectory;
    }
}
