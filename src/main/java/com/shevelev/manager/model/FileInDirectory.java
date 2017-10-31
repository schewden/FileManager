package com.shevelev.manager.model;

import java.io.File;
import java.util.List;

/**
 * Created by denis on 22.10.17.
 */
public class FileInDirectory {
    private File file;
    private List<String> listDirectory;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<String> getListDirectory() {
        return listDirectory;
    }

    public void setListDirectory(List<String> listDirectory) {
        this.listDirectory = listDirectory;
    }
}
