package com.shevelev.manager;

import com.shevelev.manager.view.DisplayUsers;

/**
 * Created by denis on 17.10.17.
 */

public class HeadFileManager {
    public static void main(String[] args) {
        new DisplayUsers();
        /*File file = new File("/home/denis/Документы");
        FileInDirectory fileInDirectory = new FileInDirectory();
        fileInDirectory.setFile(file);
        TreeFileManager treeFileManager = new TreeFileManager(file);
        treeFileManager.getListFile(fileInDirectory);*/
    }
}
