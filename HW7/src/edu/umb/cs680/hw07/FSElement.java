package edu.umb.cs680.hw07;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FSElement {
    private String name;
    private int size;
    private static LocalDateTime creationtime;
    private Directory parent;
    LocalDateTime now=LocalDateTime.now();
    FSElement(Directory parent, String name, int size, LocalDateTime creationtime) {
        this.parent=parent;
        this.name=name;
        this.size=size;
        FSElement.creationtime=creationtime;
        if(parent!=null){
            parent.appendChild(this);
        }
    }

    public Directory getparent(){
        return this.parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getTime() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:MM");
        String time=creationtime.format(formatter);
        return time;
    }

    public int getSize() {
        FSElement dir= this;
        if(dir.isFile()==true) {
            return size;
        }
        else{
            Directory dirs = (Directory) dir;
            int z = dirs.getFiles().size();
            for(int i=0; i<dirs.getSubDirectories().size(); i++){
                z += dirs.getSubDirectories().get(i).getFiles().size();
            }
            this.size=z;
            return size;
        }
    }

    public boolean isFile() {
        if(this instanceof File){
            return true;
        }
        else{
            return false;
        }
    }
}