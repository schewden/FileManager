package com.shevelev.manager.controller.panel.west.tree;

import com.shevelev.manager.model.BackAndNextModel;
import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelTree;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.io.File;

/**
 * In this class, the create tree listener controller is implemented
 */
public class TreeListener implements TreeSelectionListener {
    private FileToDirectoryModel fileToDirectoryModel;
    private DisplayUsers displayUsers;
    private PanelTree panelTree;
    private BackAndNextModel backAndNextModel;

    /**
     * Constructor
     *
     * @param panelTree            - current JPanel is framed in a frame
     * @param fileToDirectoryModel - model by files (fileToDirectoryModel.java)
     * @param displayUsers         - head panel (DisplayUsers.java)
     * @param backAndNextModel     - model of travel back and forth (BackAndNextModel.java)
     */
    public TreeListener(FileToDirectoryModel fileToDirectoryModel, DisplayUsers displayUsers,
                        PanelTree panelTree, BackAndNextModel backAndNextModel) {
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.displayUsers = displayUsers;
        this.panelTree = panelTree;
        this.backAndNextModel = backAndNextModel;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e is an instance of TreeSelectionEvent class
     */
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        AddNewNode addNewNode = new AddNewNode();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
        TreePath currentNodePath = e.getPath();
        if (panelTree.getTreeDirectory().isExpanded(currentNodePath)) {
            fileToDirectoryModel.setFileToDirectory((File) node.getUserObject());
            backAndNextModel.setPreviousFiles((File) node.getUserObject());
            displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
        } else {
            addNewNode.createChild(node);
            panelTree.getTreeDirectory().expandPath(currentNodePath);
            fileToDirectoryModel.setFileToDirectory((File) node.getUserObject());
            backAndNextModel.setPreviousFiles((File) node.getUserObject());
            displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
        }
    }
}
