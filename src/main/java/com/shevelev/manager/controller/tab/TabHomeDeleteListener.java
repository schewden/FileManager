package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelTree;
import org.apache.commons.io.FileUtils;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * In this class, the delete button listener controller is implemented
 */
public class TabHomeDeleteListener implements ActionListener {
    private FileToDirectoryModel fileToDirectoryModel;
    private PanelTree panelTree;
    private DisplayUsers displayUsers;


    /**
     *Constructor
     *
     * @param fileToDirectoryModel - model by files (fileToDirectoryModel.java)
     * @param panelTree            - panel by tree (PanelTree.java)
     * @param displayUsers         - head panel (DisplayUsers.java)
     */
    public TabHomeDeleteListener(FileToDirectoryModel fileToDirectoryModel,
                                 PanelTree panelTree, DisplayUsers displayUsers) {
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.panelTree = panelTree;
        this.displayUsers = displayUsers;
    }


    /**
     *Invoked when an action occurs.
     *
     * @param e is an instance of ActionEvent class
     */
    public void actionPerformed(ActionEvent e) {
        File currentSelectedFile = fileToDirectoryModel.getSelectedDirectory();
        if (currentSelectedFile != null) {
            try {
                boolean deletedFile;
                if (currentSelectedFile.isDirectory()) {
                    FileUtils.deleteDirectory(currentSelectedFile);
                    deletedFile = true;
                } else {
                    FileUtils.deleteQuietly(currentSelectedFile);
                    deletedFile = false;
                }
                if (deletedFile) {
                    fileToDirectoryModel.setSelectedDirectory(null);
                    TreePath currentPath = panelTree.getTreePathInJTree(currentSelectedFile);
                    TreePath parentPath = panelTree.getTreePathInJTree(fileToDirectoryModel.getFileToDirectory());
                    DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
                    panelTree.removeNodeFromJTree(currentPath,currentNode,panelTree.getDefaultTreeModel());

                    fileToDirectoryModel.setFileToDirectory(fileToDirectoryModel.getFileToDirectory());
                    displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
                } else {
                    fileToDirectoryModel.setSelectedDirectory(null);
                    fileToDirectoryModel.setFileToDirectory(fileToDirectoryModel.getFileToDirectory());
                    displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            String msg = "Вы не выбрали файл.Пожалуйста, выберите файл и повторите действия!";
            ErrorMessage errorMessage = new ErrorMessage(displayUsers.getFrame());
            errorMessage.errorMessagePane(msg, "Ошибка удаления файла");
        }

    }
}
