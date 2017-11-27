package com.shevelev.manager.model;

import java.io.File;
import java.util.List;


public class SearchModel {
    private List<String> currentFilesStringInDirectory;
    private List<File> currentFilesInDirectory;

    public void setCurrentFilesInDirectory1(File currentDirectory, List<File> currentFilesInDirectory1) {
        File[] listFiles = currentDirectory.listFiles();
        this.currentFilesInDirectory = currentFilesInDirectory1;
        if (listFiles != null) {
            for (File currentFile : listFiles) {
                this.currentFilesInDirectory.add(currentFile);
                this.currentFilesStringInDirectory.add(currentFile.getName());
                setCurrentFilesInDirectory1(currentFile,this.currentFilesInDirectory);
            }
        }
    }

    public void setCurrentFilesStringInDirectory(List<String> currentFilesStringInDirectory) {
        this.currentFilesStringInDirectory = currentFilesStringInDirectory;
    }
}
