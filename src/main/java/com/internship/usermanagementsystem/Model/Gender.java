package com.Internship.User.Management.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Gender{
    // Define Field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id") // Optional
    private int genderId;
    @Column(name = "gender_type")
    private String genderType;

}