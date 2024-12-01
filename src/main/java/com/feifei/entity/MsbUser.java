package com.feifei.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.IdType;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;

/**
17	* ⽤户实体类
18	*/

@Data // ⾃动⽣成getter和setter⽅法
@TableName(value = "msb_user") // 指定数据库表名
@Builder // 构造器
@AllArgsConstructor // 全参构造函数
@NoArgsConstructor // ⽆参构造函数
public class MsbUser implements Serializable {


    @TableId(type = IdType.AUTO)
     private Integer userId;

    @TableField(value = "user_name")
     private String userName;
    @TableField(value = "user_email")
      private String userEmail;
    @TableField(value = "user_password_hash")
    private String userPasswordHash;

    private String userBio;

private String userClass;

private String userPhone;

private String userGender;

private String userOnlineStatus;

private LocalDateTime userLastActive;

private LocalDateTime userCreatedAt;

private String userStatus;
}

