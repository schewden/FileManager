package com.shevelev.manager.view;

import com.shevelev.manager.model.DirectoryFile;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by denis on 17.10.17.
 */
public class DisplayUsers {
    private JFrame frame;
    private JPanel panelMenu;
    private JPanel panelCenter;
    private JPanel panelDirectory;
    private JPanel panelTree;
    private JPanel panelInfo;

    public DisplayUsers() {
        frame = new JFrame("FM DiiShev");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,600));

        DirectoryFile directoryFile = new DirectoryFile();

        directoryFile.setDirectoryFile(new File("/"));

        panelInfo = new JPanel();
        frame.add(panelInfo,BorderLayout.SOUTH);
        PanelInfoAboutDirectory panelInfoAboutDirectory = new PanelInfoAboutDirectory(panelInfo, directoryFile);

        panelCenter = new JPanel();
        frame.add(panelCenter, BorderLayout.CENTER);
        ///new PanelTable(panelCenter);
        PanelDisplayDirectory panelDisplayDirectory = new PanelDisplayDirectory(frame,panelInfoAboutDirectory, panelInfo, panelCenter, directoryFile);

        panelTree = new JPanel();
        frame.add(panelTree,BorderLayout.WEST);
        PanelTree panelTree = new PanelTree(frame, panelInfoAboutDirectory, panelInfo, panelDisplayDirectory, this.panelTree, directoryFile);

        panelMenu = new JPanel();
        frame.add(panelMenu,BorderLayout.NORTH);
        new TopMenuBar(frame,panelMenu,directoryFile,panelDisplayDirectory,panelInfoAboutDirectory,panelTree);

        panelDirectory = new JPanel();
        panelMenu.add(panelDirectory,BorderLayout.SOUTH );
        new PanelByDirectory(panelDirectory);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
