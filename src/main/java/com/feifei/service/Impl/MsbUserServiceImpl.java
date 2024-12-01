package com.feifei.service.impl;
import com.feifei.utils.Md5Password;
import com.feifei.entity.MsbUser;
import com.feifei.mapper.MsbUserMapper;
import com.feifei.service.MsbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feifei.dto.LoginUser;

@Service
public class MsbUserServiceImpl implements MsbUserService {
    @Autowired
    private MsbUserMapper msbUserMapper;

//    @Override
//    public Result<LoginUser> selectById(Integer userId) {
//        MsbUser msbUser = msbUserMapper.selectById(userId);
//        if (msbUser == null) {
//            // 没找到用户，根据不同场景返回不同的消息
//            if (userId <= 0) {
//                return Result.fail("无效的用户ID", 400); // 用户ID无效
//            } else {
//                return Result.fail("用户不存在", 500); // 标准用户不存在情况
//            }
//        }
//
//        LoginUser loginUser = new LoginUser();
//        loginUser.setUserId(msbUser.getUserId());
//        loginUser.setUserName(msbUser.getUserName());
//        loginUser.setUserEmail(msbUser.getUserEmail());
//        loginUser.setUserRole(msbUser.getUserRole());
//        loginUser.setUserBio(msbUser.getUserBio());
//        loginUser.setUserPhone(msbUser.getUserPhone());
//
//        return Result.success(loginUser);
//    }

    @Override
    public LoginUser selectById(Integer userId) {
        MsbUser msbUser = msbUserMapper.selectById(userId);
        if (msbUser == null) {
            return null;
        }

        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(msbUser.getUserId());
        loginUser.setUserName(msbUser.getUserName());
        loginUser.setUserEmail(msbUser.getUserEmail());
        loginUser.setUserBio(msbUser.getUserBio());
        loginUser.setUserPhone(msbUser.getUserPhone());

        return loginUser;
    }

    @Override
    public LoginUser login(String usernameOrEmail, String password) {
        // 根据用户名或者邮箱查询用户 判断用户是否存在
        MsbUser msbUser = msbUserMapper.selectByUsernameOrEmail(usernameOrEmail);
        if (msbUser == null) {
            return null;
        }
        // 密码进行MD5加密并且对比是否正确
        if (!Md5Password.generateMD5(password).equals(msbUser.getUserPasswordHash())) {
            return null;
        }
        // 用户存在并且密码正确 创建要返回的对象
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(msbUser.getUserId());
        loginUser.setUserName(msbUser.getUserName());
        loginUser.setUserEmail(msbUser.getUserEmail());
        loginUser.setUserBio(msbUser.getUserBio());
        loginUser.setUserPhone(msbUser.getUserPhone());

        return loginUser;
    }


    @Override
    public LoginUser getUserByEmail(String email) {
        MsbUser msbUser = msbUserMapper.selectByEmail(email);
        if (msbUser == null) {
            return null;
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(msbUser.getUserId());
        loginUser.setUserName(msbUser.getUserName());
        loginUser.setUserEmail(msbUser.getUserEmail());
        loginUser.setUserBio(msbUser.getUserBio());
        loginUser.setUserPhone(msbUser.getUserPhone());
        return loginUser;
    }







//注册！！！！！！
           @Override
        public void  register(MsbUser user) {
               MsbUser existingUser = msbUserMapper.selectByEmail(user.getUserEmail());
            if (existingUser != null) {
                throw new IllegalStateException("Email already in use");
            }

            existingUser = msbUserMapper.selectByUsername(user.getUserName());
            if (existingUser != null) {
                throw new IllegalStateException("Username or Email already in use");
            }

            String encodedPassword = Md5Password.generateMD5(user.getUserPasswordHash());
            user.setUserPasswordHash(encodedPassword);


            msbUserMapper.register(user);
        }



}