package com.internship.usermanagementsystem.Repository;

import com.internship.usermanagementsystem.Model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender,Integer> {
}
