package com.shevelev.manager.view;

import com.shevelev.manager.controller.center.display.badgeInDirectoryMouseListener;
import com.shevelev.manager.model.BackAndNextModel;
import com.shevelev.manager.model.FileToDirectoryModel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class PanelDisplayDirectory {
    private final String ICON_DIRECTORY = "src/main/resources/images/Folder.png";
    private final String ICON_FILE = "src/main/resources/images/documents32.png";
    private final Dimension DIMENSION_LABEL = new Dimension(106, 32);
    private final Dimension DIMENSION_SCROLL_PANE = new Dimension(580, 390);

    private JPanel panelInPanelCenter;
    private JScrollPane scrollPane;
    private JLabel badgeFile;
    private JPanel panelCenter;

    private FileToDirectoryModel FileToDirectoryModel;
    private DisplayUsers displayUsers;
    private PanelTree panelTree;
    private BackAndNextModel backAndNextModel;
    private badgeInDirectoryMouseListener badgeInDirectoryMouseListener;


    public PanelDisplayDirectory(JPanel panelCenter, FileToDirectoryModel FileToDirectoryModel,
                                 DisplayUsers displayUsers, BackAndNextModel backAndNextModel) {
        this.panelCenter = panelCenter;
        this.FileToDirectoryModel = FileToDirectoryModel;
        this.displayUsers = displayUsers;
        this.backAndNextModel = backAndNextModel;

        panelInPanelCenter = new JPanel();
        panelInPanelCenter.setBackground(Color.WHITE);
        panelInPanelCenter.setPreferredSize(new Dimension(580, 1000));
        panelInPanelCenter.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

        badgeInDirectoryMouseListener = new badgeInDirectoryMouseListener(FileToDirectoryModel, this, displayUsers, backAndNextModel);
        updateCurrentDirectory(FileToDirectoryModel.getListFilesAndDirectories());
    }

    public JPanel getPanelInPanelCenter() {
        return panelInPanelCenter;
    }

    public PanelTree getPanelTree() {
        return panelTree;
    }

    public void setPanelTree(PanelTree panelTree) {
        this.panelTree = panelTree;
    }

    public void updateCurrentDirectory(List<File> currentFiles) {
        List<File> directoryList = new ArrayList<>();
        List<File> fileList = new ArrayList<>();
        for (File currentFile : currentFiles) {
            badgeFile = new JLabel(currentFile.getName());
            if (currentFile.isDirectory()) {
                badgeFile.setIcon(new ImageIcon(ICON_DIRECTORY));
                directoryList.add(currentFile);
                FileToDirectoryModel.setDirectoriesList(directoryList);
            } else {
                fileList.add(currentFile);
                FileToDirectoryModel.setFilesList(fileList);
                badgeFile.setIcon(new ImageIcon(ICON_FILE));
            }
            badgeFile.setToolTipText(badgeFile.getText());
            badgeFile.addMouseListener(badgeInDirectoryMouseListener);
            badgeFile.setPreferredSize(DIMENSION_LABEL);

            panelInPanelCenter.add(badgeFile);
        }
        scrollPane = new JScrollPane(panelInPanelCenter, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(DIMENSION_SCROLL_PANE);
        panelCenter.add(scrollPane);
    }
}
