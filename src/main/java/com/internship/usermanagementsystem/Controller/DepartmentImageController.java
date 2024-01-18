package com.internship.usermanagementsystem.Controller;

import com.internship.usermanagementsystem.Service.DepartmentImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/department_images")
@CrossOrigin("*")
public class DepartmentImageController {

    @Autowired
    private DepartmentImageService departmentImageService;

    @PostMapping("/{dept_id}")
    private ResponseEntity<String> uploadProfile(
            @RequestPart(name = "profileImageFile", required = true) MultipartFile profileImageFile, @PathVariable Integer dept_id){
        return departmentImageService.uploadImage(Integer.valueOf(dept_id), profileImageFile);
    }

    @GetMapping("/{dept_id}")
    private ResponseEntity<byte[]> getProfileImage(@PathVariable Integer dept_id){
        return departmentImageService.getProfileImage(dept_id);
    }
}
