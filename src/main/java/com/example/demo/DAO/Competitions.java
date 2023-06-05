package com.example.demo.DAO;

import com.example.demo.Entities.CompetitionRequestEntity;
import com.example.demo.Entities.SubmitCompetionEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Competitions {
    @Select("select c_name, time c_time, level, sponsor as host, comment from competions")
    public List<CompetitionRequestEntity> getAllCompetitions();
    @Select("select CID from competions where c_name=#{c_name}")
    public int getCIDByName(String c_name);
    @Insert("insert into competions(c_name, time, level, sponsor) values(#{name}, #{date}, #{level}, #{host})")
    public void addCompetition(SubmitCompetionEntity competition);

}
