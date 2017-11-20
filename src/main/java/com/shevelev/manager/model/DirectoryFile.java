package com.shevelev.manager.model;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by denis on 21.10.17.
 */
public class DirectoryFile {

    private File directoryFile;
    private File selectedFile;
    private List<File> directoryList;
    private List<File> fileList;
    private List<File> directoryFileList;

    public File getSelectedFile() {
        return selectedFile;
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

    public List<File> getDirectoryFileList() {
        return directoryFileList;
    }

    public void setDirectoryFileList(List<File> directoryFileList) {
        this.directoryFileList = directoryFileList;
    }

    public List<File> getDirectoryList() {
        return directoryList;
    }

    public void setDirectoryList(List<File> directoryList) {
        this.directoryList = directoryList;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public File getDirectoryFile() {
        return directoryFile;
    }

    public void setDirectoryFile(File directoryFile) {
        this.directoryFile = directoryFile;
        setDirectoryFileList(Arrays.asList(directoryFile.listFiles()));
    }
}
