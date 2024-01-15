package com.internship.usermanagementsystem.Utility;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class FileNameGenerator {
    public String generateUniqueFileName(String originalFileName) {
        // Append a timestamp or a random string to the original file name
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String randomString = UUID.randomUUID().toString().replace("-", "");
        
        // Extract the file extension from the original file name
        int dotIndex = originalFileName.lastIndexOf('.');
        String fileExtension = (dotIndex > 0) ? originalFileName.substring(dotIndex) : "";
        
        // Concatenate the timestamp, random string, and file extension to create a unique file name
        return timestamp + "_" + randomString + fileExtension;
    }
}