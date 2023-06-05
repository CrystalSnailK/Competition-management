package com.example.demo.DAO;

import com.example.demo.Entities.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Account {
    @Select("select * from account")
    public List<UserEntity> getAllAccounts();
    @Select("select * from account where ID = #{ID}")
    public UserEntity getByUsername(int ID);
    @Update("update account set password = #{password} where ID = #{ID}")
    public void updatePassword(int ID, String password);
    @Insert("insert into account(ID,password, role) values(#{ID}, #{password}, #{role})")
    public void addAccount(int ID, String password, String role);
}
