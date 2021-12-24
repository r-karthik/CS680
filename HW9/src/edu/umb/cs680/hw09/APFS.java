package edu.umb.cs680.hw09;
import java.util.LinkedList;
import java.util.Date;
import java.util.Iterator;

public class APFS extends FileSystem {
    private Date d2 = new Date();
    private Date m2 = new Date();
    static APFS instance = null;
    private ApfsDirectory root = new ApfsDirectory(null, "root" , 0, d2, "BKwapong", m2);

    public static APFS getInstance() {
        if (instance == null) {
            instance = new APFS();
        }
        return instance;
    }

    private LinkedList<ApfsDirectory> rootDir = new LinkedList<ApfsDirectory>();

    @Override
    protected FSElement createDefaultRoot() {
        FSElement rootDirs = new FSElement(null, "root" , 0, d2, "BKwapong", m2);
        return rootDirs;
    }

    public void setRootDir(ApfsDirectory root) {
        this.root = root;
    }

    public LinkedList<ApfsDirectory> getRootDirs() {
        return rootDir;
    }
}