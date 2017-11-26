package com.shevelev.manager.model;

import java.io.File;
import java.util.ArrayDeque;


public class BackAndNextModel {
    private ArrayDeque<File> previousFiles = new ArrayDeque<>();
    private ArrayDeque<File> futureFiles  = new ArrayDeque<>();

    public ArrayDeque<File> getFutureFiles() {
        return futureFiles;
    }

    public void setFutureFiles(File currentPathDir) {
        futureFiles.add(currentPathDir);
    }

    public ArrayDeque<File> getPreviousFiles() {
        return previousFiles;
    }

    public void setPreviousFiles(File currentPathDir) {
            if (previousFiles.size() < 1) {
                previousFiles.add(currentPathDir);
            }else if (!previousFiles.getLast().equals(currentPathDir)){
                previousFiles.add(currentPathDir);
            }
    }
}
