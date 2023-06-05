package com.example.demo.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.DAO.Award;
import com.example.demo.DAO.Competitions;
import com.example.demo.DAO.Students;
import com.example.demo.DAO.Teachers;
import com.example.demo.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private Students students;
    @Autowired
    private Award award;
    @Autowired
    private Teachers teachers;
    @Autowired
    private Competitions competitions;
    @Override
    public StudentInformationEntity getInformation(int id) {
        return students.getStudentById(id);
    }
    @Override
    public void updateInformation(int id, StudentUpdateInformationEntity studentsEntity) {
        Map<String, Object> map = JSON.parseObject(JSON.toJSONString(studentsEntity), Map.class);
        map.put("id", id);
        students.updateStudent(map);
    }
    @Override
    public List<PersonalAwardRequestEntity> getAward(int id) {
        return award.getAwardBySID(id);
    }
    @Override
    public void addAward(int id, RecordPersonalAwardEntity awardEntity) {
        int CID = competitions.getCIDByName(awardEntity.getC_name());
        int TID = teachers.getTIDByName(awardEntity.getTea_name());
        award.addAward(id, CID, TID, awardEntity.getGrade());
    }


}
