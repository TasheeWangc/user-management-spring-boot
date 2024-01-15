package com.internship.usermanagementsystem.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "user")
public class User {
    /* Define field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id")
    private int userId;

    @Column(name = "CID_No")
    private long cidNo;

    @Column(name = "Employee_Id")
    private int employeeId;

    @Column(name = "FName")
    private String firstName;

    @Column(name = "MName")
    private String middleName;

    @Column(name = "LName")
    private String lastName;

    @Column(name = "Mobile_No")
    private int mobileNo;

    @Column(name = "Email")
    private String email;


    @Column(name = "DOB")
    private Date dob;

    @ManyToOne(
        cascade = {
            CascadeType.DETACH, 
            CascadeType.PERSIST, 
            CascadeType.REFRESH, 
            CascadeType.MERGE
        }
    )
    @JoinColumn(name = "Gender_Id")
    private Gender gender;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_Id")
    private Address address;

    @ManyToOne(
        cascade = {
            CascadeType.DETACH, 
            CascadeType.PERSIST, 
            CascadeType.REFRESH, 
            CascadeType.MERGE
        }
    )
    @JoinColumn(name = "Section_Id")
    private Section section;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Image_Id")
    private ProfileImage profileImage;
}