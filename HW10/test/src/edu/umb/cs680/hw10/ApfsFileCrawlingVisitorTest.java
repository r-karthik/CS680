package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.ArrayList;

public class ApfsFileCrawlingVisitorTest {

    APFS fs = APFS.getInstance();
    static Date d2 = new Date();
    static Date m2 = new Date();
    ApfsDirectory root;
    ApfsFileCrawlingVisitor visitor;

    @Test
    public void Test1files() {
        ApfsDirectory root = new ApfsDirectory(null, "RootDir", 0, d2, "Azamk", m2);
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, d2, "Azamk", m2);
        ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, d2, "Azamk", m2);
        ApfsFile f1 = new ApfsFile(pictures, "OOP1", 2000, d2, "Azamk", m2);
        ApfsFile f2 = new ApfsFile(pictures, "OOP2", 5000, d2, "Azamk", m2);
        fs.setRoot(root);
        fs.AddChild(root, home);
        fs.AddChild(home, pictures);
        fs.AddChild(pictures, f1);
        fs.AddChild(pictures, f2);
        ApfsLink a = new ApfsLink(home, "a", 0, d2, "Azamk", m2, f1);
        ApfsLink b = new ApfsLink(pictures, "b", 0, d2, "Azamk", m2, a);
        fs.AddChild(home, a);
        fs.AddChild(pictures, b);

        visitor = new ApfsFileCrawlingVisitor("OP");
        root.accept(visitor);

        int actual = visitor.getFiles().size();
        int expected = 2;
        assertEquals(actual, expected);

    }

    @Test
    public void Test2files() {
        ApfsDirectory root = new ApfsDirectory(null, "RootDir", 0, d2, "Azamk", m2);
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, d2, "Azamk", m2);
        ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, d2, "Azamk", m2);
        ApfsFile f1 = new ApfsFile(pictures, "OOP", 2038, d2, "Azamk", m2);
        ApfsFile f2 = new ApfsFile(pictures, "jsx", 5000, d2, "Azamk", m2);
        fs.setRoot(root);
        fs.AddChild(root, home);
        fs.AddChild(home, pictures);
        fs.AddChild(pictures, f1);
        fs.AddChild(pictures, f2);
        ApfsLink a = new ApfsLink(home, "a", 0, d2, "Azamk", m2, f1);
        ApfsLink b = new ApfsLink(pictures, "b", 0, d2, "Azamk", m2, a);
        fs.AddChild(home, a);
        fs.AddChild(pictures, b);

        visitor = new ApfsFileCrawlingVisitor("OP");
        root.accept(visitor);

        String actual = visitor.getFiles().get(0).getName();
        String expected = "OOP";
        assertEquals(actual, expected);

    }

}