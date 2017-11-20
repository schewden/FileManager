package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.DirectoryFile;
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
 * Created by denis on 20.11.17.
 */
public class TabHomeRenameListener implements ActionListener {

    private JFrame frame;
    private DirectoryFile directoryFile;
    private PanelTree panelTree;
    private DisplayUsers displayUsers;

    private boolean renameObject;
    private File currentSelectedFile;

    public TabHomeRenameListener(JFrame frame, DirectoryFile directoryFile,
                                 PanelTree panelTree,
                                 DisplayUsers displayUsers) {
        this.frame = frame;
        this.directoryFile = directoryFile;
        this.panelTree = panelTree;
        this.displayUsers = displayUsers;
    }

    public void actionPerformed(ActionEvent e) {
        currentSelectedFile = directoryFile.getSelectedFile();

        RenamePanel renamePanel = new RenamePanel();
        UIManager.put("OptionPane.yesButtonText", "Переименовать");
        UIManager.put("OptionPane.noButtonText", "Отмена");

        int result = JOptionPane.showConfirmDialog(frame,
                renamePanel.getRenamePanel(),
                "Переименовать",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION){
            try{
                File newFile = new File(currentSelectedFile.getParent(),renamePanel.getName().getText());
                renameObject = currentSelectedFile.renameTo(newFile);
                if (renameObject){
                    if (newFile.isDirectory()){
                        TreePath parentPath = panelTree.interactionPanelAndTree(currentSelectedFile.getParentFile());
                        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();

                        TreePath currentPath = panelTree.interactionPanelAndTree(currentSelectedFile);
                        DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) currentPath.getLastPathComponent();

                        panelTree.getDefaultTreeModel().removeNodeFromParent(currentNode);

                        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newFile);
                        panelTree.getDefaultTreeModel().insertNodeInto(newNode,parentNode,parentNode.getChildCount());

                        directoryFile.setDirectoryFile(directoryFile.getDirectoryFile());
                        displayUsers.repaintGUI();
                    }else {
                        directoryFile.setDirectoryFile(directoryFile.getDirectoryFile());
                        displayUsers.repaintGUI();
                    }
                }
            }catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}
