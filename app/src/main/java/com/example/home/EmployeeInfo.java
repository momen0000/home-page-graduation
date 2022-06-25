package com.example.home;
public class EmployeeInfo  {


    private String employeeEmail;
    private String employeeFName;
    private String employeeMName;
    private String employeeLName;
    // string variable for storing
// employee contact number
    private int employeeContactNumber;

    // string variable for storing
// employee address.
    private String employeeAddress;

    // an empty constructor is
// required when using
// Firebase Realtime Database.
    public  EmployeeInfo() {

    }

    // created getter and setter methods
// for all our variables.
    public String getEmployeeFName() {
        return employeeFName;
    }

    public void setEmployeeFName(String employeeFName) {
        this.employeeFName = employeeFName;
    }

    public String getEmployeeMName() {
        return employeeMName;
    }

    public void setEmployeeMName(String employeeMName) {
        this.employeeMName = employeeMName;
    }

    public String getEmployeeLName() {
        return employeeLName;
    }

    public void setEmployeeLName(String employeeLName) {
        this.employeeLName = employeeLName;
    }


    public int getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public void setEmployeeContactNumber(int employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }


    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
}