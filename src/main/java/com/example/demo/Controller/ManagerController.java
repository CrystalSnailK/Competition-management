package com.example.demo.Controller;

import com.example.demo.Entities.*;
import com.example.demo.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 86400)
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/accounts/students")
    public BaseEntity getALLStudents() {
        return new BaseEntity(0, "", managerService.getAllStudents().size(), managerService.getAllStudents());
    }
    @GetMapping("/accounts/students/search")
    public BaseEntity getStudentByID(@RequestParam("id") int id) {
        StudentsInformationEntity si = managerService.getStudentsByID(id);
        return new BaseEntity(0, "", 1, si);
    }
    // 更新学生账户信息
//    @PutMapping("accounts/students/update")


    @GetMapping("/accounts/teachers")
    public BaseEntity getAllTeachers() {
        return new BaseEntity(0, "", managerService.getAllTeachers().size(), managerService.getAllTeachers());
    }
    @GetMapping("/accounts/teachers/search")
    public BaseEntity getTeachersByID(@RequestParam("id") int id) {
        TeachersInformationEntity ti = managerService.getTeachersByID(id);
        return new BaseEntity(0,"", 1, ti);
    }
//    // 更新老师账户信息
//    @PutMapping("/accounts/teachers")
//
    @PostMapping("/competitions/add")
    public void addCompetition(@RequestBody SubmitCompetionEntity competition) { managerService.addCompetition(competition);}
    @GetMapping("/competitions/all")
    public BaseEntity getAllCompetitions() {
        List<CompetitionRequestEntity> data = managerService.getAllCompetitions();
        return new BaseEntity(0, "success", data.size(), data);
    }
}
