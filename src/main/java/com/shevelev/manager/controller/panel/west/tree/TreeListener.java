package com.shevelev.manager.controller.panel.west.tree;

import com.shevelev.manager.model.DirectoryFile;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelDisplayDirectory;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

/**
 * Created by denis on 04.11.17.
 */
public class TreeListener  implements TreeSelectionListener {
    private DirectoryFile directoryFile;
    private PanelDisplayDirectory panelDisplayDirectory;
    private TreeFileManager treeFileManager;
    private DisplayUsers displayUsers;

    public TreeListener(DirectoryFile directoryFile, PanelDisplayDirectory panelDisplayDirectory, DisplayUsers displayUsers){
        this.directoryFile = directoryFile;
        this.panelDisplayDirectory = panelDisplayDirectory;
        this.displayUsers = displayUsers;
    }

    public void valueChanged(TreeSelectionEvent e) {
        treeFileManager = new TreeFileManager();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
        treeFileManager.createChild(node);
        directoryFile.setDirectoryFile((File)node.getUserObject());

        displayUsers.repaintGUI();
    }
}
