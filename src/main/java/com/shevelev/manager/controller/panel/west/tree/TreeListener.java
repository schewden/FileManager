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
    private FileToDirectoryModel FileToDirectoryModel;
    private DisplayUsers displayUsers;
    private PanelTree panelTree;
    private BackAndNextModel backAndNextModel;

    public TreeListener(FileToDirectoryModel FileToDirectoryModel, DisplayUsers displayUsers,
                        PanelTree panelTree, BackAndNextModel backAndNextModel){
        this.FileToDirectoryModel = FileToDirectoryModel;
        this.displayUsers = displayUsers;
        this.panelTree = panelTree;
        this.backAndNextModel = backAndNextModel;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        AddNewNode addNewNode = new AddNewNode();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
        TreePath currentNodePath = panelTree.getTreePathInJTree((File)node.getUserObject());
        if (panelTree.getTreeDirectory().isExpanded(currentNodePath)){
            FileToDirectoryModel.setFileToDirectory((File)node.getUserObject());
            backAndNextModel.setPreviousFiles((File)node.getUserObject());
            displayUsers.repaintGUI(FileToDirectoryModel.getListFilesAndDirectories());
        }else {
            addNewNode.createChild(node);
            FileToDirectoryModel.setFileToDirectory((File)node.getUserObject());
            backAndNextModel.setPreviousFiles((File)node.getUserObject());
            displayUsers.repaintGUI(FileToDirectoryModel.getListFilesAndDirectories());
        }
    }
}
