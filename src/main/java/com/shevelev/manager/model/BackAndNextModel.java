package com.shevelev.manager.model;

import java.io.File;
import java.util.ArrayDeque;

/**
 * The model works by navigating through the catalog using the back and next buttons
 */
public class BackAndNextModel {
    private ArrayDeque<File> previousFiles = new ArrayDeque<>();//button back
    private ArrayDeque<File> futureFiles = new ArrayDeque<>();//button next

    /**
     * Get ArrayDeque<File> futureFiles
     *
     * @return list futureFiles;
     */
    public ArrayDeque<File> getFutureFiles() {
        return futureFiles;
    }

    /**
     * Add files in ArrayDeque<File> futureFiles
     *
     * @param currentPathDir - future path in directory
     */
    public void setFutureFiles(File currentPathDir) {
        futureFiles.add(currentPathDir);
    }

    /**
     * Get ArrayDeque<File> previousFiles
     *
     * @return list previousFiles
     */
    public ArrayDeque<File> getPreviousFiles() {
        return previousFiles;
    }

    /**
     * Add files in previousFiles
     *
     * @param currentPathDir - previous path in directory
     */
    public void setPreviousFiles(File currentPathDir) {
        if (previousFiles.size() < 1) {
            previousFiles.add(currentPathDir);
        } else if (!previousFiles.getLast().equals(currentPathDir)) {
            previousFiles.add(currentPathDir);
        }
    }
}
