package com.hrm.smartHR.controller;

import com.hrm.smartHR.base.BaseController;
import com.hrm.smartHR.base.BaseResponse;
import com.hrm.smartHR.dto.DesignationDto;
import com.hrm.smartHR.service.DesignationService;
import com.hrm.smartHR.utils.AppUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/api/designation")
@EnableScheduling
public class DesignationController implements BaseController<BaseResponse, DesignationDto, HttpServletRequest> {

    private final AppUtils commonUtils;
    private final DesignationService service;

    @Override
    @PostMapping
    public BaseResponse save(@RequestBody DesignationDto obj, HttpServletRequest request) {
        try{
            return commonUtils.generateSuccessResponse(service.save(obj), "Saved Succesfully", "Saved Successfully BN");
        }catch(Exception e){
            e.printStackTrace();
            return commonUtils.generatedErrorResponse(e);
        }
    }

    @Override
    @PutMapping
    public BaseResponse update(@RequestBody DesignationDto obj, HttpServletRequest request) {
        try {
            return commonUtils.generateSuccessResponse(service.update(obj), "Update successfully", "Update successfully BN");
        } catch (Exception e) {
            e.printStackTrace();
            return commonUtils.generatedErrorResponse(e);
        }
    }

    @Override
    @DeleteMapping
    public BaseResponse delete(@RequestBody DesignationDto obj, HttpServletRequest request) {
        try{
            return commonUtils.generateSuccessResponse(service.delete(obj), "Deleted successfully", "Deleted successfully BN");
        }catch(Exception e){
            e.printStackTrace();
            return commonUtils.generatedErrorResponse(e);
        }
    }

    @GetMapping
    @Override
    public BaseResponse getAll(HttpServletRequest request) {
        try{
            return commonUtils.generateSuccessResponse(service.getAll());
        }catch (Exception e){
            e.printStackTrace();
            return  commonUtils.generatedErrorResponse(e);
        }
    }

    @Override
    public BaseResponse getAllActive(HttpServletRequest request) {
        return null;
    }

    @Override
    @GetMapping("{id}")
    public BaseResponse getById(@PathVariable int id, HttpServletRequest request) {
        try{
            return commonUtils.generateSuccessResponse(service.getById(id));
        }catch(Exception e){
            e.printStackTrace();
            return commonUtils.generatedErrorResponse(e);
        }
    }

    @Override
    public BaseResponse getPageableList(int page, int size, String searchValue, HttpServletRequest request) {
        return null;
    }

    @Scheduled(fixedDelay = 5000)
    public void print(){
        System.out.println("Current time is: "+ new Date());
    }
}
