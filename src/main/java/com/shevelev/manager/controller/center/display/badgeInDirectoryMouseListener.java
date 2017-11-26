package com.shevelev.manager.controller.center.display;

import com.shevelev.manager.model.BackAndNextModel;
import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelDisplayDirectory;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class badgeInDirectoryMouseListener extends MouseAdapter {
    private JLabel[] highlightBadge = new JLabel[1];

    private FileToDirectoryModel FileToDirectoryModel;
    private PanelDisplayDirectory panelDisplayDirectory;
    private DisplayUsers displayUsers;
    private BackAndNextModel backAndNextModel;

    public badgeInDirectoryMouseListener(FileToDirectoryModel FileToDirectoryModel, PanelDisplayDirectory panelDisplayDirectory,
                                         DisplayUsers displayUsers, BackAndNextModel backAndNextModel) {
        this.FileToDirectoryModel = FileToDirectoryModel;
        this.panelDisplayDirectory = panelDisplayDirectory;
        this.displayUsers = displayUsers;
        this.backAndNextModel = backAndNextModel;
    }

    public void mouseClicked(MouseEvent e) {
        FileToDirectoryModel.setSelectedDirectory(null);

        JLabel badge = (JLabel) e.getSource();
        String badgeName = badge.getText();

        highlightCurrentBadge(badge, highlightBadge);

        if (e.getClickCount() == 1) {
           List<File> fileList = new ArrayList<>(FileToDirectoryModel.getDirectoriesList());
            for (int i = 0; i < fileList.size(); i++) {
                String fileNameInList = fileList.get(i).getName();
                if (fileNameInList.equals(badgeName)) {
                    FileToDirectoryModel.setSelectedDirectory(fileList.get(i).getAbsoluteFile());
                }
            }
        }

        if (e.getClickCount() == 2) {
            TreePath currentPath;
            List<File> directoryList = FileToDirectoryModel.getDirectoriesList();
            for (File fileInDirectoryList : directoryList) {
                String directoryNameInList = fileInDirectoryList.getName();
                if (directoryNameInList.equals(badgeName)) {
                    currentPath = panelDisplayDirectory.getPanelTree().getTreePathInJTree(fileInDirectoryList);

                    panelDisplayDirectory.getPanelTree().getTreeDirectory().setSelectionPath(currentPath);
                    panelDisplayDirectory.getPanelTree().getTreeDirectory().expandPath(currentPath);
                    panelDisplayDirectory.getPanelTree().getTreeDirectory().scrollPathToVisible(currentPath);

                    FileToDirectoryModel.setFileToDirectory(fileInDirectoryList);
                }
            }
            backAndNextModel.setPreviousFiles(FileToDirectoryModel.getFileToDirectory());
            displayUsers.repaintGUI(FileToDirectoryModel.getListFilesAndDirectories());
        }
    }

    private void highlightCurrentBadge(JLabel badge, JLabel[] highlightBadge){
        if (highlightBadge[0] == null){
            highlightBadge[0] = badge;
            badge.setBorder(BorderFactory.createLineBorder(Color.black));
        }else {
            highlightBadge[0].setBorder(null);
            highlightBadge[0] = badge;
            badge.setBorder(BorderFactory.createLineBorder(Color.black));
        }
    }
}
