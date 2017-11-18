package com.shevelev.manager.controller.panel.west.tree;

import com.shevelev.manager.model.DirectoryFile;
import com.shevelev.manager.view.PanelDisplayDirectory;
import com.shevelev.manager.view.PanelInfoAboutDirectory;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

/**
 * Created by denis on 04.11.17.
 */
public class TreeListener  implements TreeSelectionListener {
    private DirectoryFile directoryFile;
    private PanelDisplayDirectory panelDisplayDirectory;
    private JFrame frame;
    private PanelInfoAboutDirectory panelInfoDir;
    private JPanel panelInfo;
    private TreeFileManager treeFileManager;

    public TreeListener(JFrame frame, PanelInfoAboutDirectory panelInfoDir, JPanel panelInfo, DirectoryFile directoryFile, PanelDisplayDirectory panelDisplayDirectory){
        this.frame = frame;
        this.panelInfoDir = panelInfoDir;
        this.panelInfo = panelInfo;
        this.directoryFile = directoryFile;
        this.panelDisplayDirectory = panelDisplayDirectory;
    }

    public void valueChanged(TreeSelectionEvent e) {
        treeFileManager = new TreeFileManager();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
        treeFileManager.createChild(node);
        directoryFile.setDirectoryFile((File)node.getUserObject());

        panelDisplayDirectory.getPanelInPanel().removeAll();
        panelDisplayDirectory.getPanel().removeAll();
        panelDisplayDirectory.addLabelInPanel();

        panelInfo.removeAll();
        panelInfoDir.addPanelInfo();

        frame.repaint();
        frame.validate();
    }
}
