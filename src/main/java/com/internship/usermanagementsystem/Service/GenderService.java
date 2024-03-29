package com.internship.usermanagementsystem.Service;
import java.util.List;
import org.springframework.http.ResponseEntity;
import com.internship.usermanagementsystem.Dto.GenderDTO;


public interface GenderService {
    // List all Department
    ResponseEntity<List<GenderDTO>> findAllGender();

    // // Find Department By Id
    ResponseEntity<GenderDTO> findGenderById(Integer gender_id);

    // Save Department
    ResponseEntity<String> saveGender(GenderDTO genderDTO);

    //     void delete(int dept_id);
    ResponseEntity<String> deleteGender(Integer gender_id);
}
