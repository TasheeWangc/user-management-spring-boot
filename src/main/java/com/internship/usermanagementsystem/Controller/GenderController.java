package com.internship.usermanagementsystem.Controller;

import com.internship.usermanagementsystem.Dto.GenderDTO;
import com.internship.usermanagementsystem.Service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genders")
public class GenderController {
    // Define request and response endpoint
    @Autowired
    private GenderService genderService;

    // Adding Gender
    @PostMapping
    private ResponseEntity<String> addGender(@RequestBody GenderDTO genderDTO){
        return genderService.saveGender(genderDTO);

    }

    // Get All Gender
    @GetMapping
    private ResponseEntity<List<GenderDTO>> getAllGender() {
        return genderService.findAllGender();
    }

    // Retrieve Single Gender By Id
    @GetMapping("/{gender_id}")
    private ResponseEntity<GenderDTO> getDepartmentById(@PathVariable Integer gender_id){
        return genderService.findGenderById(gender_id);

    }

    // Updating the Gender
    @PutMapping
    private ResponseEntity<String> updateDepartment(@RequestBody GenderDTO genderDTO){
        return genderService.saveGender(genderDTO);
    }

    // Deleting the Gender
    @DeleteMapping("/{gender_id}")
    private ResponseEntity<String> deleteDepartment(@PathVariable Integer gender_id){
        return genderService.deleteGender(gender_id);
    }

}
