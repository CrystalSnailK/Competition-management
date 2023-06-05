package com.example.demo.Service;

import com.example.demo.Entities.TeacherAwardsRequestEntity;
import com.example.demo.Entities.TeacherInformationEntity;
import com.example.demo.Entities.TeacherUpdateInformationEntity;
import com.example.demo.Entities.TeachersInformationEntity;

import java.util.List;

public interface TeachersService {
    public TeacherInformationEntity getInformation(int id);
    public void updateInformation(int id, TeacherUpdateInformationEntity teacherUpdateInformationEntity);
    public List<TeacherAwardsRequestEntity> getAwards();
    public List<TeacherAwardsRequestEntity> getAward(int id);
    public List<TeacherAwardsRequestEntity> getAwardByID1(int id);
}
