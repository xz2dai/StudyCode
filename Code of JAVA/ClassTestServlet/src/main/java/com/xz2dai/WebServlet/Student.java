package com.xz2dai.WebServlet;

public class Student {
    private String sno;
    private String name;
    public Student(String sno, String name){
        this.sno = sno;
        this.name= name;
    }
    public void setSno(String sno){
        this.sno = sno;
    }
    public String getSno(){
        return this.sno;
    }
    public void setSname(String sname){
        this.name = sname;
    }
    public String getSname(){
        return this.name;
    }
}
