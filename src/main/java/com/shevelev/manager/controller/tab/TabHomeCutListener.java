package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.DirectoryFile;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by denis on 22.11.17.
 */
public class TabHomeCutListener implements ActionListener {
    private DirectoryFile directoryFile;
    private File currentSelectedFile;
    private PanelTree panelTree;
    private DisplayUsers displayUsers;

    public TabHomeCutListener(DirectoryFile directoryFile, PanelTree panelTree, DisplayUsers displayUsers) {
        this.directoryFile = directoryFile;
        this.panelTree = panelTree;
        this.displayUsers = displayUsers;
    }
    public void actionPerformed(ActionEvent e) {
            File srcDir = directoryFile.getSelectedFile();
            if (srcDir.isDirectory()) {
                directoryFile.setCutFileDir(true);
                directoryFile.setRepositoryCurrentTreePath(srcDir);
            } else {
                directoryFile.setCutFileDir(true);
                directoryFile.setRepositoryCurrentTreePath(srcDir);
            }
        }
}
