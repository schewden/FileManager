package com.shevelev.manager.model;

/**
 * Created by denis on 26.11.17.
 */
public class CutModel {
    private Object storageCurrentTreePath;
    private boolean markCutFileOrDir;

    public Object getStorageCurrentTreePath() {
        return storageCurrentTreePath;
    }

    public void setStorageCurrentTreePath(Object storageCurrentTreePath) {
        this.storageCurrentTreePath = storageCurrentTreePath;
    }

    public boolean isMarkCutFileOrDir() {
        return markCutFileOrDir;
    }

    public void setMarkCutFileOrDir(boolean markCutFileOrDir) {
        this.markCutFileOrDir = markCutFileOrDir;
    }
}
