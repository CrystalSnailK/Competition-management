package com.example.demo.DAO;

import com.example.demo.Entities.PersonalAwardRequestEntity;
import com.example.demo.Entities.TeacherAwardsRequestEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Award {
    @Select("select c.c_name, c.time as c_time, a.grade, c.sponsor as host, c.level from award a inner join competions c on c.CID=a.CID where a.SID=#{SID}")
    public List<PersonalAwardRequestEntity> getAwardBySID(int SID);
    @Insert("insert into award(SID, CID, TID, grade) values(#{SID},#{CID},#{TID},#{grade})")
    public void addAward(int SID, int CID, int TID, String grade);
    @Select("select s.SID as id, s.stu_name, c.c_name, c.time, a.grade, c.sponsor as host, c.level from award aw inner join students s on aw.SID=s.SID inner join competions c on c.CID=aw.CID where s.SID={id}")
    public List<TeacherAwardsRequestEntity> getAwardBySID1(int id);
}
