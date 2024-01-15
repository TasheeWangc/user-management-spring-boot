package com.internship.usermanagementsystem.Repository;

import com.internship.usermanagementsystem.Model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section,Integer> {
    List<Section> findByDepartmentDeptId(Integer deptId);
}
