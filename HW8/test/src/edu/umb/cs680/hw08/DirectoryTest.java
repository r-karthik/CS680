package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.format.DateTimeFormatter;

public class DirectoryTest {
    public static String[] dirToStringArray(Link L){

        String LinkInfo[] = {
                Boolean.toString(L.isLink()), L.getName(), Integer.toString(L.getSize()), L.getTime(), L.getTarget().getName(), Integer.toString(L.getTargetSize()), Integer.toString(L.getTarget().getSize())};

        for(int i=0;i<LinkInfo.length;i++)
        {
            System.out.println(LinkInfo[i]);
        }
        return LinkInfo;
    }

    LocalDateTime creationTime=LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:MM");
    String time=creationTime.format(formatter);

    LocalDateTime creationTime1=LocalDateTime.now();
    Directory root=new Directory(null,"Root",0,creationTime );


    LocalDateTime creationTime2=LocalDateTime.now();
    Directory home=new Directory(root,"home",0,creationTime1 );
    Directory system=new Directory(root,"system",0,creationTime1 );
    Directory pictures=new Directory(home,"pictures",0,creationTime1 );
    File fileA=new File(home,"file:a",1,creationTime2 );
    File fileB=new File(system,"file:b",1,creationTime2 );
    File fileC=new File(system,"file:c",1,creationTime2 );
    File fileD=new File(system,"file:d",1,creationTime2 );
    File fileE=new File(pictures,"file:e",1,creationTime2 );
    File fileF=new File(pictures,"file:f",1,creationTime2 );
    Link y=new Link(home,"link:y",0,creationTime1,system);
    Link z=new Link(pictures,"link:z",0,creationTime1,fileE);
    Link x=new Link(pictures,"link:x",0,creationTime1,fileF);


    @Test
    public void verifyDirectoryEqualityLinky() {
        String[] expected={"true","link:y","0",time,"system","3","3"};
        assertArrayEquals(expected,dirToStringArray(y));
    }

    @Test
    public void verifyDirectoryEqualityLinkz() {
        String[] expected={"true","link:z","0",time,"file:e","1","1"};
        assertArrayEquals(expected,dirToStringArray(z));
    }

}
