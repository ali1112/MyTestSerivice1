package com.my.projects.JsonOps;

import org.codehaus.jackson.map.ObjectMapper;

import com.my.projects.Models.Employee;
import com.my.projects.Models.Project;

public class JsonOps {
  public static ObjectMapper mapper = new ObjectMapper();
  
  public static <T> String objectToJson(T obj) {
    String jsonString = "";
    
    try {
      jsonString = mapper.writeValueAsString(obj);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return jsonString;
  }
  
  public static <T> T jsonToObject(String jsonString, Class<T> clazz) {
    T obj = null;
    try {
      obj = mapper.readValue(jsonString, clazz);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return obj;
  }
  
  public static void main(String [] args) {
    String employeeString = "{\"firstName\":\"George\",\"lastName\":\"Johnson\",\"employeeId\":8389293,\"jobTitle\":\"Software Developer\",\"department\":\"Product Development\",\"yearlySalary\":120000.0}";
    String projectString = "{\"projectName\":\"New $1 million project!!!\",\"managerId\":8389293,\"yearlyBudget\":200000.0,\"stillActive\":false}";
    
    Employee employeeFromString = jsonToObject(employeeString, Employee.class);
    System.out.println("Employee from Json:");
    System.out.println(employeeFromString);
    
    Project projectFromString = jsonToObject(projectString, Project.class);
    System.out.println("\nProject from Json:");
    System.out.println(projectFromString);
    
    
    Employee employee = new Employee();
    employee.setDepartment("Management");
    employee.setFirstName("Bill");
    employee.setLastName("Howard");
    employee.setEmployeeId(0001);
    employee.setYearlySalary(1200000.00);
    employee.setJobTitle("Project Lead");
    
    String jsonString = objectToJson(employee);
    System.out.println("\nJsonString of Employee:");
    System.out.println(jsonString);
    
    Project project = new Project();
    project.setManagerId(0001);
    project.setProjectName("Better $2 million project!!!");
    project.setStillActive(true);
    project.setYearlyBudget(400000.00);
    
    jsonString = objectToJson(project);
    System.out.println("\nJsonString of Project:");
    System.out.println(jsonString);
  }
}
