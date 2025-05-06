package com.priyanka;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jdk.internal.vm.annotation.Stable;

@Entity
@Table(name="student_info")
public class Student {

int id;
String name;
String place;

    public Student() {

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Student(int id, String name, String place) {
        this.id = id;
        this.name = name;
        this.place = place;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
