package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class File  extends FSElement {

    public File(Directory parent, String name, int size, LocalDateTime creationtime) {
        super(parent, name, size, creationtime);
        if(parent!=null){
            parent.appendFile(this);}
    }

}