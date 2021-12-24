package edu.umb.cs680.hw09;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FileSystemTest {


    @Test
    public void Roottest() {
        FileSystem fSystem = FileSystem.getInstance();
        ApfsDirectory root = fSystem.getRootDir();
        ApfsDirectory expected = root.getParent();
        ApfsDirectory actual = null;
        assertEquals(actual, (expected));
    }

    @Test
    public void fstest() {
        FileSystem fSystem2 = FileSystem.getInstance();
        assertEquals(fSystem2.hashCode(), (fSystem2.hashCode()));
    }

}