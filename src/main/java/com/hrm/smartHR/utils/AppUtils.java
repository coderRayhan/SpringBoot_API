package com.hrm.smartHR.utils;

import com.hrm.smartHR.base.BaseEntity;
import com.hrm.smartHR.base.BaseUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AppUtils extends BaseUtils {
    public void setEntryInfo(Object obj){
        BaseEntity entity = (BaseEntity) obj;
        entity.setCreatedAt(LocalDateTime.now());
    }

    public void setUpdateInfo(Object obj){
        BaseEntity entity = (BaseEntity) obj;
        entity.setUpdatedAt(LocalDateTime.now());
    }
}
