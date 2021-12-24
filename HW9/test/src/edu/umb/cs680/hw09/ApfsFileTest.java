package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;


public class ApfsFileTest {

    FileSystem fs = FileSystem.getInstance();
    static Date d2 = new Date();
    static Date m2 = new Date();

    private String[] dirToStringArray(ApfsFile f){
        String[] dirInfo = {
                String.valueOf(f.isLeaf()),
                f.getName(),
                f.getParent().getName(),
                String.valueOf(f.getSize())
        };
        return dirInfo;
    }


    @Test
    public void testFile() {
        String[] expected = {"true", "CS680", "pictures", "2018"};
        ApfsDirectory root = new ApfsDirectory(null, "RootDir", 0, d2, "Azamk", m2);
        ApfsDirectory system = new ApfsDirectory(root, "system", 0, d2, "Azamk", m2);
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, d2, "Azamk", m2);
        ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, d2, "Azamk", m2);
        ApfsFile actual = new ApfsFile(pictures, "CS680", 2018, d2, "Azamk", m2);
        fs.setRoot(root);
        fs.AddChild(root, home);
        fs.AddChild(root, system);
        fs.AddChild(home, pictures);
        fs.AddChild(pictures, actual);
        assertArrayEquals(expected, dirToStringArray(actual) );

    }

}