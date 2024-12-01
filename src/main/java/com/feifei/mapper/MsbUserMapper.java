package com.feifei.mapper;


import com.feifei.entity.MsbUser;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface MsbUserMapper {
    @Select("SELECT * FROM msb_user WHERE user_id = #{userId}")
    MsbUser selectById(Integer userId);

    //登录
    @Select("SELECT * FROM msb_user WHERE user_name = #{usernameOrEmail} OR user_email = #{usernameOrEmail}")
	MsbUser selectByUsernameOrEmail(String usernameOrEmail);


    @Select("SELECT * FROM msb_user WHERE user_email = #{email}")
    MsbUser selectByEmail(String email);

    @Select("SELECT * FROM msb_user WHERE user_name = #{userName}")
    MsbUser selectByUsername(String username);


    @Insert("INSERT INTO msb_user (user_name, user_email, user_password_hash) " +
            "VALUES (#{userName}, #{userEmail}, #{userPasswordHash})")
    void  register(MsbUser user);
}
