package com.Internship.User.Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private int addressId;
    private String presentAddress;
    private String permanentAddress;
}
