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

/**
 * View of the tree panel
 */
public class PanelTree {
    private final Dimension DIMENSION_SCROLL_PANE = new Dimension(200, 382);

    private JTree treeDirectory;
    private File fileRoot;
    private DefaultTreeModel defaultTreeModel;
    private DisplayUsers displayUsers;

    /**
     * Constructor
     *
     * @param panelDisplayDirectory - instance of the implementation class of the central panel (PanelDisplayDirectory.java)
     * @param panelTree             - current JPanel is framed in a frame
     * @param fileToDirectoryModel  - model by files (fileToDirectoryModel.java)
     * @param displayUsers          - head panel (DisplayUsers.java)
     * @param backAndNextModel      - model of travel back and forth (BackAndNextModel.java)
     */
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

        TreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
        selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        treeDirectory.addTreeSelectionListener(new TreeListener(fileToDirectoryModel, displayUsers, this, backAndNextModel));

        JScrollPane scrollPane = new JScrollPane(treeDirectory);
        scrollPane.setPreferredSize(DIMENSION_SCROLL_PANE);

        panelDisplayDirectory.setPanelTree(this);
        panelTree.add(scrollPane);
    }

    /**
     * Procedure for adding initial system directories
     *
     * @param root - root system
     */
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

    /**
     * Function of obtaining the this DefaultTreeModel
     *
     * @return this defaultTreeModel
     */
    public DefaultTreeModel getDefaultTreeModel() {
        return defaultTreeModel;
    }

    /**
     * Function of obtaining the this JTree
     *
     * @return this JTree(treeDirectory)
     */
    public JTree getTreeDirectory() {
        return treeDirectory;
    }

    /**
     * Procedure for obtaining the TreePath from the current file(search in tree for the required TreePath)
     *
     * @param currentFile - current file
     * @return if this node(currentFileNode) is Expanded, then  return current TreePath, else null
     */
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

    /**
     * This procedure remove node from current JTree
     *
     * @param srcTreePath      - source tree path
     * @param srcParentNode    - source parent
     * @param defaultTreeModel - this DefaultTreeModel
     */
    public void removeNodeFromJTree(TreePath srcTreePath, DefaultMutableTreeNode srcParentNode, DefaultTreeModel defaultTreeModel) {
        DefaultMutableTreeNode srcNode = (DefaultMutableTreeNode) srcTreePath.getLastPathComponent();
        if (!srcNode.equals(srcParentNode)) {
            defaultTreeModel.removeNodeFromParent(srcNode);
            removeNodeFromJTree(srcTreePath.getParentPath(), srcParentNode, defaultTreeModel);
        }
    }

    /**
     * This procedure add node from current JTree
     *
     * @param destTreePath     - destination new file in directory (destination TreePath)
     * @param defaultTreeModel - this DefaultTreeModel
     * @param nameNewNode      - name new node
     */
    public void insertNodeIntoJTree(TreePath destTreePath, DefaultTreeModel defaultTreeModel, String nameNewNode) {
        DefaultMutableTreeNode destParentNode = (DefaultMutableTreeNode) destTreePath.getLastPathComponent();
        File destCurrentNodeFile = (File) destParentNode.getUserObject();
        File[] listDestCurrentNodeFile = destCurrentNodeFile.listFiles();
        if (listDestCurrentNodeFile != null) {
            List<File> listFilesInNewNode = Arrays.asList(listDestCurrentNodeFile);
            for (File currentFileInList : listFilesInNewNode) {
                if (currentFileInList.getName().equals(nameNewNode)) {
                    DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(currentFileInList);
                    defaultTreeModel.insertNodeInto(newNode, destParentNode, destParentNode.getChildCount());
                }
            }
        }
    }

    /**
     * This procedure opening in the tree of the node by the given file
     *
     * @param currentFile - current file
     */
    public void openCurrentFileInJTree(File currentFile) {
        TreePath treePath = getTreePathInJTree(currentFile);
        treeDirectory.setSelectionPath(treePath);
        treeDirectory.expandPath(treePath);
        treeDirectory.scrollPathToVisible(treePath);
    }

    /**
     * The procedure is used to open the required node in the address bar.
     *
     * @param currentFile            - current file
     * @param currentListParentFiles - list for get path by current file
     */
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
        } catch (NullPointerException npe) {
            ErrorMessage errorMessage = new ErrorMessage(displayUsers.getFrame());
            String msg = "Вы ввели некорректный адрес!";
            errorMessage.errorMessagePane(msg, "Ошибка перехода по адресной строке");
        }
    }
}
