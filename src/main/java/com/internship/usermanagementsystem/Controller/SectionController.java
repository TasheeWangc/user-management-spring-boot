package com.internship.usermanagementsystem.Controller;

import com.internship.usermanagementsystem.Dto.SectionDTO;
import com.internship.usermanagementsystem.Service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
@CrossOrigin("*")
public class SectionController {
    @Autowired
    private SectionService sectionService;
    @PostMapping
    public ResponseEntity<String> addSection(@RequestBody SectionDTO sectionDTO){
        System.out.println(sectionDTO);
        return sectionService.saveSection(sectionDTO);
    }

    @GetMapping
    private ResponseEntity<List<SectionDTO>> getAllSection() {
        return sectionService.findAllSection();
    }

    @GetMapping("/departments/{deptId}")
    public ResponseEntity<List<SectionDTO>> getSectionsByDepartment(@PathVariable Integer deptId) {
        return sectionService.findSectionByDepartmentId(deptId);
    }

    @GetMapping("/{sect_id}")
    private ResponseEntity<SectionDTO> getSectionById(@PathVariable Integer sect_id){
        return sectionService.findSectionById(sect_id);
    }

    @DeleteMapping("/{sect_id}")
    private ResponseEntity<String> deleteService(@PathVariable Integer sect_id){
        return sectionService.deleteSection(sect_id);
    }
}
