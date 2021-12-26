package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class ApfsCountingVisitorTest {

    APFS fs = APFS.getInstance();
    static Date d2 = new Date();
    static Date m2 = new Date();
    ApfsDirectory root;
    ApfsCountingVisitor visitor;

    @Test
    public void DirecNumbertest() {

        ApfsDirectory root = new ApfsDirectory(null, "RootDir", 0, d2, "Azamk", m2);
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, d2, "Azamk", m2);
        ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, d2, "Azamk", m2);
        fs.setRoot(root);
        fs.AddChild(root, home);
        fs.AddChild(home, pictures);
        visitor = new ApfsCountingVisitor();
        root.accept(visitor);
        int expected = 3;
        int actual = visitor.getDirNum();
        assertEquals(actual, expected);
    }

    @Test
    public void Filenumber() {
        ApfsDirectory root = new ApfsDirectory(null, "RootDir", 0, d2, "Azamk", m2);
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, d2, "Azamk", m2);
        ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, d2, "Azamk", m2);
        ApfsFile f1 = new ApfsFile(pictures, "OOP", 2000, d2, "Azamk", m2);
        fs.setRoot(root);
        fs.AddChild(root, home);
        fs.AddChild(home, pictures);
        fs.AddChild(pictures, f1);
        ApfsLink a = new ApfsLink(home, "a", 0, d2, "Azamk", m2, f1);
        ApfsLink b = new ApfsLink(pictures, "b", 0, d2, "Azamk", m2, a);

        visitor = new ApfsCountingVisitor();
        root.accept(visitor);
        int expected = 1;
        int actual = visitor.getFileNum();
        assertEquals(actual, expected);
    }

    @Test
    public void Linknumber() {
        ApfsDirectory root = new ApfsDirectory(null, "RootDir", 0, d2, "Azamk", m2);
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, d2, "Azamk", m2);
        ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, d2, "Azamk", m2);
        ApfsFile f1 = new ApfsFile(pictures, "OOP", 2000, d2, "Azamk", m2);
        fs.setRoot(root);
        fs.AddChild(root, home);
        fs.AddChild(home, pictures);
        fs.AddChild(pictures, f1);
        ApfsLink a = new ApfsLink(home, "a", 0, d2, "Azamk", m2, f1);
        ApfsLink b = new ApfsLink(pictures, "b", 0, d2, "Azamk", m2, a);
        fs.AddChild(home, a);
        fs.AddChild(pictures, b);

        visitor = new ApfsCountingVisitor();
        root.accept(visitor);
        int expected = 2;
        int actual = visitor.getLinkNum();
        assertEquals(actual, expected);
    }

}