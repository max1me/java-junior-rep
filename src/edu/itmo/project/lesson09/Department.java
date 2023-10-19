package edu.itmo.project.lesson09;

public class Department {
    private String name;
    private int numberOfWorkers;
    private Department headDepartment;

    public String getName() {
        return name;
    }

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public Department getHeadDepartment() {
        return headDepartment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public void setHeadDepartment(Department headDepartment) {
        this.headDepartment = headDepartment;
    }

    Department(){
    }
}
