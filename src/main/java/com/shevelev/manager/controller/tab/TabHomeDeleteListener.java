package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.DirectoryFile;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelTree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by denis on 19.11.17.
 */
public class TabHomeDeleteListener implements ActionListener {
    private JFrame frame;
    private DirectoryFile directoryFile;
    private PanelTree panelTree;
    private DisplayUsers displayUsers;

    private File currentSelectedFile;
    private boolean deletedFile;


    public TabHomeDeleteListener(JFrame frame, DirectoryFile directoryFile,
                                 PanelTree panelTree,
                                 DisplayUsers displayUsers) {
        this.frame = frame;
        this.directoryFile = directoryFile;
        this.panelTree = panelTree;
        this.displayUsers = displayUsers;
    }


    public void actionPerformed(ActionEvent e) {
        currentSelectedFile = directoryFile.getSelectedFile();

        deletedFile = deleteDir(currentSelectedFile);
        if (deletedFile){
            TreePath currentPath = panelTree.interactionPanelAndTree(currentSelectedFile);
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) currentPath.getLastPathComponent();

            panelTree.getDefaultTreeModel().removeNodeFromParent(currentNode);

            directoryFile.setDirectoryFile(directoryFile.getDirectoryFile());

            displayUsers.repaintGUI();
        }else {
            directoryFile.setDirectoryFile(directoryFile.getDirectoryFile());
            displayUsers.repaintGUI();
        }

    }

    private boolean deleteDir(File currentSelectedFile){
        if (currentSelectedFile.isDirectory()) {
            List<File> listCurrentSelectedFile = Arrays.asList(currentSelectedFile.listFiles());
            for (File aListCurrentSelectedFile : listCurrentSelectedFile) {
                deleteDir(aListCurrentSelectedFile);
            }
        }else {
            currentSelectedFile.delete();
            return false;
        }
        return currentSelectedFile.delete();
    }


}
