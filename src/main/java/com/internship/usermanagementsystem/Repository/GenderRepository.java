package com.Internship.User.Management.repository;

import com.Internship.User.Management.models.Address;
import com.Internship.User.Management.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender,Integer> {
}
