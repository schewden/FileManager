package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelTree;
import com.shevelev.manager.view.menu.RenamePanel;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * In this class, the rename button listener controller is implemented
 */
public class TabHomeRenameListener implements ActionListener {
    private FileToDirectoryModel fileToDirectoryModel;
    private PanelTree panelTree;
    private DisplayUsers displayUsers;

    /**
     * Constructor
     *
     * @param fileToDirectoryModel - model by files (fileToDirectoryModel.java)
     * @param panelTree            - panel by tree (PanelTree.java)
     * @param displayUsers         - head panel (DisplayUsers.java)
     */
    public TabHomeRenameListener(FileToDirectoryModel fileToDirectoryModel,
                                 PanelTree panelTree, DisplayUsers displayUsers) {
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.panelTree = panelTree;
        this.displayUsers = displayUsers;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e is an instance of ActionEvent class
     */
    public void actionPerformed(ActionEvent e) {
        File currentSelectedFile = fileToDirectoryModel.getSelectedDirectory();
        if (currentSelectedFile != null) {
            RenamePanel renamePanel = new RenamePanel();
            UIManager.put("OptionPane.yesButtonText", "Переименовать");
            UIManager.put("OptionPane.noButtonText", "Отмена");

            int result = JOptionPane.showConfirmDialog(displayUsers.getFrame(),
                    renamePanel.getRenamePanel(),
                    "Переименовать",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                try {
                    if (!renamePanel.getName().getText().equals("")) {
                        File newFile = new File(currentSelectedFile.getParent(), renamePanel.getName().getText());
                        boolean renameObject = currentSelectedFile.renameTo(newFile);
                        if (renameObject) {
                            fileToDirectoryModel.setSelectedDirectory(null);
                            if (newFile.isDirectory()) {
                                TreePath parentPath = panelTree.getTreePathInJTree(currentSelectedFile.getParentFile());
                                DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();

                                TreePath currentPath = panelTree.getTreePathInJTree(currentSelectedFile);
                                DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) currentPath.getLastPathComponent();
                                panelTree.getDefaultTreeModel().removeNodeFromParent(currentNode);
                                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newFile);
                                panelTree.getDefaultTreeModel().insertNodeInto(newNode, parentNode, parentNode.getChildCount());
                                panelTree.getTreeDirectory().expandPath(parentPath);

                                fileToDirectoryModel.setFileToDirectory(fileToDirectoryModel.getFileToDirectory());
                                displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
                            } else {
                                fileToDirectoryModel.setFileToDirectory(fileToDirectoryModel.getFileToDirectory());
                                displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
                            }
                        }
                    } else {
                        String msg = "Вы не ввели имя файла.Пожалуйста,введите имя файла!";
                        ErrorMessage errorMessage = new ErrorMessage(displayUsers.getFrame());
                        errorMessage.errorMessagePane(msg, "Ошибка изменения имени файла");
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        } else {
            String msg = "Вы не выбрали файл.Пожалуйста, выберите файл и повторите действия!";
            ErrorMessage errorMessage = new ErrorMessage(displayUsers.getFrame());
            errorMessage.errorMessagePane(msg, "Ошибка изменения имени файла");
        }
    }
}
