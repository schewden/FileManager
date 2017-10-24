package com.shevelev.manager.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denis on 23.10.17.
 */
public class HomeNorthPanel {
    private JPanel panel;
    private JButton copy;
    private JButton insert;
    private JButton cut;
    private JButton copyPath;
    private JButton delete;
    private JButton rename;
    private JButton createDirectory;
    private JButton insertTag;

    private JLabel copyLabel;
    private JLabel insertLabel;
    private JLabel cutLabel;
    private JLabel copyPathLabel;
    private JLabel deleteLabel;
    private JLabel renameLabel;
    private JLabel createDirectoryLabel;
    private JLabel insertTagLabel;

    public HomeNorthPanel(JFrame frame){
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        frame.add(panel,BorderLayout.NORTH);
        copy = new JButton();
        insert = new JButton();
        insertTag = new JButton();
        cut = new JButton();
        copyPath = new JButton();
        delete = new JButton();
        rename = new JButton();
        createDirectory = new JButton();
        copyLabel = new JLabel("Копировать");
        insertLabel = new JLabel("Вставить");
        insertTagLabel = new JLabel("Вставить ярлык");
        cutLabel = new JLabel("Вырезать");
        copyPathLabel = new JLabel("Скопировать путь");
        deleteLabel = new JLabel("Удалить");
        renameLabel = new JLabel("Переименовать");
        createDirectoryLabel = new JLabel("Создать папку");

        copy.setIcon(new ImageIcon("src/main/resources/images/copy.png"));
        copy.setBackground(Color.WHITE);
        insert.setIcon(new ImageIcon("src/main/resources/images/documents32.png"));
        insert.setBackground(Color.WHITE);
        insertTag.setIcon(new ImageIcon("src/main/resources/images/import32.png"));
        insertTag.setBackground(Color.WHITE);
        cut.setIcon(new ImageIcon("src/main/resources/images/cut.png"));
        cut.setBackground(Color.WHITE);
        copyPath.setIcon(new ImageIcon("src/main/resources/images/paper-plane.png"));
        copyPath.setBackground(Color.WHITE);
        delete.setIcon(new ImageIcon("src/main/resources/images/del.png"));
        delete.setBackground(Color.WHITE);
        rename.setIcon(new ImageIcon("src/main/resources/images/rename32.png"));
        rename.setBackground(Color.WHITE);
        createDirectory.setIcon(new ImageIcon("src/main/resources/images/Folder.png"));
        createDirectory.setBackground(Color.WHITE);


        panel.add(copy,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(insert,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(insertTag,new GridBagConstraints(2,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(cut,new GridBagConstraints(3,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(copyPath,new GridBagConstraints(4,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(delete,new GridBagConstraints(5,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(rename,new GridBagConstraints(6,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(createDirectory,new GridBagConstraints(7,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));

        panel.add(copyLabel,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(insertLabel,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(insertTagLabel,new GridBagConstraints(2,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(cutLabel,new GridBagConstraints(3,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(copyPathLabel,new GridBagConstraints(4,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(deleteLabel,new GridBagConstraints(5,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(renameLabel,new GridBagConstraints(6,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(createDirectoryLabel,new GridBagConstraints(7,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
    }

    public JPanel getPanel() {
        return panel;
    }

}
