package com.suxton.kunmall.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtils {
    public static String encrypt(String input) {
        try {
            // 创建MD5摘要算法的MessageDigest实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 将输入转换为字节数组
            byte[] inputBytes = input.getBytes();

            // 计算摘要
            byte[] hashBytes = md.digest(inputBytes);

            // 将摘要转换为十六进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isBlank(String s) {
        if (s == null) return true;
        return s.length() == 0;
    }
}
