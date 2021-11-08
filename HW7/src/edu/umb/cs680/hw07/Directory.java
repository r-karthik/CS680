package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{

    public Directory(Directory parent, String name, int size, LocalDateTime creationtime) {
        super(parent, name, size, creationtime);
        if(parent!=null){
            parent.appendSubDirectory(this);
        }

    }

    LinkedList<FSElement> children = new LinkedList<FSElement>();
    LinkedList<Directory> directory = new LinkedList<Directory>();
    LinkedList<File> file = new LinkedList<File>();

    public LinkedList<FSElement> getChildren(){
        return this.children;
    }

    public void appendChild(FSElement child ){
        this.children.add(child);
    }

    public int countChildren(){
        return children.size();
    }

    public void  appendSubDirectory(Directory subd){
        this.directory.add(subd);
    }

    public LinkedList<Directory> getSubDirectories(){
        return this.directory;
    }

    public void appendFile(File f){
        this.file.add(f);
    }

    public LinkedList<File> getFiles(){
        return this.file;
    }

    public int getTotalsize(){
        FSElement dir = this;
        Directory dirs = (Directory) dir;
        int size = 0;
        for(int i=0;i<dirs.getChildren().size();i++){
            size += dirs.getChildren().get(i).getSize();
        }
        return size;
    }

}
