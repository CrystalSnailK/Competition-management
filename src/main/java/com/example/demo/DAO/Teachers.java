package com.example.demo.DAO;

import com.example.demo.Entities.TeacherAwardsRequestEntity;
import com.example.demo.Entities.TeacherInformationEntity;
import com.example.demo.Entities.TeacherUpdateInformationEntity;
import com.example.demo.Entities.TeachersInformationEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface Teachers {
    @Select("select a.ID as id, t.t_name, a.password, t.department, t.phone, t.email from teachers t inner join account a on a.ID=t.TID")
    public List<TeachersInformationEntity> getAllTeachers();
    @Select("select a.ID as id, t.t_name, a.password, t.department, t.phone, t.email from teachers t inner join account a on t.TID=a.ID where TID = #{id}")
    public TeachersInformationEntity getTeachersById(int id);
//    @Select("select TID, t_name from teachers")
//    public List<TeacherShortEntity> getTeachersShort();
//    @Insert("insert into teachers(TID,t_name, department, phone, email) values(#{TID},#{t_name},#{department},#{phone},#{email})")
//    public void addTeacher(TeachersEntity teachersEntity);
    @Update("update teachers set phone = #{phone}, email = #{email} where TID = #{TID}")
    public void updateTeacherPhone(int TID, int phone, String email);
    @Select("select TID from teachers where t_name=#{t_name}")
    public int getTIDByName(String t_name);
    @Select("select * from teachers where TID=#{TID}")
    public TeacherInformationEntity getInformation(int TID);
    @Update("update teachers set phone = #{phone}, email = #{email} where TID = #{TID}")
    public void updateInformation(Map<String, Object> map);
    @Select("select s.SID as id, s.stu_name, c.c_name, c.time, a.grade, c.sponsor as host, c.level " +
            "from award a " +
            "inner join competions c on c.CID=a.CID " +
            "inner join students s on s.SID=a.SID")
    public List<TeacherAwardsRequestEntity> getAwards();
    @Select("select s.SID as id, s.stu_name, c.c_name, c.time, a.grade, c.sponsor as host, c.level " +
            "from award a " +
            "inner join competions c on c.CID=a.CID " +
            "inner join students s on s.SID=a.SID " +
            "where a.TID=#{TID}")
    public List<TeacherAwardsRequestEntity> getAward(int TID);
}
