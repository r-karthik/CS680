package edu.umb.cs680.hw14;

public abstract class FileSystem {
    protected String name;
    protected int capacity;
    protected int id;
    public FSElement rootDir = null;

    public FSElement initFileSystem(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();
        if (root.isDirectory() && capacity >= root.getSize()) {
            setRoot(root);
            this.id = root.hashCode();
            return root;
        } else {
            return null;
        }
    }

    private void setRoot(FSElement root) {
        rootDir = root;
    }

    public FSElement getRoot() {
        return rootDir;
    }

    protected abstract FSElement createDefaultRoot();
}