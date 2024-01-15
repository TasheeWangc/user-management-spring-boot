package com.internship.usermanagementsystem.Service;

import com.internship.usermanagementsystem.Dto.DepartmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface DepartmentService {
// List all Department
    ResponseEntity<List<DepartmentDTO>> findAllDepartment();

// // Find Department By id
    ResponseEntity<DepartmentDTO> findDepartmentById(Integer dept_id);

// Save Department
    ResponseEntity<String> saveDepartment(DepartmentDTO departmentDTO, MultipartFile departmentImageFile);

//     void delete(int dept_id);
    ResponseEntity<String> deleteDepartment(Integer dept_id);
    
    ResponseEntity<Long> findTotalDepartmentCount();

    
}
