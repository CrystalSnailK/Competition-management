package com.example.demo.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.DAO.Award;
import com.example.demo.DAO.Students;
import com.example.demo.DAO.Teachers;
import com.example.demo.Entities.TeacherAwardsRequestEntity;
import com.example.demo.Entities.TeacherInformationEntity;
import com.example.demo.Entities.TeacherUpdateInformationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeachersServiceImpl implements TeachersService {
    @Autowired
    private Teachers teachers;
    @Autowired
    private Award award;
    @Override
    public TeacherInformationEntity getInformation(int id) {
        return teachers.getInformation(id);
    }
    @Override
    public void updateInformation(int id, TeacherUpdateInformationEntity teacherUpdateInformationEntity) {
        Map<String, Object> map = JSON.parseObject(JSON.toJSONString(teacherUpdateInformationEntity), Map.class);
        map.put("TID", id);
        teachers.updateInformation(map);
    }
    @Override
    public List<TeacherAwardsRequestEntity> getAwards() {
        return teachers.getAwards();
    }
    public List<TeacherAwardsRequestEntity> getAward(int id) {
        return teachers.getAward(id);
    }
    @Override
    public List<TeacherAwardsRequestEntity> getAwardByID1(int id){
        return award.getAwardBySID1(id);
    }
}
