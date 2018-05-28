package com.my.projects.Models;

public class Project {
  private String projectName;
  private int managerId;
  private double yearlyBudget;
  private boolean stillActive;
  
  
  public String getProjectName() {
    return projectName;
  }
  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }
  public int getManagerId() {
    return managerId;
  }
  public void setManagerId(int managerId) {
    this.managerId = managerId;
  }
  public double getYearlyBudget() {
    return yearlyBudget;
  }
  public void setYearlyBudget(double yearlyBudget) {
    this.yearlyBudget = yearlyBudget;
  }
  public boolean isStillActive() {
    return stillActive;
  }
  public void setStillActive(boolean stillActive) {
    this.stillActive = stillActive;
  }
  
  public String toString() {
    return projectName + ", managerId: " + managerId 
        + ", yearlyBudget: " + yearlyBudget + ", stillActive: " + stillActive;
  }
}
