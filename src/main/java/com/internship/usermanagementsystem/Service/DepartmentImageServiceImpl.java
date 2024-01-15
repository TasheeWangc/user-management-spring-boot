package com.internship.usermanagementsystem.Service;

import com.internship.usermanagementsystem.Model.Department;
import com.internship.usermanagementsystem.Model.DepartmentImage;
import com.internship.usermanagementsystem.Repository.DepartmentImageRepository;
import com.internship.usermanagementsystem.Repository.DepartmentRepository;
import com.internship.usermanagementsystem.Utility.FileNameGenerator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@Log4j2
public class DepartmentImageServiceImpl implements DepartmentImageService{

    @Autowired
    private DepartmentImageRepository departmentImageRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private FileNameGenerator fileNameGenerator;


    @Value("${department-profile.upload-dir}")
    private String FOLDER_PATH;
    @Override
    public ResponseEntity<String> uploadImage(Integer dept_id, MultipartFile profileImageFile) {
        String filePath = Paths.get(FOLDER_PATH, fileNameGenerator.generateUniqueFileName(profileImageFile.getOriginalFilename())).toString();
        log.info("File path:"+ filePath);
        dept_id = Integer.valueOf(dept_id);

        try{
            if(dept_id== null || profileImageFile == null){
                return new ResponseEntity<>("Invalid user id or no image file", HttpStatus.BAD_REQUEST);
            }
            if(!departmentImageRepository.existsById(dept_id)){
                return new ResponseEntity<>("Users not found!", HttpStatus.NOT_FOUND);
            }

            Department department = departmentRepository.findById(dept_id).orElseThrow();
            // get the image id
            int image_id = department.getDepartmentImage().getDeptImageId();
            String existingProfileImagePath = FOLDER_PATH + department.getDepartmentImage().getDeptImageName();
            /* Get the image */
            DepartmentImage departmentImage = null;
            if(profileImageFile != null){
                departmentImage = departmentImage.builder()
                        .deptImageId(image_id)
                        .deptImageName(profileImageFile.getOriginalFilename())
                        .deptImageType(profileImageFile.getContentType())
                        .deptImagePath(filePath)
                        .build();
            }
            /* Delete the existing file */
            Files.deleteIfExists(Paths.get(existingProfileImagePath));
            /* Update the profile image profile */
            DepartmentImage uploadedProfile  = departmentImageRepository.saveAndFlush(departmentImage);

            profileImageFile.transferTo(new File(filePath));
            // user.setProfileImage(profileImage);
            if(uploadedProfile == null){
                return new ResponseEntity<>("Save or Uploaded Profile is null",HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(HttpStatus.CREATED);

        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<byte[]> getProfileImage(Integer user_id) {
        return null;
    }
}
