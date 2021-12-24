package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class ApfsLinkTest {
    FileSystem fs = FileSystem.getInstance();
    static Date d2 = new Date();
    static Date m2 = new Date();
    ApfsDirectory root;
    ApfsLink a,b,c,d;

    private String[] dirToStringArray(ApfsLink l){
        String[] dirInfo = {
                String.valueOf(l.isLink()), l.getName(),
                l.getParent().getName(),
                l.getTargetName(),
                String.valueOf(l.getTargetSize())
        };
        return dirInfo;
    }
    @Test
    public void test_ApfsLinkTargetSizeName() {
        root = new ApfsDirectory(null, "RootDir", 0, d2, "Azamk", m2);
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, d2, "Azamk", m2);
        ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, d2, "Azamk", m2);
        ApfsFile f1 = new ApfsFile(pictures, "CS680", 2018, d2, "Azamk", m2);
        fs.setRoot(root);
        fs.AddChild(root, home);
        fs.AddChild(home, pictures);
        fs.AddChild(pictures, f1);

        a = new ApfsLink(home, "a", 0, d2, "Azamk", m2, f1);

        String[] expected = {"true", "a (Link)", "home", "CS680", "2018"};
        assertArrayEquals(expected, dirToStringArray(a) );
    }

}