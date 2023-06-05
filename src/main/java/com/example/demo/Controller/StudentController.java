package com.example.demo.Controller;

import com.example.demo.Entities.*;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    // 查询学生信息
    @GetMapping("/information")
    public StudentInformationEntity getInformation() {
        int id = (int) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return studentService.getInformation(id);
    }
    // 更新学生信息
    @PostMapping("/information")
    public void updateInformation(@RequestBody StudentUpdateInformationEntity studentsEntity) {
        int id = (int) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        studentService.updateInformation(id, studentsEntity);
    }

    // 查询个人获奖情况
    @GetMapping("/awards")
    public BaseEntity getAward(){
        int id = (int) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new BaseEntity(0, "", studentService.getAward(id).size(), studentService.getAward(id));
    }
    // 录入个人奖项
    @PostMapping("/awards")
    public void addAward(@RequestBody RecordPersonalAwardEntity awardEntity){
        int id = (int) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        studentService.addAward(id,awardEntity);
    }
}
