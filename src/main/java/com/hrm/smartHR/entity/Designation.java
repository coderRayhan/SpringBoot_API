package com.hrm.smartHR.entity;

import com.hrm.smartHR.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "HR_Designation")
public class Designation extends BaseEntity {
    @Column(name = "DESIGNATION_NAME")
    private String designationName;
    @Column(name = "DESIGNATION_NAME_BN")
    private String designationNameBn;
    @Column(name = "GRADE")
    private String grade;
}
