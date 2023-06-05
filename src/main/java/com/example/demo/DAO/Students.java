package com.example.demo.DAO;

import com.example.demo.Entities.StudentInformationEntity;
import com.example.demo.Entities.StudentUpdateInformationEntity;
import com.example.demo.Entities.StudentsInformationEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface Students {
    @Select("select a.ID as id, s.stu_name, a.password, s.gender, s.department, s.grade, s.major, s.class_num, s.phone, s.email from students s inner join account a on a.ID=s.SID")
    public List<StudentsInformationEntity> getAllStudents();
    @Select("select a.ID as id, s.stu_name, a.password, s.gender, s.department, s.grade, s.major, s.class_num, s.phone, s.email from students s inner join account a on a.ID=s.SID where s.SID = #{id}")
    public StudentsInformationEntity getStudentsById(int id);
    @Insert("insert into students(SID,stu_name, gender, department, grade, major, class_num, phone, email) values(#{SID},#{stu_name},#{gender},#{department},#{grade},#{major},#{class_num},#{phone},#{email})")
    public void addStudent(StudentsInformationEntity studentsEntity);

    @Select("select * from students where SID = #{id}")
    public StudentInformationEntity getStudentById(int id);
    @Update("update students set phone = #{phone}, email = #{email} where SID = #{id}")
    public void updateStudent(Map<String, Object> map);
}
