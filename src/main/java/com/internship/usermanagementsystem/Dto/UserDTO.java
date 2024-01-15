package com.internship.usermanagementsystem.Dto;

import com.internship.usermanagementsystem.Model.Address;
import com.internship.usermanagementsystem.Model.Gender;
import com.internship.usermanagementsystem.Model.ProfileImage;
import com.internship.usermanagementsystem.Model.Section;
import lombok.Data;

import java.sql.Date;

@Data
public class UserDTO {
    private int userId;
    private long cidNo;
    private int employeeId;
    private String firstName;
    private String middleName;
    private String lastName;
    private int mobileNo;
    private String email;
    private Date dob;
    private Gender gender;
    private Address address;
    private Section section;
    private ProfileImage profileImage;
}
