package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.CutModel;
import com.shevelev.manager.model.FileToDirectoryModel;
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
    private FileToDirectoryModel FileToDirectoryModel;
    private Object currentTreePath;
    private PanelByDirectory panelByDirectory;
    private PanelTree panelTree;
    private DisplayUsers displayUsers;
    private CutModel cutModel;

    private File destDir;
    private File srcDir;
    private boolean success = false;

    public TabHomeInsertListener(FileToDirectoryModel FileToDirectoryModel, PanelByDirectory panelByDirectory,
                                 PanelTree panelTree, DisplayUsers displayUsers,
                                 CutModel cutModel) {
        this.FileToDirectoryModel = FileToDirectoryModel;
        this.panelByDirectory = panelByDirectory;
        this.panelTree = panelTree;
        this.displayUsers = displayUsers;
        this.cutModel =cutModel;
    }

    public void actionPerformed(ActionEvent e) {
        currentTreePath = cutModel.getStorageCurrentTreePath();
        if (currentTreePath instanceof String) {
            String name = currentTreePath.toString();
            panelByDirectory.getAddressBar().setText(name);
        } else {
            try {
                destDir = FileToDirectoryModel.getFileToDirectory();
                srcDir = (File) currentTreePath;
                if (srcDir.isDirectory()) {
                    String nameSrcDir = srcDir.getName();
                    TreePath srcTreePath = panelTree.getTreePathInJTree(srcDir);
                    DefaultMutableTreeNode srcParentNode = (DefaultMutableTreeNode) srcTreePath.getParentPath().getLastPathComponent();
                    if (!cutModel.isMarkCutFileOrDir()) {
                        FileUtils.copyDirectoryToDirectory(srcDir, destDir);
                        success = true;
                    } else {
                        FileUtils.moveDirectoryToDirectory(srcDir, destDir, true);
                        success = true;
                    }
                    if (success) {
                        File destFile = FileToDirectoryModel.getFileToDirectory();
                        TreePath destTreePath = panelTree.getTreePathInJTree(destFile);
                        if (!cutModel.isMarkCutFileOrDir()) {
                            DefaultMutableTreeNode parentDest = (DefaultMutableTreeNode) destTreePath.getLastPathComponent();
                            DefaultMutableTreeNode srcNewNode = new DefaultMutableTreeNode(srcDir);
                            panelTree.getDefaultTreeModel().insertNodeInto(srcNewNode, parentDest, parentDest.getChildCount());
                        } else {
                            panelTree.removeNodeFromJTree(srcTreePath, srcParentNode, panelTree.getDefaultTreeModel());
                            panelTree.insertNodeIntoJTree(destTreePath, panelTree.getDefaultTreeModel(), nameSrcDir);
                        }
                        FileToDirectoryModel.setFileToDirectory(FileToDirectoryModel.getFileToDirectory());
                        displayUsers.repaintGUI(FileToDirectoryModel.getListFilesAndDirectories());
                    }
                } else {
                    if (!cutModel.isMarkCutFileOrDir()) {
                        FileUtils.copyFileToDirectory(srcDir, destDir);
                        success = true;
                    } else {
                        FileUtils.moveFileToDirectory(srcDir, destDir, true);
                        success = true;
                    }
                    if (success) {
                        FileToDirectoryModel.setFileToDirectory(FileToDirectoryModel.getFileToDirectory());
                        displayUsers.repaintGUI(FileToDirectoryModel.getListFilesAndDirectories());
                    }
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
