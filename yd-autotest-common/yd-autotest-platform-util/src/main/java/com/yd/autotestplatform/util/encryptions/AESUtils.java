package com.yd.autotestplatform.util.encryptions;

import com.yd.autotestplatform.util.Base64Utils;
import com.yd.autotestplatform.util.RandomStringUtils;
import org.springframework.util.ObjectUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;

/**
 * <p>
 *  1、通过「KeyGenerator.getInstance("DES")」生成密钥，
 *  2.参数为算法名称：分别对应DES、DESede（即3DES）、AES
 *  3.每种算法密钥长度参数：DES（56），3DES（112，168），AES（128，192，256）
 * </p>
 * PRC: People's Republic of China
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-24 11:19
 * @Email: 664720125@qq.com
 */
public class AESUtils {
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    /**
     * 获取随机key
     * @return
     */
    public static String getKey() {
        return RandomStringUtils.getRandomString(16);
    }
    /**
     * 将byte[]转为各种进制的字符串
     * @param bytes byte[]
     * @param radix 可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
     * @return 转换后的字符串
     */
    public static String binary(byte[] bytes, int radix){
        return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
    }



    /**
     * AES加密
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的byte[]
     * @throws Exception
     */
    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        /*
         *  1、通过「KeyGenerator.getInstance("DES")」生成密钥，
         *  2.参数为算法名称：分别对应DES、DESede（即3DES）、AES
         *  3.每种算法密钥长度参数：DES（56），3DES（112，168（默认）），AES（128（默认），192，256）
         */
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));

        return cipher.doFinal(content.getBytes("utf-8"));
    }


    /**
     * AES加密为base 64 code
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的base 64 code
     * @throws Exception
     */
    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        if (ObjectUtils.isEmpty(encryptKey)) {
            return content;
        }
        return Base64Utils.base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    /**
     * AES解密
     * @param encryptBytes 待解密的byte[]
     * @param decryptKey 解密密钥
     * @return 解密后的String
     * @throws Exception
     */
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }


    /**
     * 将base 64 code AES解密
     * @param encryptStr 待解密的base 64 code
     * @param decryptKey 解密密钥
     * @return 解密后的string
     * @throws Exception
     */
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        if (ObjectUtils.isEmpty(decryptKey)) {
            return encryptStr;
        }
        return ObjectUtils.isEmpty(encryptStr) ? null : aesDecryptByBytes(Base64Utils.base64Decode(encryptStr), decryptKey);
    }
}
