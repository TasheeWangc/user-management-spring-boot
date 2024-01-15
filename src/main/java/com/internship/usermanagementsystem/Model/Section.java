package com.internship.usermanagementsystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "section")
public class Section{
    /* Define the field */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Section_Id")
    private int sectId;

    @Column(name = "Section_Name")
    private String sectName;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "Dept_Id")
    private Department department;

}
