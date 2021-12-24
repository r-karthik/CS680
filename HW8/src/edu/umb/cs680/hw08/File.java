package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class File  extends FsElement {

    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        if(parent!=null){
            parent.addFile(this);}
    }

}