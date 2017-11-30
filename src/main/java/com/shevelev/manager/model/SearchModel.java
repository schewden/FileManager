package com.shevelev.manager.model;

import java.io.File;
import java.util.List;

/**
 * This model working from search in current directroy
 */
public class SearchModel {
    private List<String> currentFilesStringInDirectory;
    private List<File> currentFilesInDirectory;

    /**
     * Function of obtaining a list of all files starting with current directory
     *
     * @param currentDirectory        - the current directory with which to search
     * @param currentFilesInDirectory - list all files
     */
    public void setCurrentFilesInDirectory(File currentDirectory, List<File> currentFilesInDirectory) {
        File[] listFiles = currentDirectory.listFiles();
        this.currentFilesInDirectory = currentFilesInDirectory;
        if (listFiles != null) {
            for (File currentFile : listFiles) {
                this.currentFilesInDirectory.add(currentFile);
                this.currentFilesStringInDirectory.add(currentFile.getName());
                setCurrentFilesInDirectory(currentFile, this.currentFilesInDirectory);
            }
        }
    }

    /**
     * Function of obtaining a list  of all names files starting with current directory
     *
     * @param currentFilesStringInDirectory list all names files
     */
    public void setCurrentFilesStringInDirectory(List<String> currentFilesStringInDirectory) {
        this.currentFilesStringInDirectory = currentFilesStringInDirectory;
    }
}
