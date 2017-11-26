package com.shevelev.manager.view;

import com.shevelev.manager.model.BackAndNextModel;
import com.shevelev.manager.model.CutModel;
import com.shevelev.manager.model.FileToDirectoryModel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

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

    private FileToDirectoryModel FileToDirectoryModel;
    private BackAndNextModel backAndNextModel;
    private CutModel cutModel;

    private PanelDisplayDirectory panelDisplayDirectory;
    private PanelTree panelTreeClass;
    private PanelInfoAboutDirectory panelInfoAboutDirectory;
    private PanelByDirectory panelByDirectory;

    public DisplayUsers() {
        frame = new JFrame("FM DiiShev");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));

        FileToDirectoryModel = new FileToDirectoryModel();
        backAndNextModel = new BackAndNextModel();
        cutModel = new CutModel();

        File rootSystem = new File("/");

        FileToDirectoryModel.setFileToDirectory(rootSystem);
        backAndNextModel.setPreviousFiles(rootSystem);

        panelInfo = new JPanel();
        frame.add(panelInfo, BorderLayout.SOUTH);
        panelInfoAboutDirectory = new PanelInfoAboutDirectory(panelInfo, FileToDirectoryModel);

        panelCenter = new JPanel();
        frame.add(panelCenter, BorderLayout.CENTER);
        panelDisplayDirectory = new PanelDisplayDirectory(panelCenter, FileToDirectoryModel, this, backAndNextModel);

        panelTree = new JPanel();
        frame.add(panelTree, BorderLayout.WEST);
        panelTreeClass = new PanelTree(panelDisplayDirectory, panelTree, FileToDirectoryModel, this, backAndNextModel);

        panelDirectory = new JPanel();
        panelByDirectory = new PanelByDirectory(panelDirectory, panelTreeClass, FileToDirectoryModel, this, backAndNextModel);

        panelMenu = new JPanel();
        frame.add(panelMenu, BorderLayout.NORTH);
        new TopMenuBar(frame, panelMenu, FileToDirectoryModel, panelTreeClass, this, panelByDirectory, cutModel);

        panelMenu.add(panelDirectory, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void repaintGUI(List<File> currentFiles) {
        panelDisplayDirectory.getPanelInPanelCenter().removeAll();
        panelCenter.removeAll();
        panelDisplayDirectory.updateCurrentDirectory(currentFiles);

        panelInfo.removeAll();
        panelInfoAboutDirectory.addPanelInfo();

        frame.repaint();
        frame.validate();
    }
}
