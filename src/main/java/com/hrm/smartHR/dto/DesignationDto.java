package com.hrm.smartHR.dto;

import com.hrm.smartHR.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DesignationDto extends BaseDto {
    private String designationName;
    private String designationNameBn;
    private String grade;
}
