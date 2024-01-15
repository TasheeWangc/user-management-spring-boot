package com.internship.usermanagementsystem.Service;

import com.internship.usermanagementsystem.Dto.SectionDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SectionService {
    /* List all Section */
    ResponseEntity<List<SectionDTO>> findAllSection();
    /* Find Section by ID */
    ResponseEntity<SectionDTO> findSectionById(Integer sect_id);
    /* Save or Update Sectino */
    ResponseEntity<String> saveSection(SectionDTO sectionDTO);
    /* Delete Section */
    ResponseEntity<String> deleteSection(Integer sect_id);
    
   ResponseEntity<List<SectionDTO>> findSectionByDepartmentId(Integer deptId);
}
