package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelTree;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by denis on 19.11.17.
 */
public class TabHomeDeleteListener implements ActionListener {
    private JFrame frame;
    private FileToDirectoryModel FileToDirectoryModel;
    private PanelTree panelTree;
    private DisplayUsers displayUsers;

    private File currentSelectedFile;
    private boolean deletedFile;


    public TabHomeDeleteListener(JFrame frame, FileToDirectoryModel FileToDirectoryModel,
                                 PanelTree panelTree,
                                 DisplayUsers displayUsers) {
        this.frame = frame;
        this.FileToDirectoryModel = FileToDirectoryModel;
        this.panelTree = panelTree;
        this.displayUsers = displayUsers;
    }


    public void actionPerformed(ActionEvent e) {
        currentSelectedFile = FileToDirectoryModel.getSelectedDirectory();
        if (currentSelectedFile != null) {
            try {
                if (currentSelectedFile.isDirectory()) {
                    FileUtils.deleteDirectory(currentSelectedFile);
                    deletedFile = true;
                } else {
                    FileUtils.deleteQuietly(currentSelectedFile);
                    deletedFile = false;
                }
                if (deletedFile) {
                    TreePath currentPath = panelTree.getTreePathInJTree(currentSelectedFile);
                    //DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) currentPath.getLastPathComponent();
                    TreePath parentPath = panelTree.getTreePathInJTree(FileToDirectoryModel.getFileToDirectory());
                    DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
                    panelTree.removeNodeFromJTree(currentPath,currentNode,panelTree.getDefaultTreeModel());
                    //panelTree.getDefaultTreeModel().removeNodeFromParent(currentNode);
                    FileToDirectoryModel.setFileToDirectory(FileToDirectoryModel.getFileToDirectory());

                    displayUsers.repaintGUI(FileToDirectoryModel.getListFilesAndDirectories());
                } else {
                    FileToDirectoryModel.setFileToDirectory(FileToDirectoryModel.getFileToDirectory());
                    displayUsers.repaintGUI(FileToDirectoryModel.getListFilesAndDirectories());
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            String msg = "Вы не выбрали файл.Пожалуйста, выберите файл и повторите действия!";
            ErrorMessage errorMessage = new ErrorMessage(frame);
            errorMessage.errorMessagePane(msg, "Ошибка удаления файла");
        }

    }
}
