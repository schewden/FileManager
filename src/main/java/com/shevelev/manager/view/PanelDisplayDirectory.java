package com.shevelev.manager.view;

import com.shevelev.manager.controller.center.display.LabelToDirectoryMouseListener;
import com.shevelev.manager.model.DirectoryFile;

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
    private final Dimension DIMENSION_LABEL = new Dimension(106,32);

    private JPanel panelInPanelCenter;
    private JScrollPane scrollPane;
    private JLabel labelFile;
    private LabelToDirectoryMouseListener mouseListener;
    private DirectoryFile directoryFile;
    private JPanel panelCenter;
    private PanelTree panelTree;

    public PanelDisplayDirectory(JPanel panelCenter, DirectoryFile directoryFile,DisplayUsers displayUsers){
        this.panelCenter = panelCenter;
        this.directoryFile = directoryFile;

        panelInPanelCenter = new JPanel();
        panelInPanelCenter.setBackground(Color.WHITE);
        panelInPanelCenter.setPreferredSize(new Dimension(580,1000));
        panelInPanelCenter.setLayout(new FlowLayout(FlowLayout.LEADING,5,5));
        mouseListener = new LabelToDirectoryMouseListener(directoryFile, this, displayUsers);

        addLabelInPanel();

    }

    public JPanel getPanelCenter() {
        return panelCenter;
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

    public void addLabelInPanel(){
        List<File> listCurrentFile =  directoryFile.getDirectoryFileList();
        List<File> directoryList = new ArrayList<File>();
        List<File> fileList = new ArrayList<File>();

        for (int i = 0; i<listCurrentFile.size(); i++) {
            labelFile = new JLabel(listCurrentFile.get(i).getName());

            if (listCurrentFile.get(i).isDirectory()) {
                labelFile.setIcon(new ImageIcon(ICON_DIRECTORY));
                directoryList.add(listCurrentFile.get(i));
                directoryFile.setDirectoryList(directoryList);
            } else {
                fileList.add(listCurrentFile.get(i));
                directoryFile.setFileList(fileList);
                labelFile.setIcon(new ImageIcon(ICON_FILE));
            }
            labelFile.setToolTipText(labelFile.getText());
            labelFile.addMouseListener(mouseListener);
            labelFile.setPreferredSize(DIMENSION_LABEL);
            panelInPanelCenter.add(labelFile);
        }

        scrollPane = new JScrollPane(panelInPanelCenter,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(580,390));

        panelCenter.add(scrollPane);
    }
}
