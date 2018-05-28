package com.my.projects.Models;

public class Employee {
  private String firstName;
  private String lastName;
  private int employeeId;
  private String jobTitle;
  private String department;
  private double yearlySalary;
  
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public int getEmployeeId() {
    return employeeId;
  }
  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }
  public String getJobTitle() {
    return jobTitle;
  }
  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }
  public String getDepartment() {
    return department;
  }
  public void setDepartment(String department) {
    this.department = department;
  }
  public double getYearlySalary() {
    return yearlySalary;
  }
  public void setYearlySalary(double yearlySalary) {
    this.yearlySalary = yearlySalary;
  }

  
  public String toString() {
    return firstName + " " + lastName +", employeeId: " + employeeId +", jobTitle: " + jobTitle
        + ", department: " + department + ", yearlySalary: $" + yearlySalary;
  }
}
