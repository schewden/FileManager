package com.shevelev.manager.controller.center.display;

import com.shevelev.manager.model.DirectoryFile;
import com.shevelev.manager.view.PanelDisplayDirectory;
import com.shevelev.manager.view.PanelInfoAboutDirectory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;


public class LabelToDirectoryMouseListener implements MouseListener {
    private JLabel label;
    private DirectoryFile directoryFile;
    private PanelDisplayDirectory panelDisplayDirectory;
    private JPanel panelInfo;
    private PanelInfoAboutDirectory panelInfoDir;
    private JFrame frame;
    private JLabel[] allotmentLabel;

    public LabelToDirectoryMouseListener(DirectoryFile directoryFile, JFrame frame, PanelDisplayDirectory panelDisplayDirectory, JPanel panelInfo,PanelInfoAboutDirectory panelInfoDir) {
        this.directoryFile = directoryFile;
        this.panelDisplayDirectory = panelDisplayDirectory;
        this.frame = frame;
        this.panelInfo=panelInfo;
        this.panelInfoDir = panelInfoDir;
        allotmentLabel = new JLabel[1];
    }

    public void mouseClicked(MouseEvent e) {
        label = (JLabel) e.getSource();
        if (allotmentLabel[0] == null){
            allotmentLabel[0] = label;
            label.setBorder(BorderFactory.createLineBorder(Color.black));
        }else {
            allotmentLabel[0].setBorder(null);
            allotmentLabel[0] = label;
            label.setBorder(BorderFactory.createLineBorder(Color.black));
        }

        if (e.getClickCount() == 2) {
            String directroyName = label.getText();
            List<File> directoryList = directoryFile.getDirectoryList();
                for (int i = 0; i<directoryList.size();i++) {
                    String directoryNameInList = directoryList.get(i).getName();
                    if (directoryNameInList.equals(directroyName)) {
                        directoryFile.setDirectoryFile(directoryList.get(i).getAbsoluteFile());

                        panelDisplayDirectory.getPanelInPanel().removeAll();
                        panelDisplayDirectory.getPanel().removeAll();
                        panelDisplayDirectory.addLabelInPanel();

                        panelInfo.removeAll();
                        panelInfoDir.addPanelInfo();

                        frame.repaint();
                        frame.validate();
                    }
                }
        }

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {


    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
