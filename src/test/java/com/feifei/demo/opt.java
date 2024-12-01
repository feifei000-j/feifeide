package com.feifei.demo;

import com.feifei.utils.Md5Password;

public class opt {
    public static void main(String[] args) {
        String password = "xz123456";
        System.out.println(Md5Password.generateMD5(password));
    }
}

