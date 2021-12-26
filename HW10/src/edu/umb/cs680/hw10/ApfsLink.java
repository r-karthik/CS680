package edu.umb.cs680.hw10;

import java.util.Date;

public class ApfsLink extends ApfsElement {
    static Date d2 = new Date();
    static Date m2 = new Date();
    private String name;
    private String owner;

    ApfsElement target;
    public ApfsElement getTarget() {
        return target;
    }

    public ApfsLink(ApfsDirectory parent, String name, int size, Date created, String owner, Date lastModified, ApfsElement target)
    {
        super(parent, name, size, d2, owner, m2);
        this.name = name;
        this.owner = owner;
        this.target = target;
    }
    public int getSize(){
        return 0;
    }

    public int getTargetSize(){
        return target.getSize();
    }

    @Override
    public boolean isLink(){
        return true;
    }

    public String getName(){
        return this.name + " (Link)";
    }

    public String getTargetName(){
        return target.getName();
    }

    public void accept(FSVisitor v) {
        v.visit(this);
    }
}