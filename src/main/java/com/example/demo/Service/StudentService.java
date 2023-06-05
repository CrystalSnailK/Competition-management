package com.example.demo.Service;

import com.example.demo.Entities.*;

import java.util.List;

public interface StudentService {
    public StudentInformationEntity getInformation(int id);
    public List<PersonalAwardRequestEntity> getAward(int id);
    public void addAward(int id, RecordPersonalAwardEntity awardEntity);
    public void updateInformation(int id, StudentUpdateInformationEntity studentsEntity);
}
