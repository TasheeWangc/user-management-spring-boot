package com.internship.usermanagementsystem.Controller;

import com.internship.usermanagementsystem.Service.ProfileImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/profile_images")
public class ProfileImageController {
    
    @Autowired
    private ProfileImageService profileImageService;

    @PostMapping("/{user_id}")
    private ResponseEntity<String> uploadProfile(
        @RequestPart(name = "profileImageFile", required = true) MultipartFile profileImageFile,@PathVariable Integer user_id){
        return profileImageService.uploadImage(Integer.valueOf(user_id), profileImageFile);
    }

    @GetMapping("/{user_id}")
    private ResponseEntity<byte[]> getProfileImage(@PathVariable Integer user_id){
        return profileImageService.getProfileImage(user_id);
    }
}
