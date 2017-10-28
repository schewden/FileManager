package com.shevelev.manager.view;

import javax.swing.*;
import java.awt.*;

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

    public DisplayUsers(){
        frame = new JFrame("FM DiiShev");

        panelMenu = new JPanel();
        frame.add(panelMenu,BorderLayout.NORTH);
        new TopMenuBar(frame,panelMenu);

        panelDirectory = new JPanel();
        panelMenu.add(panelDirectory,BorderLayout.SOUTH );
        new PanelByDirectory(panelDirectory);

        panelCenter = new JPanel();
        frame.add(panelCenter, BorderLayout.WEST);
        new PanelDisplayDirectory(panelCenter);

        panelTree = new JPanel();
        frame.add(panelTree,BorderLayout.WEST);
        new PanelTree(panelTree);

        panelInfo = new JPanel();
        frame.add(panelInfo,BorderLayout.EAST);
        new PanelInfoAboutDirectory(panelInfo);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
