package com.shevelev.manager.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denis on 17.10.17.
 */
public class DisplayUsers {
    private JFrame frame;
    private JPanel northPanel;

    public DisplayUsers(){
        frame = new JFrame("FM DiiShev");
        new NorthMenu(frame);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        northPanel = new JPanel();
        frame.add(northPanel,BorderLayout.NORTH);
        northPanel.setLayout(new GridBagLayout());
        new NorthMenu(northPanel);
        //frame.pack();
        frame.setVisible(true);
    }
}
