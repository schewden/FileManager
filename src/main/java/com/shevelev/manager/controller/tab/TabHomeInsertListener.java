package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.DirectoryFile;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelByDirectory;
import com.shevelev.manager.view.PanelTree;
import org.apache.commons.io.FileUtils;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by denis on 21.11.17.
 */
public class TabHomeInsertListener implements ActionListener {
    private DirectoryFile directoryFile;
    private Object currentTreePath;
    private PanelByDirectory panelByDirectory;
    private PanelTree panelTree;
    private DisplayUsers displayUsers;

    private File destDir;
    private File srcDir;
    private boolean success = false;

    public TabHomeInsertListener(DirectoryFile directoryFile, PanelByDirectory panelByDirectory, PanelTree panelTree, DisplayUsers displayUsers) {
        this.directoryFile = directoryFile;
        this.panelByDirectory = panelByDirectory;
        this.panelTree = panelTree;
        this.displayUsers = displayUsers;
    }

    public void actionPerformed(ActionEvent e) {
        currentTreePath = directoryFile.getRepositoryCurrentTreePath();
        if (currentTreePath instanceof String) {
            String name = currentTreePath.toString();
            panelByDirectory.getAddressBar().setText(name);
        } else {
            try {
                destDir = directoryFile.getDirectoryFile();
                srcDir = (File) currentTreePath;
                if (srcDir.isDirectory()) {
                    String nameSrcDir = srcDir.getName();
                    TreePath srcTreePath = panelTree.interactionPanelAndTree(srcDir);
                    DefaultMutableTreeNode srcParentNode = (DefaultMutableTreeNode) srcTreePath.getParentPath().getLastPathComponent();
                    if (!directoryFile.isCutFileDir()) {
                        FileUtils.copyDirectoryToDirectory(srcDir, destDir);
                        success = true;
                    } else {
                        FileUtils.moveDirectoryToDirectory(srcDir, destDir, true);
                        success = true;
                    }
                    if (success) {
                        File destFile = directoryFile.getDirectoryFile();
                        TreePath destTreePath = panelTree.interactionPanelAndTree(destFile);
                        if (!directoryFile.isCutFileDir()) {
                            DefaultMutableTreeNode parentDest = (DefaultMutableTreeNode) destTreePath.getLastPathComponent();
                            DefaultMutableTreeNode srcNewNode = new DefaultMutableTreeNode(srcDir);
                            panelTree.getDefaultTreeModel().insertNodeInto(srcNewNode, parentDest, parentDest.getChildCount());
                        } else {
                            panelTree.removeNodeFromJTree(srcTreePath, srcParentNode, panelTree.getDefaultTreeModel());
                            panelTree.insertNodeIntoJTree(destTreePath, panelTree.getDefaultTreeModel(), nameSrcDir);
                        }
                        directoryFile.setDirectoryFile(directoryFile.getDirectoryFile());
                        displayUsers.repaintGUI();
                    }
                } else {
                    if (!directoryFile.isCutFileDir()) {
                        FileUtils.copyFileToDirectory(srcDir, destDir);
                        success = true;
                    } else {
                        FileUtils.moveFileToDirectory(srcDir, destDir, true);
                        success = true;
                    }
                    if (success) {
                        directoryFile.setDirectoryFile(directoryFile.getDirectoryFile());
                        displayUsers.repaintGUI();
                    }
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
