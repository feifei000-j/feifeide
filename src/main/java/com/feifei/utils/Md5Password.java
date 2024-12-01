package com.feifei.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Password {
    	// 独⼀⽆⼆的盐值
        private static final String SALT = "youjixianxuetang-java2024";
        public static String generateMD5(String input) {
        try {
            	// 在原始输⼊前后加盐
            	String saltedInput = SALT + input + SALT;
            // 创建⼀个 MessageDigest 实例
            	MessageDigest md = MessageDigest.getInstance("MD5");
            	byte[] hashBytes = md.digest(saltedInput.getBytes());
            // 转换成⼗六进制字符串
            	StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                	sb.append(String.format("%02x", b));
                	}
            	return sb.toString();
            	} catch (NoSuchAlgorithmException e) {
            	throw new RuntimeException("MD5 algorithm not found", e);
            	}
        	}

}
