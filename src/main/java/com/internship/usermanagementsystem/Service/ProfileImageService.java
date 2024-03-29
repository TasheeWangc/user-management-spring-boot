package com.internship.usermanagementsystem.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileImageService {
    /* Upload Image */
    ResponseEntity<String> uploadImage(Integer user_id, MultipartFile profileImageFile);
    /* Get Image */
    ResponseEntity<byte[]> getProfileImage(Integer user_id);
}
