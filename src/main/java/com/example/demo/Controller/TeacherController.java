package com.example.demo.Controller;

import com.example.demo.Entities.*;
import com.example.demo.Service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeachersService teachersService;
    // 查询老师账户信息
    @GetMapping("/information")
    public TeacherInformationEntity getInformation() {
        int id = (int) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return teachersService.getInformation(id);
    }
    // 更新老师账户信息
    @PostMapping("/information")
    public void updateInformation(@RequestBody TeacherUpdateInformationEntity teacherUpdateInformationEntity) {
        int id = (int) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        teachersService.updateInformation(id, teacherUpdateInformationEntity);
    }
    // 查询所有的获奖名单
    @GetMapping("/awards")
    public BaseEntity getAllAwards(){
        return new BaseEntity(0, "", teachersService.getAwards().size(), teachersService.getAwards());
    }
    // 查询老师辅导的比赛名单
    @GetMapping("/award")
    public BaseEntity getAward(){
        int id = (int) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<TeacherAwardsRequestEntity> ts = teachersService.getAward(id);
        return new BaseEntity(0, "", ts.size(), ts);
    }
    @GetMapping("/awardbyid")
    public BaseEntity getAwardByID(@RequestParam int id){

        return new BaseEntity(0, "", 1, teachersService.getAwardByID1(id));
    }

}
