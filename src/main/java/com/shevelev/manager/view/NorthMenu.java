package com.shevelev.manager.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denis on 22.10.17.
 */

public class NorthMenu{
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuHome;
    private JMenu menuView;
    private JMenu openNewWindows;
    private JMenu openCMD;
    private JMenu reference;

    private JMenuItem closeFM;
    private JMenuItem openToNewWindows;
    private JMenuItem openToNewWindowsProcess;
    private JMenuItem openCmdToDirectory;
    private JMenuItem openCmdToDirectoryAdmin;
    private JMenuItem referenceFM;
    private JMenuItem aboutProgram;

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


    public NorthMenu(JFrame frame){
        menuBar = new JMenuBar();
        menuFile = new JMenu("Файл");
        menuFile.setOpaque(true);
        menuFile.setBackground(Color.LIGHT_GRAY);
        menuHome = new JMenu("Главная");
        menuView = new JMenu("Вид");

        openNewWindows = new JMenu();
        openNewWindows.setText("Открыть в новом окне");
        openNewWindows.setIcon(new ImageIcon("src/main/resources/images/add232.png"));
        menuFile.add(openNewWindows);

        openToNewWindows = new JMenuItem();
        openToNewWindows.setText("Открыть в новом окне");
        openToNewWindows.setIcon(new ImageIcon("src/main/resources/images/add232.png"));
        openNewWindows.add(openToNewWindows);

        openToNewWindowsProcess = new JMenuItem();
        openToNewWindowsProcess.setText("Открыть в новом окне нового процесса");
        openToNewWindowsProcess.setIcon(new ImageIcon("src/main/resources/images/Process.png"));
        openNewWindows.add(openToNewWindowsProcess);

        openCMD = new JMenu();
        openCMD.setText("Открыть командную строку");
        openCMD.setIcon(new ImageIcon("src/main/resources/images/computer32.png"));
        menuFile.add(openCMD);

        openCmdToDirectory = new JMenuItem();
        openCmdToDirectory.setText("Открыть командную строку");
        openCmdToDirectory.setIcon(new ImageIcon("src/main/resources/images/computer32.png"));
        openCMD.add(openCmdToDirectory);

        openCmdToDirectoryAdmin = new JMenuItem();
        openCmdToDirectoryAdmin.setText("Открыть командную строку как админ");
        openCmdToDirectoryAdmin.setIcon(new ImageIcon("src/main/resources/images/Admin.png"));
        openCMD.add(openCmdToDirectoryAdmin);


        reference = new JMenu();
        reference.setText("Справка");
        reference.setIcon(new ImageIcon("src/main/resources/images/info32.png"));
        menuFile.add(reference);

        referenceFM = new JMenuItem();
        referenceFM.setText("Справка");
        referenceFM.setIcon(new ImageIcon("src/main/resources/images/info32.png"));
        reference.add(referenceFM);

        aboutProgram = new JMenuItem("О программе");
        aboutProgram.setIcon(new ImageIcon("src/main/resources/images/Faq.png"));
        reference.add(aboutProgram);

        closeFM = new JMenuItem();
        closeFM.setText("Закрыть");
        closeFM.setIcon(new ImageIcon("src/main/resources/images/close32.png"));
        menuFile.add(closeFM);

        menuBar.add(menuFile);
        menuBar.add(menuHome);
        menuBar.add(menuView);
        frame.setJMenuBar(menuBar);
    }

    public NorthMenu(JPanel panel){
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

        copy.setIcon(new ImageIcon("src/main/resources/images/info32.png"));
        copy.setBackground(Color.WHITE);
        insert.setIcon(new ImageIcon("src/main/resources/images/info32.png"));
        insert.setBackground(Color.WHITE);
        insertTag.setIcon(new ImageIcon("src/main/resources/images/info32.png"));
        insertTag.setBackground(Color.WHITE);
        cut.setIcon(new ImageIcon("src/main/resources/images/info32.png"));
        cut.setBackground(Color.WHITE);
        copyPath.setIcon(new ImageIcon("src/main/resources/images/info32.png"));
        copyPath.setBackground(Color.WHITE);
        delete.setIcon(new ImageIcon("src/main/resources/images/info32.png"));
        delete.setBackground(Color.WHITE);
        rename.setIcon(new ImageIcon("src/main/resources/images/info32.png"));
        rename.setBackground(Color.WHITE);
        createDirectory.setIcon(new ImageIcon("src/main/resources/images/info32.png"));
        createDirectory.setBackground(Color.WHITE);




        panel.add(copy,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(insert,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(insertTag,new GridBagConstraints(2,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(cut,new GridBagConstraints(3,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(copyPath,new GridBagConstraints(4,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(delete,new GridBagConstraints(5,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(rename,new GridBagConstraints(6,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(createDirectory,new GridBagConstraints(7,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));

        panel.add(copyLabel,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(insertLabel,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(insertTagLabel,new GridBagConstraints(2,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(cutLabel,new GridBagConstraints(3,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(copyPathLabel,new GridBagConstraints(4,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(deleteLabel,new GridBagConstraints(5,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(renameLabel,new GridBagConstraints(6,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));
        panel.add(createDirectoryLabel,new GridBagConstraints(7,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0));

    }




}
