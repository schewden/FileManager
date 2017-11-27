package com.shevelev.manager.controller.tab;

import com.shevelev.manager.model.FileToDirectoryModel;
import com.shevelev.manager.model.InsertModel;
import com.shevelev.manager.view.DisplayUsers;
import com.shevelev.manager.view.PanelByDirectory;
import com.shevelev.manager.view.PanelTree;
import org.apache.commons.io.FileUtils;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * In this class, the insert button listener controller is implemented.
 * You can insert the path of the directory, the copied directory or file, and the cut directory or file.
 */
public class TabHomeInsertListener implements ActionListener {
    private FileToDirectoryModel fileToDirectoryModel;
    private PanelByDirectory panelByDirectory;
    private PanelTree panelTree;
    private DisplayUsers displayUsers;
    private InsertModel insertModel;

    /**
     * Constructor
     *
     * @param fileToDirectoryModel - model by files (fileToDirectoryModel.java)
     * @param panelByDirectory     - panel by directories (PanelByDirectory.java)
     * @param panelTree            - panel by tree (PanelTree.java)
     * @param displayUsers         - head panel (DisplayUsers.java)
     * @param insertModel          - model of inserting a directory or file (InsertModel.java)
     */
    public TabHomeInsertListener(FileToDirectoryModel fileToDirectoryModel, PanelByDirectory panelByDirectory,
                                 PanelTree panelTree, DisplayUsers displayUsers,
                                 InsertModel insertModel) {
        this.fileToDirectoryModel = fileToDirectoryModel;
        this.panelByDirectory = panelByDirectory;
        this.panelTree = panelTree;
        this.displayUsers = displayUsers;
        this.insertModel = insertModel;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e is an instance of ActionEvent class
     */
    public void actionPerformed(ActionEvent e) {
        try {

            Object currentFile = insertModel.getStorageCurrentTreePath();
            if (currentFile instanceof String) {
                String name = currentFile.toString();
                panelByDirectory.getAddressBar().setText(name);
            } else {
                File src = (File) currentFile;
                File destDir = fileToDirectoryModel.getFileToDirectory();
                if (src.isDirectory() && destDir.isDirectory()) {
                    insertDirectory(src, destDir, panelTree, fileToDirectoryModel, insertModel, displayUsers);
                } else {
                    insertFile(src, destDir, fileToDirectoryModel, insertModel, displayUsers);
                }
            }
        } catch (NullPointerException npe) {
            ErrorMessage errorMessage = new ErrorMessage(displayUsers.getFrame());
            String msg = "Нет файлов в буфере!";
            errorMessage.errorMessagePane(msg, "Ошибка вставки");
        }
    }

    /**
     * The procedure for inserting a directory
     *
     * @param srcDir               - an existing directory to copy, must not be null
     * @param destDir              - the directory(file) to place the copy in, must not be null
     * @param panelTree            - panel by tree (PanelTree.java)
     * @param fileToDirectoryModel - model by files (FileToDirectoryModel.java)
     * @param insertModel          - model of inserting a directory or file (InsertModel.java)
     */
    private void insertDirectory(File srcDir, File destDir, PanelTree panelTree,
                                 FileToDirectoryModel fileToDirectoryModel, InsertModel insertModel,
                                 DisplayUsers displayUsers) {
        try {
            String nameSrcDir = srcDir.getName();
            TreePath srcTreePath = panelTree.getTreePathInJTree(srcDir);
            DefaultMutableTreeNode srcParentNode = (DefaultMutableTreeNode) srcTreePath.getParentPath().getLastPathComponent();
            String[] destDirFilesList = destDir.list();
            if (!insertModel.isMarkCutFileOrDir()) {
                if (destDirFilesList != null) {
                    List<String> destDirList = Arrays.asList(destDirFilesList);
                    String currentNameDir = srcDir.getName();
                    if (destDirList.contains(currentNameDir)) {
                        int count = 1;
                        for (int i = 0; i < destDirList.size(); i++) {
                            currentNameDir = srcDir.getName() + " копия " + "(" + count + ")";
                            if (destDirList.contains(currentNameDir)) {
                                count++;
                            } else {
                                FileUtils.copyDirectoryToDirectory(srcDir, new File(destDir, currentNameDir));
                                break;
                            }
                        }
                    } else if (!destDirList.contains(currentNameDir)) {
                        FileUtils.copyDirectoryToDirectory(srcDir, new File(destDir, currentNameDir));
                    } else if (destDir.equals(srcDir)) {
                        String msg = "Нельзя скопировать каталог сам в себя!";
                        ErrorMessage errorMessage = new ErrorMessage(displayUsers.getFrame());
                        errorMessage.errorMessagePane(msg, "Ошибка вставки");
                    }
                }

            } else {
                FileUtils.moveDirectoryToDirectory(srcDir, destDir, true);
            }
            File destFile = fileToDirectoryModel.getFileToDirectory();
            TreePath destTreePath = panelTree.getTreePathInJTree(destFile);
            if (!insertModel.isMarkCutFileOrDir()) {
                DefaultMutableTreeNode parentDestDir = (DefaultMutableTreeNode) destTreePath.getLastPathComponent();
                DefaultMutableTreeNode srcNewNode = new DefaultMutableTreeNode(srcDir);
                panelTree.getDefaultTreeModel().insertNodeInto(srcNewNode, parentDestDir, parentDestDir.getChildCount());
            } else {
                panelTree.removeNodeFromJTree(srcTreePath, srcParentNode, panelTree.getDefaultTreeModel());
                panelTree.insertNodeIntoJTree(destTreePath, panelTree.getDefaultTreeModel(), nameSrcDir);
            }
            fileToDirectoryModel.setFileToDirectory(fileToDirectoryModel.getFileToDirectory());
            displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * The procedure for inserting a file
     *
     * @param srcFile              - an existing file to copy, must not be null
     * @param destDir              - the directory(file) to place the copy in, must not be null
     * @param fileToDirectoryModel - model by files (FileToDirectoryModel.java)
     * @param insertModel          - model of inserting a directory or file (InsertModel.java)
     */
    private void insertFile(File srcFile, File destDir, FileToDirectoryModel fileToDirectoryModel,
                            InsertModel insertModel, DisplayUsers displayUsers) {
        try {
            if (!insertModel.isMarkCutFileOrDir()) {
                String[] destDirFilesList = destDir.list();
                if (destDirFilesList != null) {
                    List<String> destDirList = Arrays.asList(destDirFilesList);
                    String currentNameFile = srcFile.getName();
                    int dotIndex = currentNameFile.lastIndexOf('.');
                    if (destDirList.contains(currentNameFile)) {
                        int count = 1;
                        for (int i = 0; i < destDirList.size(); i++) {
                            currentNameFile = srcFile.getName().substring(0, dotIndex) + " копия " + "(" + count + ")" + srcFile.getName().substring(dotIndex);
                            if (destDirList.contains(currentNameFile)) {
                                count++;
                            } else {
                                FileUtils.copyFile(srcFile, new File(destDir, currentNameFile));
                                break;
                            }
                        }
                    } else {
                        FileUtils.copyFile(srcFile, new File(destDir, currentNameFile));
                    }
                }
            } else {
                FileUtils.moveFileToDirectory(srcFile, destDir, true);
            }
            fileToDirectoryModel.setFileToDirectory(fileToDirectoryModel.getFileToDirectory());
            displayUsers.repaintGUI(fileToDirectoryModel.getListFilesAndDirectories());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
