package com.example.demo.Service;

import com.example.demo.DAO.Account;
import com.example.demo.DAO.Competitions;
import com.example.demo.DAO.Students;
import com.example.demo.DAO.Teachers;
import com.example.demo.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private Competitions competitions;
    @Autowired
    private Account account;
    @Autowired
    private Students students;
    @Autowired
    private Teachers teachers;
    @Override
    public List<CompetitionRequestEntity> getAllCompetitions() {
        return competitions.getAllCompetitions();
    }
    @Override
    public void addCompetition(SubmitCompetionEntity competition) { competitions.addCompetition(competition);}
    @Override
    public List<StudentsInformationEntity> getAllStudents() {
        return students.getAllStudents();
    }
    @Override
    public StudentsInformationEntity getStudentsByID(int id) {
        return students.getStudentsById(id);
    }
    @Override
    public List<TeachersInformationEntity> getAllTeachers() {
        return teachers.getAllTeachers();
    }
    @Override
    public TeachersInformationEntity getTeachersByID(int id) {
        return teachers.getTeachersById(id);
    }
}
