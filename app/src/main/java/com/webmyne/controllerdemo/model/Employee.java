package com.webmyne.controllerdemo.model;

/**
 * Created by chiragpatel on 29-05-2017.
 */

public class Employee {
    private int id;
    private String name;
    private String gender;
    private String email;
    private String mobile;
    private String salary;
    private String tax;
    private String address;
    private String department;

    public Employee(String name, String gender, String email, String mobile, String salary, String tax, String address, String department) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.salary = salary;
        this.tax = tax;
        this.address = address;
        this.department = department;
    }

    public Employee(int id, String name, String gender, String email, String mobile, String salary, String tax, String address, String department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.salary = salary;
        this.tax = tax;
        this.address = address;
        this.department = department;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
