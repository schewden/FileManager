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

public class TreeListener  implements TreeSelectionListener {
    private FileToDirectoryModel fileToDirectoryModel;
    private DisplayUsers displayUsers;
    private PanelTree panelTree;
    private BackAndNextModel backAndNextModel;

    public TreeListener(FileToDirectoryModel fileToDirectoryModel, DisplayUsers displayUsers,
                        PanelTree panelTree, BackAndNextModel backAndNextModel){
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.displayUsers = displayUsers;
        this.panelTree = panelTree;
        this.backAndNextModel = backAndNextModel;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        AddNewNode addNewNode = new AddNewNode();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
        TreePath currentNodePath = e.getPath();
        if (panelTree.getTreeDirectory().isExpanded(currentNodePath)){
            fileToDirectoryModel.setFileToDirectory((File)node.getUserObject());
            backAndNextModel.setPreviousFiles((File)node.getUserObject());
            displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
        }else {
            addNewNode.createChild(node);
            panelTree.getTreeDirectory().expandPath(currentNodePath);
            fileToDirectoryModel.setFileToDirectory((File)node.getUserObject());
            backAndNextModel.setPreviousFiles((File)node.getUserObject());
            displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
        }
    }
}
