package com.example.studentdb.model;

public class Student {
    int id;
    String name;
    String course;
    String mobile;
    int totalfee;
    int feepaid ;

    public Student(int id, String name, String course, String mobile, int totalfee, int feepaid) {
        this.id = this.id;
        this.name = name;
        this.course = course;
        this.mobile = mobile;
        this.totalfee = totalfee;
        this.feepaid = feepaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(int totalfee) {
        this.totalfee = totalfee;
    }

    public int getFeepaid() {
        return feepaid;
    }

    public void setFeepaid(int feepaid) {
        this.feepaid = feepaid;
    }
}
