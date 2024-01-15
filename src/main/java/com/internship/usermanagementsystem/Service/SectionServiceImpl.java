package com.internship.usermanagementsystem.Service;

import com.internship.usermanagementsystem.Dto.SectionDTO;
import com.internship.usermanagementsystem.Model.Department;
import com.internship.usermanagementsystem.Model.Section;
import com.internship.usermanagementsystem.Repository.DepartmentRepository;
import com.internship.usermanagementsystem.Repository.SectionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class SectionServiceImpl implements SectionService{

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public ResponseEntity<List<SectionDTO>> findAllSection() {
        try {
            List<SectionDTO> sectionDTOS=sectionRepository.findAll().stream().map(this::sectionEntityToDto).collect(Collectors.toList());
            return new ResponseEntity<>(sectionDTOS, HttpStatus.OK);
        }
        catch (Exception e){
            log.error("Error while retrieving all sections: ",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @Override
    public ResponseEntity<SectionDTO> findSectionById(Integer sect_id) {
        try {
            if (sect_id ==  null || sect_id < 0) {
                /* Bad Request - Invalid user_id format */
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            SectionDTO sectionDTO = sectionEntityToDto(sectionRepository.findById(sect_id).orElseThrow());
            return new ResponseEntity<>(sectionDTO,HttpStatus.OK);
        }
        catch(Exception e){
            /* Log the errrpr */
            log.error("Error while retrieving section by id: ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<String> saveSection(SectionDTO sectionDTO) {
        try {
            Department department = departmentRepository.findById(sectionDTO.getDepartment().getDeptId()).orElseThrow();
            Section section = sectionDtoToEntity(sectionDTO);

            section.setDepartment(department);
            log.info("Section: " + section);

            Section savedSection = sectionRepository.saveAndFlush(section);

            if(savedSection == null){
                /* Log the error */
                log.info("Saved Section is null! Error while saving");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
            log.error("Error while saving/updating  section: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteSection(Integer sect_id) {
        try{
            if(sect_id == null || sect_id < 0){
                /* log the error */
                return new ResponseEntity<>("Invalid sec_id format", HttpStatus.BAD_REQUEST);
            }
            if (!sectionRepository.existsById(sect_id)) {
                return new ResponseEntity<>("Section not found", HttpStatus.NOT_FOUND);
            }
            sectionRepository.deleteById(sect_id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            /* Log the error */
            log.error("Error while deleting section: ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<SectionDTO>> findSectionByDepartmentId(Integer deptId) {
        try{
            if (deptId ==  null || deptId < 0) {
                /* Bad Request - Invalid user_id format */
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            List<SectionDTO> sectionDTOs = sectionRepository.findByDepartmentDeptId(deptId).stream().map(this::sectionEntityToDto).collect(Collectors.toList());
            return new ResponseEntity<>(sectionDTOs, HttpStatus.OK);
        }
        catch(Exception e){
            log.error("Error while retrieving all section: ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private SectionDTO sectionEntityToDto(Section section){
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setSectId(section.getSectId());
        sectionDTO.setSectName(section.getSectName());
        sectionDTO.setDepartment(section.getDepartment());

        return sectionDTO;
    }

    private Section sectionDtoToEntity(SectionDTO sectionDTO){
        Section section = new Section();
        section.setSectId(sectionDTO.getSectId());
        section.setSectName(sectionDTO.getSectName());
        section.setDepartment(sectionDTO.getDepartment());

        return section;
    }







}
