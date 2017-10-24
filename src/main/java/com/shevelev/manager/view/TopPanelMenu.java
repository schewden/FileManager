package com.shevelev.manager.view;

import com.shevelev.manager.controller.MenuMouseListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denis on 22.10.17.
 */

public class TopPanelMenu {
    private JMenuBar menuBar;
    private JMenu menuFile;
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


    public TopPanelMenu(JFrame frame, JPanel panel) {
        menuBar = new JMenuBar();
        menuFile = new JMenu("Файл");
        menuFile.setOpaque(true);
        menuFile.setBackground(Color.LIGHT_GRAY);
        openNewWindows = new JMenu();
        openNewWindows.setText("Открыть в новом окне");
        openNewWindows.setIcon(new ImageIcon("src/main/resources/images/new.png"));
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
        reference.setIcon(new ImageIcon("src/main/resources/images/help.png"));
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
        closeFM.setIcon(new ImageIcon("src/main/resources/images/exit.png"));
        menuFile.add(closeFM);
        menuBar.add(menuFile);
        menuFile.addMouseListener(new MenuMouseListener(menuFile, panel));

        frame.setJMenuBar(menuBar);
    }
}
