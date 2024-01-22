package com.internship.usermanagementsystem.Controller;

import com.internship.usermanagementsystem.Dto.DepartmentDTO;
import com.internship.usermanagementsystem.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
// @RequestMapping("v1/api")
@RequestMapping("/departments")
public class DepartmentController {
// Define request and response endpoint
    @Autowired
    private DepartmentService departmentService;

// Adding Department
    @PostMapping
    private ResponseEntity<String> addDepartment(
        @RequestPart(name = "department", required = true) DepartmentDTO departmentDTO,
        @RequestPart(name = "departmentImage", required = false) MultipartFile departmentImage){
        return departmentService.saveDepartment(departmentDTO, departmentImage);

    }

// Get All Department
    @GetMapping
    private ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return departmentService.findAllDepartment();
    }
    
 // Get All Department
    @GetMapping("/total")
    private ResponseEntity<Long> getDepartmentCount() {
        return departmentService.findTotalDepartmentCount();
    }
    

// Retrieve Single Department By id
    @GetMapping("/{dept_id}")
    private ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Integer dept_id){
        return departmentService.findDepartmentById(dept_id);

    }

// Updating the department
    @PutMapping
    private ResponseEntity<String> updateDepartment(
        @RequestPart(name = "department", required = true) DepartmentDTO departmentDTO,
        @RequestPart(name = "departmentImage", required = false) MultipartFile departmentImage){
        return departmentService.saveDepartment(departmentDTO, departmentImage);

    }

// Deleting the department
    @DeleteMapping("/{dept_id}")
    private ResponseEntity<String> deleteDepartment(@PathVariable Integer dept_id){
        return departmentService.deleteDepartment(dept_id);
    }

}
