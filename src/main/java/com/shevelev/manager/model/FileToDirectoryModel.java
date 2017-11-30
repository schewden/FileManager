package com.shevelev.manager.model;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * This model working with directory
 */
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

    /**
     * Get sort this directory by size
     *
     * @return if sort this dir, return true
     */
    public boolean isSize() {
        return size;
    }

    /**
     * if sort by size this dir, set true, else false
     *
     * @param size true, if sort size
     */
    public void setSize(boolean size) {
        this.size = size;
    }

    /**
     * Get sort this directory by data
     *
     * @return if sort this dir, return true
     */
    public boolean isData() {
        return data;
    }

    /**
     * if sort by data this dir, set true, else false
     *
     * @param data true, if sort data
     */
    public void setData(boolean data) {
        this.data = data;
    }

    /**
     * Get sort this directory by type
     *
     * @return if sort this dir, return true
     */
    public boolean isType() {
        return type;
    }

    /**
     * if sort by type this dir, set true, else false
     *
     * @param type true, if sort data
     */
    public void setType(boolean type) {
        this.type = type;
    }

    /**
     * Get sort this directory by name
     *
     * @return if sort this dir, return true
     */
    public boolean isName() {
        return name;
    }

    /**
     * if sort by name this dir, set true, else false
     *
     * @param name true, if sort data
     */
    public void setName(boolean name) {
        this.name = name;
    }

    /**
     * get a selection  of file
     *
     * @return current selection file
     */
    public File getSelectedDirectory() {
        return selectedDirectory;
    }

    /**
     * set selection file
     *
     * @param selectedDirectory current selection file
     */
    public void setSelectedDirectory(File selectedDirectory) {
        this.selectedDirectory = selectedDirectory;
    }

    /**
     * Get a list of files(dir and file)
     *
     * @return list files
     */
    public List<File> getListFilesAndDirectories() {
        if (isName()) {
            listFilesAndDirectories.sort(new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        } else if (isType()) {
            listFilesAndDirectories.sort(new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    if (o1.isDirectory() == o2.isDirectory()) {
                        return 0;
                    } else if (o1.isDirectory() && !o2.isDirectory()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
        } else if (isData()) {
            listFilesAndDirectories.sort(new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return Long.compare(o1.lastModified(), o2.lastModified());
                }
            });
        } else if (isSize()) {
            listFilesAndDirectories.sort(new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return Long.compare(o1.length(), o2.length());
                }
            });
        }

        return listFilesAndDirectories;
    }

    /**
     * Set a list  of files(dir and files)
     *
     * @param listFilesAndDirectories list files
     */
    public void setListFilesAndDirectories(List<File> listFilesAndDirectories) {
        this.listFilesAndDirectories = listFilesAndDirectories;
    }

    /**
     * Get a list of directories
     *
     * @return list files(dir)
     */
    public List<File> getDirectoriesList() {
        return directoriesList;
    }

    /**
     * Set a list  of files(dir)
     *
     * @param directoriesList list files
     */
    public void setDirectoriesList(List<File> directoriesList) {
        this.directoriesList = directoriesList;
    }

    /**
     * Get a list of files(not dir)
     *
     * @return list files
     */
    public List<File> getFilesList() {
        return filesList;
    }

    /**
     * Set a list  of files(not dir)
     *
     * @param filesList list files
     */
    public void setFilesList(List<File> filesList) {
        this.filesList = filesList;
    }

    /**
     * Get a file to current directory
     *
     * @return current file dir
     */
    public File getFileToDirectory() {
        return fileToDirectory;
    }

    /**
     * Set a file to current directory and set a list files
     *
     * @param fileToDirectory current file dir
     */
    public void setFileToDirectory(File fileToDirectory) {
        this.fileToDirectory = fileToDirectory;
        File[] listFiles = fileToDirectory.listFiles();
        if (listFiles != null) {
            setListFilesAndDirectories(Arrays.asList(listFiles));
        }
    }
}
