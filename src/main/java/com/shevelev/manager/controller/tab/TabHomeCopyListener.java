package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.DirectoryFile;
import com.shevelev.manager.view.PanelTree;

import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by denis on 22.11.17.
 */
public class TabHomeCopyListener implements ActionListener{
    private File currentSelectedFile;
    private TreePath currentTreePath;
    private DirectoryFile directoryFile;
    private PanelTree panelTree;

    public TabHomeCopyListener(DirectoryFile directoryFile, PanelTree panelTree){
        this.directoryFile = directoryFile;
        this.panelTree = panelTree;

    }
    public void actionPerformed(ActionEvent e) {
        currentSelectedFile = directoryFile.getSelectedFile();
        if (currentSelectedFile != null){
            directoryFile.setRepositoryCurrentTreePath(currentSelectedFile);
            directoryFile.setCutFileDir(false);
        }
    }
}
