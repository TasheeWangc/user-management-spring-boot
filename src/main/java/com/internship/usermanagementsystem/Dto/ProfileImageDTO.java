package com.internship.usermanagementsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileImageDTO {
    private int imageId;
    private String imageName;
    private String imageType;
    private String imagePath;
}
