package cn.zcc.vastsea.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Md5Code {
    //字节流转Md5
    public static String byteToMd5(byte[] bytes) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            StringBuilder stringBuffer = new StringBuilder();
            for (byte b : digest) {
                String s = Integer.toHexString(b & 0xff);
                stringBuffer.append(s.length() > 1 ? s : "0" + s);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String strToMd5(String s) {
        return byteToMd5(s.getBytes(StandardCharsets.UTF_8));
    }
}
