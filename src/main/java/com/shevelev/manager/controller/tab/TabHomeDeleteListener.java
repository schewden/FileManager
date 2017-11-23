package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.DirectoryFile;
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
                    TreePath currentPath = panelTree.interactionPanelAndTree(currentSelectedFile);
                    //DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) currentPath.getLastPathComponent();
                    TreePath parentPath = panelTree.interactionPanelAndTree(directoryFile.getDirectoryFile());
                    DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
                    panelTree.removeNodeFromJTree(currentPath,currentNode,panelTree.getDefaultTreeModel());
                    //panelTree.getDefaultTreeModel().removeNodeFromParent(currentNode);
                    directoryFile.setDirectoryFile(directoryFile.getDirectoryFile());

                    displayUsers.repaintGUI();
                } else {
                    directoryFile.setDirectoryFile(directoryFile.getDirectoryFile());
                    displayUsers.repaintGUI();
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
