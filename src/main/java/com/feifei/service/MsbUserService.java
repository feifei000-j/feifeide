package com.feifei.service;
import com.feifei.entity.MsbUser;
import com.feifei.dto.LoginUser;
public interface MsbUserService {
    LoginUser selectById(Integer userId);
//    Result<LoginUser> selectById(Integer userId);
    LoginUser login(String usernameOrEmail, String password);
    LoginUser getUserByEmail(String email);  //根据⽤户邮箱获取⽤户
    void  register(MsbUser user);


}