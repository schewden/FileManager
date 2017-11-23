package com.shevelev.manager.controller.center.display;

import com.shevelev.manager.model.DirectoryFile;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelDisplayDirectory;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LabelToDirectoryMouseListener implements MouseListener {
    private JLabel label;
    private DirectoryFile directoryFile;
    private PanelDisplayDirectory panelDisplayDirectory;
    private DisplayUsers displayUsers;
    private JLabel[] allotmentLabel;

    public LabelToDirectoryMouseListener(DirectoryFile directoryFile, PanelDisplayDirectory panelDisplayDirectory, DisplayUsers displayUsers) {
        this.directoryFile = directoryFile;
        this.panelDisplayDirectory = panelDisplayDirectory;
        this.displayUsers = displayUsers;
        allotmentLabel = new JLabel[1];
    }

    public void mouseClicked(MouseEvent e) {
        directoryFile.setSelectedFile(null);
        label = (JLabel) e.getSource();
        String labelFileName = label.getText();
        if (allotmentLabel[0] == null){
            allotmentLabel[0] = label;
            label.setBorder(BorderFactory.createLineBorder(Color.black));
        }else {
            allotmentLabel[0].setBorder(null);
            allotmentLabel[0] = label;
            label.setBorder(BorderFactory.createLineBorder(Color.black));
        }
        if (e.getClickCount() == 1) {
            List<File> fileList = Arrays.asList(directoryFile.getDirectoryFile().listFiles());
            for (int i = 0; i < fileList.size(); i++) {
                String fileNameInList = fileList.get(i).getName();
                if (fileNameInList.equals(labelFileName)) {
                    directoryFile.setSelectedFile(fileList.get(i).getAbsoluteFile());
                }
            }
        }

        if (e.getClickCount() == 2) {
            TreePath currentPath;
            List<File> directoryList = new ArrayList<File>();
            directoryList.addAll(directoryFile.getDirectoryList());
                for (int i = 0; i<directoryList.size();i++) {
                    String directoryNameInList = directoryList.get(i).getName();
                    if (directoryNameInList.equals(labelFileName)) {
                        currentPath = panelDisplayDirectory.getPanelTree().interactionPanelAndTree(directoryList.get(i).getAbsoluteFile());
                        panelDisplayDirectory.getPanelTree().getTreeDirectory().setSelectionPath(currentPath);
                        panelDisplayDirectory.getPanelTree().getTreeDirectory().expandPath(currentPath);
                        panelDisplayDirectory.getPanelTree().getTreeDirectory().scrollPathToVisible(currentPath);

                        directoryFile.setDirectoryFile(directoryList.get(i).getAbsoluteFile());
                        displayUsers.repaintGUI();
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
