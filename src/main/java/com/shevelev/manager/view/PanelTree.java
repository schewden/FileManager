package com.shevelev.manager.view;

import com.shevelev.manager.controller.panel.west.tree.FileTreeCellRenderer;
import com.shevelev.manager.controller.panel.west.tree.TreeListener;
import com.shevelev.manager.model.DirectoryFile;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.io.File;
import java.util.*;

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

    public void removeNodeFromJTree(TreePath srcTreePath,DefaultMutableTreeNode srcParentNode, DefaultTreeModel defaultTreeModel) {
        DefaultMutableTreeNode srcNode = (DefaultMutableTreeNode) srcTreePath.getLastPathComponent();
        if (!srcNode.equals(srcParentNode)) {
            defaultTreeModel.removeNodeFromParent(srcNode);
            removeNodeFromJTree(srcTreePath.getParentPath(),srcParentNode, defaultTreeModel);
        }
    }

    public void insertNodeIntoJTree(TreePath destTreePath, DefaultTreeModel defaultTreeModel, String nameNewNode){
        DefaultMutableTreeNode destParentNode = (DefaultMutableTreeNode) destTreePath.getLastPathComponent();
        File destCurrentNodeFile = (File) destParentNode.getUserObject();
        java.util.List<File> listFilesInNewNode = Arrays.asList(destCurrentNodeFile.listFiles());
        for (int i = 0; i < listFilesInNewNode.size(); i++) {
            if (listFilesInNewNode.get(i).getName().equals(nameNewNode)) {
                File nF = listFilesInNewNode.get(i);
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nF);
                defaultTreeModel.insertNodeInto(newNode, destParentNode, destParentNode.getChildCount());
            }
        }
    }
}
