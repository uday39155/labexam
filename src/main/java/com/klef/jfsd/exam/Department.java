package com.klef.jfsd.exam;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int departmentId;

    @Column(name = "dept_name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "hod_name")
    private String hodName;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }
}
