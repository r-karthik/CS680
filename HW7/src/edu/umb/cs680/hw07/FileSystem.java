package edu.umb.cs680.hw07;

import java.util.LinkedList;

public class FileSystem  {

    private FileSystem() {};
    private static FileSystem instance = null;

    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    LinkedList<Directory> directory =new LinkedList<Directory>();

    public void addRootDir(Directory dir){
        this.directory.add(dir);
    }

    public LinkedList<Directory> getRootDirs(){
        return this.directory;
    }
}