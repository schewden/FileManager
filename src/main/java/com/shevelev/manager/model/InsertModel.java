package com.shevelev.manager.model;

/**
 * This model working with insert in current directory
 */
public class InsertModel {
    private Object storageCurrentTreePath;
    private boolean markCutFileOrDir;

    /**
     * Get an insertion object
     *
     * @return storageCurrentTreePath
     */
    public Object getStorageCurrentTreePath() {
        return storageCurrentTreePath;
    }

    /**
     * Set insertion.(You can insert it: the cut out file, the path and the copied file)
     *
     * @param storageCurrentTreePath - object insert
     */
    public void setStorageCurrentTreePath(Object storageCurrentTreePath) {
        this.storageCurrentTreePath = storageCurrentTreePath;
    }

    /**
     * Get cut flag
     *
     * @return if you want to insert cut file a return true, else false
     */
    public boolean isMarkCutFileOrDir() {
        return markCutFileOrDir;
    }

    /**
     * Set cut flag
     *
     * @param markCutFileOrDir if you want to insert cut file, set true, else false
     */
    public void setMarkCutFileOrDir(boolean markCutFileOrDir) {
        this.markCutFileOrDir = markCutFileOrDir;
    }
}
