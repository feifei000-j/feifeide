package com.feifei.config;

import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan("com.feifei.mapper")
public class MyBatisConfig {
    // ... 其他配置
}