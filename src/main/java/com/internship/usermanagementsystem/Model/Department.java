package com.internship.usermanagementsystem.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "department")
public class Department {
    // Define Field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Dept_Id") // Optional
    private int deptId;

    @Column(name = "Dept_Name")
    private String deptName;

    @Column(name = "Dept_Description")
    private String deptDescription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Dept_Profile_Id")
    private DepartmentImage departmentImage;
}
