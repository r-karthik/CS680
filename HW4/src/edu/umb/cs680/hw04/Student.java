package edu.umb.cs680.hw04;

enum StudentStatus{
    INSTATE,
    OUTSTATE,
    INTL;
}

public class Student {
    float tuition;
    String name;
    int i20num;
    String usAddr;
    int yrsInState;
    String foriegnAddr;
    private StudentStatus status = null;

    private Student(float tuition, String name, int i20num, String usAddr, int yrsInState,
                    String foriegnAddr, StudentStatus status)
    {
        this.tuition=tuition;
        this.name=name;
        this.i20num=i20num;
        this.usAddr=usAddr;
        this.yrsInState=yrsInState;
        this.foriegnAddr=foriegnAddr;
        this.status=status;
    }

    public static Student createInStateStudent(String name, String usAddr){
        return new Student(0,name,0,usAddr,0,null,StudentStatus.INSTATE);

    }

    public static Student createOutStateStudent(String name, String usAddr,int yrsInState) {
        return new Student(0,name,0,usAddr,yrsInState,null,StudentStatus.OUTSTATE);
    }

    public static Student createIntlStudent(String name, String usAddr,int i20num,String foriegnAddr) {
        return new Student(0,name,i20num,usAddr,0,foriegnAddr,StudentStatus.INTL);
    }

    public float getTuition() {
        return this.tuition;
    }

    public String getName() {
        return this.name;
    }

    public int getI20num() {
        return this.i20num;
    }

    public String getUsAddr() {
        return this.usAddr;
    }

    public int getYrsInState() {
        return this.yrsInState;
    }

    public String getForiegnAddr() {
        return this.foriegnAddr;
    }

    public StudentStatus getStatus() {
        return this.status;
    }

    public static void main (String[] args) {
        Student s = createInStateStudent("Karthik", "Dorchester");
    }
}