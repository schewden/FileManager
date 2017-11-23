package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.DirectoryFile;
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
    private DirectoryFile directoryFile;
    private PanelTree panelTree;
    private DisplayUsers displayUsers;

    public TabHomeAddListener(JFrame frame, DirectoryFile directoryFile, PanelTree panelTree, DisplayUsers displayUsers) {
        this.frame = frame;
        this.directoryFile = directoryFile;
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
                    File parentFile = directoryFile.getDirectoryFile();
                    File newFile = new File(parentFile, newFilePanel.getName().getText());
                    if (newFilePanel.getNewTypeDirectory().isSelected()) {
                        createdObject = newFile.mkdir();
                    } else {
                        createdObject = newFile.createNewFile();
                    }
                    if (createdObject) {
                        TreePath treePath = panelTree.interactionPanelAndTree(parentFile);
                        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
                        if (newFile.isDirectory()) {
                            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newFile);

                            panelTree.getDefaultTreeModel().insertNodeInto(newNode, parentNode, parentNode.getChildCount());
                        }

                        directoryFile.setDirectoryFile(directoryFile.getDirectoryFile());

                        displayUsers.repaintGUI();
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
