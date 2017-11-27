package com.shevelev.manager.view;

import com.shevelev.manager.controller.panel.west.tree.FileTreeCellRenderer;
import com.shevelev.manager.controller.panel.west.tree.TreeListener;
import com.shevelev.manager.controller.tab.ErrorMessage;
import com.shevelev.manager.model.BackAndNextModel;
import com.shevelev.manager.model.FileToDirectoryModel;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;


public class PanelTree {
    private JTree treeDirectory;
    private JScrollPane scrollPane;
    private File fileRoot;
    private DefaultTreeModel defaultTreeModel;
    private TreeSelectionModel selectionModel;
    private DisplayUsers displayUsers;

    public PanelTree(PanelDisplayDirectory panelDisplayDirectory, JPanel panelTree,
                     FileToDirectoryModel fileToDirectoryModel, DisplayUsers displayUsers,
                     BackAndNextModel backAndNextModel) {
        this.displayUsers = displayUsers;

        fileRoot = fileToDirectoryModel.getFileToDirectory();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(fileRoot);
        defaultTreeModel = new DefaultTreeModel(root);

        initialSystemFiles(root);

        treeDirectory = new JTree(defaultTreeModel);

        treeDirectory.setCellRenderer(new FileTreeCellRenderer());

        selectionModel = new DefaultTreeSelectionModel();
        selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        treeDirectory.addTreeSelectionListener(new TreeListener(fileToDirectoryModel, displayUsers, this, backAndNextModel));

        scrollPane = new JScrollPane(treeDirectory);
        scrollPane.setPreferredSize(new Dimension(200, 390));

        panelDisplayDirectory.setPanelTree(this);
        panelTree.add(scrollPane);
    }

    private void initialSystemFiles(DefaultMutableTreeNode root) {
        File[] files = fileRoot.listFiles();
        if (files != null) {
            for (File nodeFile : files) {
                if (nodeFile.isDirectory()) {
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

    public TreePath getTreePathInJTree(File currentFile) {
        for (int i = 0; i < treeDirectory.getRowCount(); i++) {
            TreePath currentTreePath = treeDirectory.getPathForRow(i);
            Object lastObjectInTreePath = currentTreePath.getLastPathComponent();
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) lastObjectInTreePath;
            File nodeFile = (File) node.getUserObject();
            if (nodeFile.equals(currentFile)) {
                return currentTreePath;
            }
        }
        return null;
    }

    public void removeNodeFromJTree(TreePath srcTreePath, DefaultMutableTreeNode srcParentNode, DefaultTreeModel defaultTreeModel) {
        DefaultMutableTreeNode srcNode = (DefaultMutableTreeNode) srcTreePath.getLastPathComponent();
        if (!srcNode.equals(srcParentNode)) {
            defaultTreeModel.removeNodeFromParent(srcNode);
            removeNodeFromJTree(srcTreePath.getParentPath(), srcParentNode, defaultTreeModel);
        }
    }

    public void insertNodeIntoJTree(TreePath destTreePath, DefaultTreeModel defaultTreeModel, String nameNewNode) {
        DefaultMutableTreeNode destParentNode = (DefaultMutableTreeNode) destTreePath.getLastPathComponent();
        File destCurrentNodeFile = (File) destParentNode.getUserObject();
        File[] listDestCurrentNodeFile = destCurrentNodeFile.listFiles();
        if (listDestCurrentNodeFile != null) {
            List<File> listFilesInNewNode = Arrays.asList(listDestCurrentNodeFile);
            for (int i = 0; i < listFilesInNewNode.size(); i++) {
                if (listFilesInNewNode.get(i).getName().equals(nameNewNode)) {
                    File newFile = listFilesInNewNode.get(i);
                    DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newFile);
                    defaultTreeModel.insertNodeInto(newNode, destParentNode, destParentNode.getChildCount());
                }
            }
        }
    }

    public void openCurrentFileInJTree(File currentFile) {
        TreePath treePath = getTreePathInJTree(currentFile);
        treeDirectory.setSelectionPath(treePath);
        treeDirectory.expandPath(treePath);
        treeDirectory.scrollPathToVisible(treePath);
    }

    public void getPathCurrentFileInJTree(File currentFile, List<File> currentListParentFiles) {
        try {
            if (currentFile != null) {
                if (currentFile.isDirectory()) {
                    currentListParentFiles.add(currentFile);
                    getPathCurrentFileInJTree(currentFile.getParentFile(), currentListParentFiles);
                } else {
                    currentFile = currentFile.getParentFile();
                    currentListParentFiles.add(currentFile);
                    getPathCurrentFileInJTree(currentFile.getParentFile(), currentListParentFiles);
                }
            } else {
                File[] currentTreePath = new File[currentListParentFiles.size()];
                for (int i = 0; i < currentTreePath.length; i++) {
                    currentTreePath[i] = currentListParentFiles.get(currentTreePath.length - i - 1);
                    openCurrentFileInJTree(currentTreePath[i]);
                }
            }
        }catch (NullPointerException npe) {
            ErrorMessage errorMessage = new ErrorMessage(displayUsers.getFrame());
            String msg = "Вы ввели некорректный адрес!";
            errorMessage.errorMessagePane(msg, "Ошибка перехода по адресной строке");
        }
    }
}
