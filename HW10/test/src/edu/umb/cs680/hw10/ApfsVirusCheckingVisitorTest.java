package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.ArrayList;

public class ApfsVirusCheckingVisitorTest {

    APFS fs = APFS.getInstance();
    static Date d2 = new Date();
    static Date m2 = new Date();
    ApfsDirectory root;
    ApfsVirusCheckingVisitor visitor;

    @Test
    public void getFilesTest1() {
        ApfsDirectory root = new ApfsDirectory(null, "RootDir", 0, d2, "Azamk", m2);
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, d2, "Azamk", m2);
        ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, d2, "Azamk", m2);
        ApfsFile f1 = new ApfsFile(pictures, "CS680", 2010, d2, "Azamk", m2);
        fs.setRoot(root);
        fs.AddChild(root, home);
        fs.AddChild(home, pictures);
        fs.AddChild(pictures, f1);
        ApfsLink a = new ApfsLink(home, "a", 0, d2, "Azamk", m2, f1);
        ApfsLink b = new ApfsLink(pictures, "b", 0, d2, "Azamk", m2, a);
        fs.AddChild(home, a);
        fs.AddChild(pictures, b);

        visitor = new ApfsVirusCheckingVisitor();
        root.accept(visitor);

        int actual = visitor.getQuarantinedNum();
        int expected = 0;
        assertEquals(actual, expected);

    }

    @Test
    public void getFilesTest2() {
        ApfsDirectory root = new ApfsDirectory(null, "RootDir", 0, d2, "Azamk", m2);
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, d2, "Azamk", m2);
        ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, d2, "Azamk", m2);
        ApfsFile f1 = new ApfsFile(pictures, "virus", 7689, d2, "Azamk", m2);
        fs.setRoot(root);
        fs.AddChild(root, home);
        fs.AddChild(home, pictures);
        fs.AddChild(pictures, f1);
        ApfsLink a = new ApfsLink(home, "a", 0, d2, "Azamk", m2, f1);
        ApfsLink b = new ApfsLink(pictures, "b", 0, d2, "Azamk", m2, a);
        fs.AddChild(home, a);
        fs.AddChild(pictures, b);

        visitor = new ApfsVirusCheckingVisitor();
        root.accept(visitor);

        int actual = visitor.getQuarantinedNum();
        int expected = 1;
        assertEquals(actual, expected);

    }
}