package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class APFSTest {
    APFS apfs = new APFS();
    private String name = "home";
    private int capacity = 1000;

    @Test
    public void Oneapfstest() {
        APFS apfs1 = APFS.getInstance();
        APFS apfs2 = APFS.getInstance();
        assertEquals(apfs1.hashCode(), (apfs2.hashCode()));
    }

    @Test
    public void oneroottest() {
        apfs.initFileSystem(name, capacity);
        APFS apfs = APFS.getInstance();
        ApfsDirectory root = apfs.getRootDir();
        ApfsDirectory expected = root.getParent();
        ApfsDirectory actual = null;
        assertEquals(actual, (expected));
    }

    @Test
    public void CapacityTest() {
        apfs.initFileSystem(name, capacity);
        int actual = apfs.getCapacity();
        int expected = 1000;
        assertEquals(actual, (expected));
    }


}