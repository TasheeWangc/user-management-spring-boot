package com.internship.usermanagementsystem.Repository;

import com.internship.usermanagementsystem.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
