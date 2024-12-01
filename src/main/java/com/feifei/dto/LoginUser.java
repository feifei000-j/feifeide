package com.feifei.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NoArgsConstructor;
import com.feifei.entity.MsbUser;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data // ⾃动⽣成getter和setter⽅法
@TableName(value = "msb_user") // 指定数据库表名
@Builder // 构造器
@AllArgsConstructor // 全参构造函数
@NoArgsConstructor // ⽆参构造函数
public class LoginUser   {
    private Integer userId;
    private String userName;
    private String userEmail;
    private String userRole;
    private String userBio;
    private String userPhone;
}

