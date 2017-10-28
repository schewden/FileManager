package com.shevelev.manager.view;

import javax.swing.*;

/**
 * Created by denis on 29.10.17.
 */
public class PanelInfoAboutDirectory {
    private JLabel elements;
    private JLabel countElements;

    public PanelInfoAboutDirectory(JPanel panel){
        elements = new JLabel("Элементов:");
        panel.add(elements);
        countElements = new JLabel("3");
        panel.add(countElements);
    }
}
