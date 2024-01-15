package com.internship.usermanagementsystem.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface DepartmentImageService {
    /* Upload Image */
    ResponseEntity<String> uploadImage(Integer dept_id, MultipartFile profileImageFile);
    /* Get Image */
    ResponseEntity<byte[]> getProfileImage(Integer user_id);
}
