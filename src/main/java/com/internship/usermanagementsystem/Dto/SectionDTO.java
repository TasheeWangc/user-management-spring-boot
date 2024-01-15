package com.internship.usermanagementsystem.Dto;

import com.internship.usermanagementsystem.Model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionDTO {
    private int sectId;
    private String sectName;
    private Department department;
}
