package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void createOutStateStudentTest() {
        StudentStatus expected_status = StudentStatus.OUTSTATE;
        Student student =  Student.createOutStateStudent("Karthik", "UMB", 500);
        assertEquals(expected_status, student.getStatus());
    }

    @Test
    void createInStateStudentTest() {
        StudentStatus expected_status = StudentStatus.INSTATE;
        Student student =  Student.createInStateStudent("Karthik", "UMB");
        assertEquals(expected_status, student.getStatus());

    }

    @Test
    void createIntlStudentTest() {
        StudentStatus expected_status = StudentStatus.INTL;
        Student student =  Student.createIntlStudent("Karthik", "UMB", 415,"Vizag");
        assertEquals(expected_status, student.getStatus());
    }
}