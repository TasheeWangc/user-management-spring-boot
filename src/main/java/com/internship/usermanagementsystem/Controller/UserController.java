package com.internship.usermanagementsystem.Controller;

import com.internship.usermanagementsystem.Dto.UserDTO;
import com.internship.usermanagementsystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    // Adding Department
    @PostMapping
    public ResponseEntity<String> addUser(
        @RequestPart(name = "user", required = true) UserDTO userDTO,
        @RequestPart(value = "profileImageFile", required = false) MultipartFile profileImageFile) {
        return userService.saveUser(userDTO, profileImageFile);
       
    }
    
    @GetMapping
    private ResponseEntity<List<UserDTO>> getAllUser() {
        return userService.findAllUser();
    }
    
    @GetMapping("/total")
    private ResponseEntity<Long> getAllUserCount() {
        return userService.getTotalUserCount();
    }
    
    @GetMapping("/total/{genderId}")
    private ResponseEntity<Long> getUserByGender(@PathVariable Integer genderId) {
        return userService.getUserCountByGender(genderId);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(
        @RequestPart(name = "user", required = true) UserDTO userDTO,
        @RequestPart(value = "profileImageFile", required = false) MultipartFile profileImageFile) {
        return userService.saveUser(userDTO, profileImageFile);
       
    }
    
    
    /* Retrieve single user */
    @GetMapping("/{user_id}")
    private ResponseEntity<UserDTO> getUserById(@PathVariable Integer user_id){
       return userService.findUserById(user_id);
    }
    /* Delete user */
    @DeleteMapping("/{user_id}")
    private ResponseEntity<String> deleteUser(@PathVariable Integer user_id){
        return userService.deleteUser(user_id);
    }

   
    /* Native Query */
    @PutMapping("/email")
    private ResponseEntity<String> updateUserEmail(@RequestBody UserDTO userDTO){
        return userService.updateEmail(userDTO.getEmail(), userDTO.getUserId());
    }

    @GetMapping("/sections/{sect_id}")
    private ResponseEntity<List<UserDTO>> getSectionUsers(@PathVariable Integer sect_id){
        return userService.getAllUserBySectionId(sect_id);
    }

    @GetMapping("/departments/{dept_Id}")
    private ResponseEntity<List<UserDTO>> getAllDepartmentUser(@PathVariable Integer dept_Id){
        return userService.getAllUserByDepartmentId(dept_Id);
    }

}
