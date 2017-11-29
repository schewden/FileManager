package com.shevelev.manager.model;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FileToDirectoryModel {

    private File fileToDirectory;
    private File selectedDirectory;
    
    private List<File> directoriesList;
    private List<File> filesList;
    private List<File> listFilesAndDirectories;

    private boolean name;
    private boolean type;
    private boolean data;
    private boolean size;

    public boolean isSize() {
        return size;
    }

    public void setSize(boolean size) {
        this.size = size;
    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isName() {
        return name;
    }

    public void setName(boolean name) {
        this.name = name;
    }

    public File getSelectedDirectory() {
        return selectedDirectory;
    }

    public void setSelectedDirectory(File selectedDirectory) {
        this.selectedDirectory = selectedDirectory;
    }

    public List<File> getListFilesAndDirectories() {
        if (isName()){
            listFilesAndDirectories.sort(new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }else if (isType()){
            listFilesAndDirectories.sort(new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    if (o1.isDirectory() ==  o2.isDirectory()){
                        return 0;
                    }else if (o1.isDirectory() && !o2.isDirectory()){
                        return -1;
                    }else {
                        return 1;
                    }
                }
            });
        }else  if (isData()){
            listFilesAndDirectories.sort(new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return Long.compare(o1.lastModified(),o2.lastModified());
                }
            });
        }else if (isSize()){
            listFilesAndDirectories.sort(new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return Long.compare(o1.length(),o2.length());
                }
            });
        }

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
