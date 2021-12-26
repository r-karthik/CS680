package edu.umb.cs680.hw10;

public class ApfsCountingVisitor implements FSVisitor {
    int dirNum = 0;
    int fileNum = 0;
    int linkNum = 0;

    @Override
    public void visit(ApfsDirectory dir) {
        dirNum++;
    }

    @Override
    public void visit(ApfsFile file) {
        fileNum++;
    }

    @Override
    public void visit(ApfsLink link) {
        linkNum++;
    }

    public int getDirNum() {
        return dirNum;
    }

    public int getFileNum() {
        return fileNum;
    }
    public int getLinkNum() {
        return linkNum;
    }

}