package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.DirectoryFile;
import com.shevelev.manager.view.PanelDisplayDirectory;
import com.shevelev.manager.view.PanelInfoAboutDirectory;
import com.shevelev.manager.view.PanelTree;
import com.shevelev.manager.view.menu.NewFilePanel;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by denis on 16.11.17.
 */
public class TabHomePanelListener implements ActionListener {
    private JFrame frame;
    private JButton button;
    private boolean createdObject;
    private DirectoryFile directoryFile;
    private PanelDisplayDirectory panelDisplayDirectory;
    private PanelInfoAboutDirectory panelInfoAboutDirectory;
    private PanelTree panelTree;

    public TabHomePanelListener(JFrame frame, DirectoryFile directoryFile, PanelDisplayDirectory panelDisplayDirectory, PanelInfoAboutDirectory panelInfoAboutDirectory, PanelTree panelTree){
        this.frame = frame;
        this.directoryFile = directoryFile;
        this.panelDisplayDirectory = panelDisplayDirectory;
        this.panelInfoAboutDirectory = panelInfoAboutDirectory;
        this.panelTree = panelTree;
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

        if (result == JOptionPane.YES_OPTION){
            try{
                File parentFile = directoryFile.getDirectoryFile();

                File newFile = new File(parentFile,newFilePanel.getName().getText());
                if (newFilePanel.getNewTypeDirectory().isSelected()){
                    createdObject = newFile.mkdir();
                }else {
                    createdObject = newFile.createNewFile();
                }
                if (createdObject){
                    DefaultMutableTreeNode parentNode  = new DefaultMutableTreeNode(parentFile);
                    if (newFile.isDirectory()){
                        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newFile);
                        panelTree.getDefaultTreeModel().insertNodeInto(newNode,parentNode, parentNode.getChildCount());
                    }

                    directoryFile.setDirectoryFile(directoryFile.getDirectoryFile());

                    panelDisplayDirectory.getPanelInPanel().removeAll();
                    panelDisplayDirectory.getPanel().removeAll();
                    panelDisplayDirectory.addLabelInPanel();

                    panelInfoAboutDirectory.getPanelInfo().removeAll();
                    panelInfoAboutDirectory.addPanelInfo();

                    frame.repaint();
                    frame.validate();
                }
            }catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}
