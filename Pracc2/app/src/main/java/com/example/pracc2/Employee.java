package com.example.pracc2;

public class Employee {
    private String id, name, birthday;
    private String salary;

    public Employee(String birthday, String id, String name,String salary) {
        this.birthday = birthday;
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
