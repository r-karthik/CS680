package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;

class ReverseAlphabeticalComparatorTest {

    LocalDateTime date = LocalDateTime.now();
    APFS getInstance = APFS.getInstance();
    ApfsDirectory root = (ApfsDirectory) getInstance.initFileSystem("APFSDirectory", 2);
    ApfsDirectory home = new ApfsDirectory( "home", 0, date,root,"APFS",date);
    ApfsDirectory code = new ApfsDirectory( "code", 0, date,home,"APFS",date);
    ApfsDirectory applications = new ApfsDirectory( "applications", 0, date,root,"APFS",date);
    ApfsFile afile = new ApfsFile( "afile", 50, date,applications,"APFS",date);
    ApfsFile bfile = new ApfsFile( "bfile", 250, date,applications,"APFS",date);
    ApfsFile cfile = new ApfsFile( "cfile", 70, date,home,"APFS",date);
    ApfsFile dfile = new ApfsFile( "dfile", 100, date,home,"APFS",date);
    ApfsFile efile = new ApfsFile( "efile", 500, date,code,"APFS",date);
    ApfsFile ffile = new ApfsFile( "ffile", 650, date,code,"APFS",date);
    ApfsLink xfile = new ApfsLink("xfile",700, date, home,"APFS",date,applications);
    ApfsLink yfile = new ApfsLink("yfile",110,date,code,"APFS",date,efile);

    @Test
    public void verify_getChildren() {
        ApfsElement[] expected = { home,applications};
        ApfsDirectory directory = root;
        List<ApfsElement> element = directory.getChildren(new ReverseAlphabeticalComparator());
        assertArrayEquals(expected,element.toArray() );
    }

    @Test
    public void verify_getSubDirectories() {
        ApfsDirectory[] expected = { home,applications};
        ApfsDirectory directory = root;
        List<ApfsDirectory> element = directory.getSubDirectories(new ReverseAlphabeticalComparator());
        assertArrayEquals(expected,element.toArray() );
    }

    @Test
    public void verify_getFiles() {
        ApfsFile[] expected = { ffile,efile};
        ApfsDirectory directory = code;
        List<ApfsFile> element = directory.getFiles(new ReverseAlphabeticalComparator());
        assertArrayEquals(expected,element.toArray());
    }
    @Test
    public void verify_getChildrenHome() {
        ApfsElement[] expected = {xfile,dfile,code,cfile};
        ApfsDirectory directory = home;
        List<ApfsElement> element = directory.getChildren(new ReverseAlphabeticalComparator());
        assertArrayEquals(expected,element.toArray() );
    }

}