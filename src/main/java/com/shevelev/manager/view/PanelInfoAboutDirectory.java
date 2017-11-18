package com.shevelev.manager.view;

import com.shevelev.manager.model.DirectoryFile;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Created by denis on 29.10.17.
 */
public class PanelInfoAboutDirectory {
    private final Font FONT =  new Font("Times New Roman", Font.BOLD, 12);

    private JLabel elements;
    private JLabel countElements;
    private JPanel panelInfo;
    private DirectoryFile directoryFile;

    public PanelInfoAboutDirectory(JPanel panelInfo, DirectoryFile directoryFile){
        this.panelInfo = panelInfo;
        panelInfo.setBorder(new EtchedBorder());
        this.directoryFile = directoryFile;
        addPanelInfo();
    }

    public JPanel getPanelInfo() {
        return panelInfo;
    }

    public void addPanelInfo(){
        elements = new JLabel("Элементов:");
        elements.setFont(FONT);

        countElements = new JLabel();
        countElements.setText(directoryFile.getDirectoryFileList().size() + "");
        countElements.setFont(FONT);

        panelInfo.add(elements);
        panelInfo.add(countElements);
    }
}