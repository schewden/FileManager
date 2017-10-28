package com.shevelev.manager.view;

import com.shevelev.manager.controller.MenuMouseListener;
import com.shevelev.manager.view.menu.ButtonFileMenu;
import com.shevelev.manager.view.menu.TabHomePanel;
import com.shevelev.manager.view.menu.TabViewPanel;

import javax.swing.*;
import java.awt.*;

/**
 * top menu class
 */

public class TopMenuBar {
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JTabbedPane tabbedPane;
    private TabHomePanel tabHomePanel;
    private TabViewPanel tabViewPanel;

    public TopMenuBar(JFrame frame,JPanel panel){
        panel.setLayout(new BorderLayout());
        Font font = new Font("Times New Roman", Font.ITALIC, 14);
        tabbedPane = new JTabbedPane();
        tabHomePanel = new TabHomePanel();
        tabViewPanel = new TabViewPanel();
        menuBar = new JMenuBar();

        menuFile = new JMenu("Файл");
        menuFile.setOpaque(true);
        menuFile.setBackground(Color.LIGHT_GRAY);
        menuFile.setFont(font);
        new ButtonFileMenu(menuFile);
        menuBar.add(menuFile);

        panel.add(tabbedPane,BorderLayout.NORTH);
        tabbedPane.add("Главная", tabHomePanel.getPanel());
        tabbedPane.add("Вид", tabViewPanel.getPanel());
        tabbedPane.setFont(font);

        tabbedPane.setSelectedIndex(0);
        frame.setJMenuBar(menuBar);

        menuFile.addMouseListener(new MenuMouseListener(menuFile, tabbedPane));
    }


}
