package com.manish.kafkalistener.batchProcessing.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    private String Id;
    private String name;
    private String designation;

    public Employee() {
    }

    public Employee(String id, String name, String designation) {
        Id = id;
        this.name = name;
        this.designation = designation;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(Id, employee.Id) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(designation, employee.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, designation);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
