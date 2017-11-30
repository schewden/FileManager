package com.shevelev.manager.view;

import com.shevelev.manager.model.FileToDirectoryModel;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * View of the information panel
 */
public class PanelInfoAboutDirectory {
    private final Font FONT = new Font("Times New Roman", Font.BOLD, 12);
    private JPanel panelInfo;
    private FileToDirectoryModel fileToDirectoryModel;

    /**
     * Constructor
     *
     * @param panelInfo            -  current JPanel is framed in a frame
     * @param fileToDirectoryModel - model by files (fileToDirectoryModel.java)
     */
    public PanelInfoAboutDirectory(JPanel panelInfo, FileToDirectoryModel fileToDirectoryModel) {
        this.panelInfo = panelInfo;
        this.fileToDirectoryModel = fileToDirectoryModel;
        panelInfo.setBackground(Color.white);
        panelInfo.setBorder(new EtchedBorder());
        addPanelInfo();
    }

    /**
     * Procedure for update this panel
     */
    public void addPanelInfo() {
        JLabel elements = new JLabel("Элементов:");
        elements.setFont(FONT);
        JLabel countElements = new JLabel();
        countElements.setText(fileToDirectoryModel.getListFilesAndDirectories().size() + "");
        countElements.setFont(FONT);
        panelInfo.add(elements);
        panelInfo.add(countElements);
    }
}
