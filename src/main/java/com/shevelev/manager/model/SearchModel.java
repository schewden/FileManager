package com.shevelev.manager.model;

import java.io.File;
import java.util.List;
import java.util.Map;


public class SearchModel {
    private Map<String, File> currentFilesInDirectory;
    private List<String> currentFilesStringInDirectory;
    private int countRepeat = 0;

    public void setCurrentFilesInDirectory(File currentDirectory, Map<String, File> currentFilesInDirectory) {
        countRepeat++;
        String file = "f";
        String dir = "d";
        File[] listFiles = currentDirectory.listFiles();
        this.currentFilesInDirectory = currentFilesInDirectory;
        if (listFiles != null) {
            for (File currentFile : listFiles) {
                if (this.currentFilesInDirectory.containsKey(currentFile.getName())) {
                    if (currentFile.isDirectory()) {
                        this.currentFilesInDirectory.put(currentFile.getName() + (dir) + (countRepeat), currentFile);
                        this.currentFilesStringInDirectory.add(currentFile.getName() + (dir) + (countRepeat));
                        setCurrentFilesInDirectory(currentFile, this.currentFilesInDirectory);
                    } else {
                        this.currentFilesInDirectory.put(currentFile.getName() + (file) + (countRepeat), currentFile);
                        this.currentFilesStringInDirectory.add(currentFile.getName() + (file) + (countRepeat));
                    }
                } else {
                    this.currentFilesInDirectory.put(currentFile.getName(), currentFile);
                    this.currentFilesStringInDirectory.add(currentFile.getName());
                    setCurrentFilesInDirectory(currentFile, this.currentFilesInDirectory);
                }
            }
        }
    }

    public void setCurrentFilesStringInDirectory(List<String> currentFilesStringInDirectory) {
        this.currentFilesStringInDirectory = currentFilesStringInDirectory;
    }
}
