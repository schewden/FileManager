package com.shevelev.manager.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denis on 17.10.17.
 */
public class DisplayUsers {
    private JFrame frame;
    private JPanel panelCenter;

    public DisplayUsers(){
        frame = new JFrame("FM DiiShev");
        HomeNorthPanel homeNorthPanel = new HomeNorthPanel(frame);
        new TopPanelMenu(frame,homeNorthPanel.getPanel());
        panelCenter = new JPanel();
        frame.add(panelCenter, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
