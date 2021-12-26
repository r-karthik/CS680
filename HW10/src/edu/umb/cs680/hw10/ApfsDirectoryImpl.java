package edu.umb.cs680.hw10;

import java.util.Date;

public class ApfsDirectoryImpl extends ApfsDirectory {
    public ApfsDirectoryImpl(ApfsDirectory parent, String name, int size, Date created, String owner, Date lastModified) {
        super(parent, name, size, created, owner, lastModified);
    }
}
