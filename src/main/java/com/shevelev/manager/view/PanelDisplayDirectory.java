package com.shevelev.manager.view;

import com.shevelev.manager.controller.center.display.BadgeInDirectoryMouseListener;
import com.shevelev.manager.model.BackAndNextModel;
import com.shevelev.manager.model.FileToDirectoryModel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * View of the center panel
 */
public class PanelDisplayDirectory {
    private final String ICON_DIRECTORY = "src/main/resources/images/Folder.png";
    private final String ICON_FILE = "src/main/resources/images/documents32.png";
    private final Dimension DIMENSION_LABEL = new Dimension(106, 32);
    private final Dimension DIMENSION_SCROLL_PANE = new Dimension(580, 382);

    private JPanel panelInPanelCenter;
    private JPanel panelCenter;

    private FileToDirectoryModel fileToDirectoryModel;
    private PanelTree panelTree;
    private BadgeInDirectoryMouseListener badgeInDirectoryMouseListener;

    /**
     * Constructor
     *
     * @param panelCenter          -  current JPanel is framed in a frame
     * @param fileToDirectoryModel - model by files (fileToDirectoryModel.java)
     * @param displayUsers         - head panel (DisplayUsers.java)
     * @param backAndNextModel     - model of travel back and forth (BackAndNextModel.java)
     */
    public PanelDisplayDirectory(JPanel panelCenter, FileToDirectoryModel fileToDirectoryModel,
                                 DisplayUsers displayUsers, BackAndNextModel backAndNextModel) {

        this.panelCenter = panelCenter;
        this.fileToDirectoryModel = fileToDirectoryModel;

        panelInPanelCenter = new JPanel();
        panelInPanelCenter.setBackground(Color.WHITE);
        panelInPanelCenter.setPreferredSize(new Dimension(580, 1000));
        panelInPanelCenter.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

        badgeInDirectoryMouseListener = new BadgeInDirectoryMouseListener(fileToDirectoryModel, this, displayUsers, backAndNextModel);
        updateCurrentDirectory(fileToDirectoryModel.getListFilesAndDirectories());
    }

    /**
     * Function of obtaining the this panel in JScrollPane
     *
     * @return this JPanel(panelInPanelCenter)
     */
    public JPanel getPanelInPanelCenter() {
        return panelInPanelCenter;
    }

    /**
     * Function of obtaining the class PanelTree(PanelTree.java)
     *
     * @return instance PanelTree
     */
    public PanelTree getPanelTree() {
        return panelTree;
    }

    /**
     * Function set instance PanelTree
     *
     * @param panelTree - instance PanelTree
     */
    public void setPanelTree(PanelTree panelTree) {
        this.panelTree = panelTree;
    }

    /**
     * Procedure add JLabel in panelCenter
     *
     * @param currentFiles - list files in current directory
     */
    public void updateCurrentDirectory(List<File> currentFiles) {
        List<File> directoryList = new ArrayList<>();
        List<File> fileList = new ArrayList<>();
        for (File currentFile : currentFiles) {
            JLabel badgeFile = new JLabel(currentFile.getName());
            if (currentFile.isDirectory()) {
                badgeFile.setIcon(new ImageIcon(ICON_DIRECTORY));
                directoryList.add(currentFile);
                fileToDirectoryModel.setDirectoriesList(directoryList);
            } else {
                fileList.add(currentFile);
                fileToDirectoryModel.setFilesList(fileList);
                badgeFile.setIcon(new ImageIcon(ICON_FILE));
            }
            badgeFile.setToolTipText(badgeFile.getText());
            badgeFile.addMouseListener(badgeInDirectoryMouseListener);
            badgeFile.setPreferredSize(DIMENSION_LABEL);

            panelInPanelCenter.add(badgeFile);
        }
        JScrollPane scrollPane = new JScrollPane(panelInPanelCenter, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(DIMENSION_SCROLL_PANE);
        panelCenter.add(scrollPane);
    }
}
