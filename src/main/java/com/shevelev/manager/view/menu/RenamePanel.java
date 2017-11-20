package com.shevelev.manager.view.menu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denis on 20.11.17.
 */
public class RenamePanel {
    private JPanel renamePanel;

    public RenamePanel(){
        renamePanel = new JPanel(new GridLayout(2,1));
        renamePanel.add(new JLabel("Имя файла"));
        renamePanel.add(new JTextField(15));
    }

    public JPanel getRenamePanel() {
        return renamePanel;
    }
}
