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

    private JPanel panelInPanel;
    private JScrollPane scrollPane;
    private JLabel label;
    private LabelToDirectoryMouseListener mouseListener;
    private DirectoryFile directoryFile;
    private JPanel panel;

    public PanelDisplayDirectory(JFrame frame,PanelInfoAboutDirectory panelInfoDir, JPanel panelInfo, JPanel panelCenter, DirectoryFile directoryFile){
        this.panel = panelCenter;
        this.directoryFile = directoryFile;
        panelInPanel = new JPanel();
        panelInPanel.setBackground(Color.WHITE);
        panelInPanel.setPreferredSize(new Dimension(580,1000));
        panelInPanel.setLayout(new FlowLayout(FlowLayout.LEADING,5,5));
        mouseListener = new LabelToDirectoryMouseListener(directoryFile,frame, this, panelInfo, panelInfoDir);
        setPanel(panelCenter);
        addLabelInPanel();

    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanelInPanel() {
        return panelInPanel;
    }

    private void setPanelInPanel(JPanel panelInPanel) {
        this.panelInPanel = panelInPanel;
    }

    public void addLabelInPanel(){
        List<File> listCurrentFile =  directoryFile.getDirectoryFileList();
        List<File> directoryList = new ArrayList<File>();
        List<File> fileList = new ArrayList<File>();

        for (int i = 0; i<listCurrentFile.size(); i++) {
            label = new JLabel(listCurrentFile.get(i).getName());

            if (listCurrentFile.get(i).isDirectory()) {
                label.setIcon(new ImageIcon(ICON_DIRECTORY));
                directoryList.add(listCurrentFile.get(i));
                directoryFile.setDirectoryList(directoryList);
            } else {
                fileList.add(listCurrentFile.get(i));
                directoryFile.setFileList(fileList);
                label.setIcon(new ImageIcon(ICON_FILE));
            }
            label.setToolTipText(label.getText());
            label.addMouseListener(mouseListener);
            label.setPreferredSize(DIMENSION_LABEL);
            panelInPanel.add(label);
            setPanelInPanel(panelInPanel);
        }

        scrollPane = new JScrollPane(panelInPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(580,390));

        panel.add(scrollPane);
    }
}
