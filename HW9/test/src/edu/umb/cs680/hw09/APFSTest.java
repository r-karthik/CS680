package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class APFSTest {
    APFS apfs = new APFS();
    private String name = "home";
    private int capacity = 3000;

    @Test
    public void Oneapfstest() {
        APFS apfsone = APFS.getInstance();
        APFS apfstwo = APFS.getInstance();
        assertEquals(apfsone.hashCode(), (apfstwo.hashCode()));
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
        int expected = 3000;
        assertEquals(actual, (expected));
    }


}