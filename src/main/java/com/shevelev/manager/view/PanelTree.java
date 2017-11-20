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
    private File fileRoot;
    private DefaultTreeModel defaultTreeModel;
    private TreeSelectionModel selectionModel;

    public PanelTree(PanelDisplayDirectory panelDisplayDirectory, JPanel panelTree, DirectoryFile directoryFile,DisplayUsers displayUsers){
        fileRoot = directoryFile.getDirectoryFile();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(fileRoot);
        defaultTreeModel = new DefaultTreeModel(root);
        initialSystemFiles(root);
        treeDirectory = new JTree(defaultTreeModel);

        treeDirectory.setCellRenderer(new FileTreeCellRenderer());
        selectionModel = new DefaultTreeSelectionModel();
        selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        treeDirectory.addTreeSelectionListener(new TreeListener(directoryFile,panelDisplayDirectory,displayUsers,this));
        scrollPane = new JScrollPane(treeDirectory);
        scrollPane.setPreferredSize(new Dimension(200,390));

        panelDisplayDirectory.setPanelTree(this);
        panelTree.add(scrollPane);
        System.out.println(treeDirectory.getRowCount());
    }

    public void initialSystemFiles(DefaultMutableTreeNode root){
        File[] files = fileRoot.listFiles();
        if (files != null){
            for (File nodeFile : files){
                if (nodeFile.isDirectory()){
                    root.add(new DefaultMutableTreeNode(nodeFile));
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

        public TreePath interactionPanelAndTree(File currentFile){
        for (int i = 0; i<treeDirectory.getRowCount(); i++){
            TreePath currentTreePath = treeDirectory.getPathForRow(i);
            Object lastObjectInTreePath = currentTreePath.getLastPathComponent();
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) lastObjectInTreePath;
            File nodeFile = (File) node.getUserObject();
            if (nodeFile.equals(currentFile)){
                return currentTreePath;
            }
        }
        return null;
    }
}
