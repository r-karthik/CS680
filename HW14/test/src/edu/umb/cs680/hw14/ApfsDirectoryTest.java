package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ApfsDirectoryTest {

    private String[] APFSElementToString(LinkedList<ApfsElement> elements) {
        String[] elems = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            elems[i] = elements.get(i).getName();
        }
        return elems;
    }

    private String[] APFSDirectoryToString(LinkedList<ApfsDirectory> elements) {
        String[] elems = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            elems[i] = elements.get(i).getName();
        }
        return elems;
    }

    private String[] APFSFileToString(LinkedList<ApfsFile> elements) {
        String[] elems = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            elems[i] = elements.get(i).getName();
        }
        return elems;
    }

    private static APFS apfs;
    private static ApfsDirectory root, applications, home, code;
    private static ApfsFile afile, bfile, cfile, dfile, efile, ffile;
    private static ApfsLink x, y;

    @BeforeAll
    public static void setUp() {
        apfs = new APFS("AnhVo");
        apfs.initFileSystem("Local Disk", 1000);
        root = apfs.getRootDir();

        applications = new ApfsDirectory(root, "applications");
        home = new ApfsDirectory(root, "home");
        root.appendChild(applications);
        root.appendChild((home));

        afile = new ApfsFile(applications, "afile", 10);
        bfile = new ApfsFile(applications, "bfile", 10);
        applications.appendChild(afile);
        applications.appendChild(bfile);

        cfile = new ApfsFile(home, "cfile", 10);
        dfile = new ApfsFile(home, "dfile", 10);
        code = new ApfsDirectory(home, "code");
        home.appendChild(cfile);
        home.appendChild(dfile);
        home.appendChild(code);

        efile = new ApfsFile(code, "efile", 10);
        ffile = new ApfsFile(code, "ffile", 10);
        code.appendChild(efile);
        code.appendChild(ffile);

        x = new ApfsLink(home, "x", applications);
        y = new ApfsLink(code, "y", bfile);
        home.appendChild(x);
        code.appendChild(y);

        // Set Modified Time For Test Purpose
        root.setLastModified(LocalDateTime.of(2020, 5, 1, 12, 0));
        home.setLastModified(LocalDateTime.of(2020, 5, 3, 12, 0));
        applications.setLastModified(LocalDateTime.of(2020, 2, 5, 12, 0));
        code.setLastModified(LocalDateTime.of(2020, 5, 2, 12, 0));

        afile.setLastModified(LocalDateTime.of(2020, 5, 5, 12, 0));
        bfile.setLastModified(LocalDateTime.of(2020, 5, 5, 12, 0));
        cfile.setLastModified(LocalDateTime.of(2020, 5, 6, 12, 0));
        dfile.setLastModified(LocalDateTime.of(2020, 5, 3, 12, 0));
        efile.setLastModified(LocalDateTime.of(2020, 5, 5, 12, 0));
        ffile.setLastModified(LocalDateTime.of(2020, 5, 5, 12, 0));

        x.setLastModified(LocalDateTime.of(2020, 5, 4, 12, 0));
        y.setLastModified(LocalDateTime.of(2020, 5, 5, 12, 0));
    }

    @Test
    public void childrootTest() {
        String[] expected = {"applications", "home"};
        LinkedList<ApfsElement> children = root.getChildren();
        String[] actual = APFSElementToString(children);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void subdirrootTest() {
        String[] expected = {"applications", "home"};
        LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories();
        String[] actual = APFSDirectoryToString(subDirectories);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reversealphaTest() {
        String[] expected = {"home", "applications"};
        LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories(Comparator.comparing((ApfsElement element) -> element.getName(), Comparator.reverseOrder()));
        String[] actual = APFSDirectoryToString(subDirectories);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void childhomeTest() {
        String[] expected = {"cfile", "code", "dfile", "x"};
        LinkedList<ApfsElement> children = home.getChildren();
        String[] actual = APFSElementToString(children);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reversealphTest() {
        String[] expected = {"x", "dfile", "code", "cfile"};
        LinkedList<ApfsElement> children = home.getChildren(Comparator.comparing((ApfsElement element) -> element.getName(), Comparator.reverseOrder()));
        String[] actual = APFSElementToString(children);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shomereverseTest() {
        String[] expected = {"dfile", "cfile"};
        LinkedList<ApfsFile> files = home.getFiles(Comparator.comparing(ApfsElement::getName, Comparator.reverseOrder()));
        String[] actual = APFSFileToString((files));
        assertArrayEquals(expected, actual);
    }

    @Test
    void stampbasedTest() {
        String[] expected = {"cfile", "x", "dfile", "code"};
        LinkedList<ApfsElement> children = home.getChildren(Comparator.comparing(ApfsElement::getLastModified, Comparator.reverseOrder()));
        String[] actual = APFSElementToString(children);
        assertArrayEquals(expected, actual);
    }
}