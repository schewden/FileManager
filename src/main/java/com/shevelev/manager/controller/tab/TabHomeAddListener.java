package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelTree;
import com.shevelev.manager.view.menu.NewFilePanel;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * In this class, the create button listener controller is implemented
 */
public class TabHomeAddListener implements ActionListener {
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
    public TabHomeAddListener(FileToDirectoryModel fileToDirectoryModel, PanelTree panelTree, DisplayUsers displayUsers) {
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.panelTree = panelTree;
        this.displayUsers = displayUsers;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e is an instance of ActionEvent class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        NewFilePanel newFilePanel = new NewFilePanel();
        UIManager.put("OptionPane.yesButtonText", "Создать");
        UIManager.put("OptionPane.noButtonText", "Отмена");

        int result = JOptionPane.showConfirmDialog(displayUsers.getFrame(),
                newFilePanel.getNewFilePanel(),
                "Создать папку",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            try {
                if (!newFilePanel.getName().getText().equals("")) {
                    File parentFile = fileToDirectoryModel.getFileToDirectory();
                    File newFile = new File(parentFile, newFilePanel.getName().getText());
                    boolean createdObject;
                    if (newFilePanel.getNewTypeDirectory().isSelected()) {
                        createdObject = newFile.mkdir();
                    } else {
                        createdObject = newFile.createNewFile();
                    }
                    if (createdObject) {
                        if (newFile.isDirectory()) {
                            TreePath treePath = panelTree.getTreePathInJTree(parentFile);
                            DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
                            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newFile);
                            panelTree.getDefaultTreeModel().insertNodeInto(newNode, parentNode, parentNode.getChildCount());
                            panelTree.getTreeDirectory().expandPath(treePath);
                        }
                        fileToDirectoryModel.setFileToDirectory(fileToDirectoryModel.getFileToDirectory());
                        displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
                    }
                } else {
                    String msg = "Вы не ввели имя файла.Пожалуйста,введите имя файла!";
                    ErrorMessage errorMessage = new ErrorMessage(displayUsers.getFrame());
                    errorMessage.errorMessagePane(msg, "Ошибка создания файла");
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}
