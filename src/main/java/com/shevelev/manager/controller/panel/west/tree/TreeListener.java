package com.shevelev.manager.controller.panel.west.tree;

import com.shevelev.manager.model.DirectoryFile;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelDisplayDirectory;
import com.shevelev.manager.view.PanelTree;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.io.File;

/**
 * Created by denis on 04.11.17.
 */
public class TreeListener  implements TreeSelectionListener {
    private DirectoryFile directoryFile;
    private PanelDisplayDirectory panelDisplayDirectory;
    private TreeFileManager treeFileManager;
    private DisplayUsers displayUsers;
    private PanelTree panelTree;

    public TreeListener(DirectoryFile directoryFile, PanelDisplayDirectory panelDisplayDirectory, DisplayUsers displayUsers, PanelTree panelTree){
        this.directoryFile = directoryFile;
        this.panelDisplayDirectory = panelDisplayDirectory;
        this.displayUsers = displayUsers;
        this.panelTree = panelTree;
    }

    public void valueChanged(TreeSelectionEvent e) {
        treeFileManager = new TreeFileManager();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
        TreePath currentNodePath = panelTree.interactionPanelAndTree((File)node.getUserObject());
        if (panelTree.getTreeDirectory().isExpanded(currentNodePath)){
            directoryFile.setDirectoryFile((File)node.getUserObject());
            //directoryFile.setRepositoryCurrentTreePath(node.getUserObject());
            displayUsers.repaintGUI();
        }else {
            treeFileManager.createChild(node);
            directoryFile.setDirectoryFile((File)node.getUserObject());
            //directoryFile.setRepositoryCurrentTreePath(node.getUserObject());
            displayUsers.repaintGUI();
        }
    }
}
