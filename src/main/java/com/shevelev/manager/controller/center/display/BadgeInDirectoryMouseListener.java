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

/**
 * In this class, the label listener controller is implemented in central panel.
 * Example switching to directories.
 */
public class BadgeInDirectoryMouseListener extends MouseAdapter {
    private JLabel[] highlightBadge = new JLabel[1];

    private FileToDirectoryModel fileToDirectoryModel;
    private PanelDisplayDirectory panelDisplayDirectory;
    private DisplayUsers displayUsers;
    private BackAndNextModel backAndNextModel;

    /**
     * Constructor
     *
     * @param panelDisplayDirectory - instance of the implementation class of the central panel (PanelDisplayDirectory.java)
     * @param fileToDirectoryModel  - model by files (fileToDirectoryModel.java)
     * @param displayUsers          - head panel (DisplayUsers.java)
     * @param backAndNextModel      - model of travel back and forth (BackAndNextModel.java)
     */
    public BadgeInDirectoryMouseListener(FileToDirectoryModel fileToDirectoryModel, PanelDisplayDirectory panelDisplayDirectory,
                                         DisplayUsers displayUsers, BackAndNextModel backAndNextModel) {
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.panelDisplayDirectory = panelDisplayDirectory;
        this.displayUsers = displayUsers;
        this.backAndNextModel = backAndNextModel;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e is an instance of MouseEvent class
     */
    public void mouseClicked(MouseEvent e) {
        fileToDirectoryModel.setSelectedDirectory(null);

        JLabel badge = (JLabel) e.getSource();
        String badgeName = badge.getText();

        highlightCurrentBadge(badge, highlightBadge);

        if (e.getClickCount() == 1) {
            List<File> fileList = new ArrayList<>(fileToDirectoryModel.getListFilesAndDirectories());
            for (File aFileList : fileList) {
                String fileNameInList = aFileList.getName();
                if (fileNameInList.equals(badgeName)) {
                    fileToDirectoryModel.setSelectedDirectory(aFileList.getAbsoluteFile());
                }
            }
        }

        if (e.getClickCount() == 2) {
            fileToDirectoryModel.setSelectedDirectory(null);
            TreePath currentPath;
            List<File> directoryList = fileToDirectoryModel.getDirectoriesList();
            for (File fileInDirectoryList : directoryList) {
                String directoryNameInList = fileInDirectoryList.getName();
                if (directoryNameInList.equals(badgeName)) {
                    currentPath = panelDisplayDirectory.getPanelTree().getTreePathInJTree(fileInDirectoryList);

                    panelDisplayDirectory.getPanelTree().getTreeDirectory().setSelectionPath(currentPath);
                    panelDisplayDirectory.getPanelTree().getTreeDirectory().expandPath(currentPath);
                    panelDisplayDirectory.getPanelTree().getTreeDirectory().scrollPathToVisible(currentPath);

                    fileToDirectoryModel.setFileToDirectory(fileInDirectoryList);
                }
            }
            backAndNextModel.setPreviousFiles(fileToDirectoryModel.getFileToDirectory());
            displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
        }
    }

    /**
     * Select one file
     *
     * @param badge          - this label(file)
     * @param highlightBadge - array of selected labels(files)
     */
    private void highlightCurrentBadge(JLabel badge, JLabel[] highlightBadge) {
        if (highlightBadge[0] == null) {
            highlightBadge[0] = badge;
            badge.setBorder(BorderFactory.createLineBorder(Color.black));
        } else {
            highlightBadge[0].setBorder(null);
            highlightBadge[0] = badge;
            badge.setBorder(BorderFactory.createLineBorder(Color.black));
        }
    }
}
