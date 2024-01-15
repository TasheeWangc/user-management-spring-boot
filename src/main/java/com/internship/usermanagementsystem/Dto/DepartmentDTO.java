package com.internship.usermanagementsystem.Dto;

import com.internship.usermanagementsystem.Model.DepartmentImage;
import lombok.Data;

@Data
public class DepartmentDTO {
    private int deptId;
    private String deptName;
    private String deptDescription;
    private DepartmentImage departmentImage;
}
