package com.demo.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    //MD5加密
    public static String md5(String source){
        return DigestUtils.md5Hex(source);
    }

    private static final String salt = "sheng";

    public static String inputPassToFromPass(String inputPass){
        String str = ""+salt.charAt(0)+salt.charAt(2)+salt.charAt(1)+inputPass;
        return md5(str);
    }

    public static String fromPassToDBPass(String fromPass,String salt){
        String str = salt.charAt(0)+salt.charAt(2)+salt.charAt(1)+fromPass;
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass,String salt){
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = fromPassToDBPass(fromPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        String s = fromPassToDBPass("e1e8710d7e09a22ee3aeb246fae266b2", "sheng");
        System.out.println(s);
        System.out.println("=================");
        String s1 = inputPassToDBPass("123456","sheng");
        System.out.println(s1);
    }


}
