package com.shevelev.manager.controller;


import com.shevelev.manager.model.FileInDirectory;
import com.shevelev.manager.model.PathToDirectory;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by denis on 21.10.17.
 */
public class TreeFileManager {
    private File pathDirectory;
    private List<String> listFileToDirectory;
    PathToDirectory pathToDirectory;

    public List<String> getListFile(FileInDirectory fileInDirectory) {
        if (pathDirectory.isDirectory()) {
            pathDirectory = fileInDirectory.getFile();
            listFileToDirectory = Arrays.asList(pathDirectory.list());
            pathToDirectory = new PathToDirectory(pathDirectory.getAbsolutePath());

            return  listFileToDirectory;
        } else {
            return null;
        }
    }








}
