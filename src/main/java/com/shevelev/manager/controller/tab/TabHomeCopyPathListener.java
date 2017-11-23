package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.DirectoryFile;
import com.shevelev.manager.view.PanelTree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by denis on 21.11.17.
 */
public class TabHomeCopyPathListener implements ActionListener {
    private DirectoryFile directoryFile;
    private PanelTree panelTree;

    public TabHomeCopyPathListener(DirectoryFile directoryFile, PanelTree panelTree){
        this.directoryFile = directoryFile;
        this.panelTree = panelTree;
    }
    public void actionPerformed(ActionEvent e) {
        directoryFile.setRepositoryCurrentTreePath(directoryFile.getDirectoryFile().getPath());
        directoryFile.setCutFileDir(false);
    }
}
