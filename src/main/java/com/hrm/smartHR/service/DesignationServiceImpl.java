package com.hrm.smartHR.service;

import com.hrm.smartHR.dto.DesignationDto;
import com.hrm.smartHR.entity.Designation;
import com.hrm.smartHR.repository.DesignationRepository;
import com.hrm.smartHR.utils.AppUtils;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class DesignationServiceImpl implements DesignationService{
    private final DesignationRepository designationRepository;
    private final AppUtils appUtils;

    @Transactional
    @Override
    public DesignationDto save(DesignationDto obj) {
        Designation designation = designationRepository.save(generateEntity(obj, true));
        return generateDto(designation);
    }

    @Transactional
    @Override
    public DesignationDto update(DesignationDto obj) {
        DesignationDto oldDto = generateDto(designationRepository.findById(obj.getId()).get());
        Designation updated = designationRepository.save(generateEntity(obj, false));
        return generateDto(updated);
    }

    @Transactional
    @Override
    public Boolean delete(DesignationDto obj) {
        Designation entity = designationRepository.findById(obj.getId()).get();
        if(ObjectUtils.isEmpty(entity)){
            return false;
        }
        try{
            designationRepository.deleteById(obj.getId());
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public DesignationDto getById(int id) {
        Optional<Designation> designation = designationRepository.findById(id);
        if(designation.isEmpty()){
            return null;
        }
        else{
            return generateDto(designation.get());
        }
    }

    @Override
    public List<DesignationDto> getAll() {
        return convertEntityListToDtoList(designationRepository.findAll().stream());
    }


    public Designation generateEntity(DesignationDto dto, Boolean isSaved){
        Designation entity = new Designation();
        BeanUtils.copyProperties(dto, entity);
        if(isSaved){
            appUtils.setEntryInfo(entity);
        }
        else{
            appUtils.setUpdateInfo(entity);
        }
        return entity;
    }

    public  DesignationDto generateDto(Designation entity){
        DesignationDto dto = new DesignationDto();
        BeanUtils.copyProperties(entity, dto);
        return  dto;
    }

    public  List<DesignationDto> convertEntityListToDtoList(Stream<Designation> entityList){
        return entityList.map(entity -> {
            return  generateDto(entity);
        }).collect(Collectors.toList());
    }
}
