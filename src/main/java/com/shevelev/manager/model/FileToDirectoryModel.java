package com.shevelev.manager.model;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileToDirectoryModel {

    private File fileToDirectory;
    private File selectedDirectory;
    
    private List<File> directoriesList;
    private List<File> filesList;
    private List<File> listFilesAndDirectories;

    public File getSelectedDirectory() {
        return selectedDirectory;
    }

    public void setSelectedDirectory(File selectedDirectory) {
        this.selectedDirectory = selectedDirectory;
    }

    public List<File> getListFilesAndDirectories() {
        return listFilesAndDirectories;
    }

    public void setListFilesAndDirectories(List<File> listFilesAndDirectories) {
        this.listFilesAndDirectories = listFilesAndDirectories;
    }

    public List<File> getDirectoriesList() {
        return directoriesList;
    }

    public void setDirectoriesList(List<File> directoriesList) {
        this.directoriesList = directoriesList;
    }

    public List<File> getFilesList() {
        return filesList;
    }

    public void setFilesList(List<File> filesList) {
        this.filesList = filesList;
    }

    public File getFileToDirectory() {
        return fileToDirectory;
    }

    public void setFileToDirectory(File fileToDirectory) {
        this.fileToDirectory = fileToDirectory;
        File[] listFiles = fileToDirectory.listFiles();
        if (listFiles != null){
            setListFilesAndDirectories(Arrays.asList(listFiles));
        }
    }
}
