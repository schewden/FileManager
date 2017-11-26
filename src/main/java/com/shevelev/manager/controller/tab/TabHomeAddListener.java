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
 * Created by denis on 16.11.17.
 */
public class TabHomeAddListener implements ActionListener {
    private boolean createdObject;
    private JFrame frame;
    private FileToDirectoryModel FileToDirectoryModel;
    private PanelTree panelTree;
    private DisplayUsers displayUsers;

    public TabHomeAddListener(JFrame frame, FileToDirectoryModel FileToDirectoryModel, PanelTree panelTree, DisplayUsers displayUsers) {
        this.frame = frame;
        this.FileToDirectoryModel = FileToDirectoryModel;
        this.panelTree = panelTree;
        this.displayUsers = displayUsers;
    }

    public void actionPerformed(ActionEvent e) {
        NewFilePanel newFilePanel = new NewFilePanel();
        UIManager.put("OptionPane.yesButtonText", "Создать");
        UIManager.put("OptionPane.noButtonText", "Отмена");

        int result = JOptionPane.showConfirmDialog(frame,
                newFilePanel.getNewFilePanel(),
                "Создать папку",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            try {
                if (!newFilePanel.getName().getText().equals("")) {
                    File parentFile = FileToDirectoryModel.getFileToDirectory();
                    File newFile = new File(parentFile, newFilePanel.getName().getText());
                    if (newFilePanel.getNewTypeDirectory().isSelected()) {
                        createdObject = newFile.mkdir();
                    } else {
                        createdObject = newFile.createNewFile();
                    }
                    if (createdObject) {
                        FileToDirectoryModel.setFileToDirectory(FileToDirectoryModel.getFileToDirectory());
                        TreePath treePath = panelTree.getTreePathInJTree(parentFile);
                        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
                        if (newFile.isDirectory()) {
                            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newFile);
                            panelTree.getDefaultTreeModel().insertNodeInto(newNode, parentNode, parentNode.getChildCount());
                            panelTree.getTreeDirectory().expandPath(treePath);

                        }

                        displayUsers.repaintGUI(FileToDirectoryModel.getListFilesAndDirectories());
                    }
                } else {
                    String msg = "Вы не ввели имя файла.Пожалуйста,введите имя файла!";
                    ErrorMessage errorMessage = new ErrorMessage(frame);
                    errorMessage.errorMessagePane(msg, "Ошибка создания файла");
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}
