package com.internship.usermanagementsystem.Service;

import com.internship.usermanagementsystem.Dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface UserService {
    /* Add user */
    ResponseEntity<String> saveUser(UserDTO userDTO, MultipartFile profileImageFile);

    /* List all user */
    ResponseEntity<List<UserDTO>> findAllUser();

    /* Get User by User Id */
    ResponseEntity<UserDTO> findUserById(Integer user_id);

    /* Delete the user */
    ResponseEntity<String> deleteUser(Integer user_id);

    ResponseEntity<String> updateEmail(String email, Integer user_id);

    ResponseEntity<Long> getTotalUserCount();

    ResponseEntity<Long> getUserCountByGender(Integer genderId);

    ResponseEntity<List<UserDTO>> getAllUserBySectionId(Integer sect_id);

    ResponseEntity<List<UserDTO>> getAllUserByDepartmentId(Integer dept_id);
}
