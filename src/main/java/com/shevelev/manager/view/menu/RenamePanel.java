package com.shevelev.manager.view.menu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denis on 20.11.17.
 */
public class RenamePanel {
    private JPanel renamePanel;
    private JTextField name;
    public RenamePanel(){
        renamePanel = new JPanel(new GridLayout(2,1));
        name = new JTextField(15);
        renamePanel.add(new JLabel("Имя файла"));
        renamePanel.add(name);
    }

    public JPanel getRenamePanel() {
        return renamePanel;
    }

    public JTextField getName() {
        return name;
    }
}
