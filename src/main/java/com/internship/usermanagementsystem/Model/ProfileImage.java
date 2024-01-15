package com.internship.usermanagementsystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_profile_image")
public class ProfileImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Image_Id")
    private int imageId;

    @Column(name = "Image_Name")
    private String imageName;

    @Column(name = "Image_Type")
    private String imageType;

    @Column(name = "Image_Path")
    private String imagePath;
}
