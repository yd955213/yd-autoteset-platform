package com.yd.autotestplatform.util;

import com.google.gson.Gson;
import com.yd.autotestplatform.util.encryptions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.BadPaddingException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>
 *
 * </p>
 * 加密
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-24 13:11
 * @Email: 664720125@qq.com
 */
@SpringBootTest
public class EncryptionUtilsTest {
    // 原始字符串
    private String message = "我是测试原始内容test123";

    @Test
    void aesUtils() throws Exception {
        String key = AESUtils.getKey();
        String encrypt = AESUtils.aesEncrypt(message, key);
        System.out.println("加密后：" + encrypt);
        String decrypt = AESUtils.aesDecrypt(encrypt, key);
        System.out.println("解密后：" + decrypt);
        assertEquals(decrypt, message);


    }

    @Test
    void md5Utils(){
        String md5 = MD5Utils.md5(message);
        System.out.println("加密后：" + md5);
        String md5_1 = MD5Utils.md5WithSalt(message, "123");
        System.out.println("加密后：" + md5_1);
        assertNotEquals(md5, md5_1);
    }

    @Test
    void readKeyStoreUtils() throws Exception {
        String canonicalPath = new File("").getCanonicalPath();
        canonicalPath += "\\src\\test\\java\\com\\yd\\autotestplatform\\util\\yd-alias.keystore";
//        System.out.println(canonicalPath);
        String publicKey = ReadKeyStoreUtils.getStrPublicKeyByBase64(canonicalPath, "yd", "123456");
        byte[] bytesPublicKey = Base64Utils.base64Decode(publicKey);
        String privateKey = ReadKeyStoreUtils.getStrPrivateKeyByBase64(canonicalPath, "yd", "123456", "123456");
        byte[] bytesPrivateKey = Base64Utils.base64Decode(privateKey);

        /*
        公钥加密 私钥解密
         */
        byte[] encryptByPublicKey = RSAUtils.encryptByPublicKey(message.getBytes(StandardCharsets.UTF_8), bytesPublicKey);

        System.out.println("公钥加密后：" + new String(encryptByPublicKey));

        byte[] decryptByPrivateKey = RSAUtils.decryptByPrivateKey(encryptByPublicKey, bytesPrivateKey);
        String decryptByPrivateKeyStr = new String(decryptByPrivateKey);
        System.out.println("私钥解密后：" + decryptByPrivateKeyStr);
        assertEquals(message, decryptByPrivateKeyStr);

        /*
        私钥加密，公钥解密
         */
        byte[] encryptByPrivateKey = RSAUtils.encryptByPrivateKey(message.getBytes(StandardCharsets.UTF_8), bytesPrivateKey);
        System.out.println("私钥加密后：" + new String(encryptByPrivateKey));
        byte[] decryptByPublicKey = RSAUtils.decryptByPublicKey(encryptByPrivateKey, bytesPublicKey);
        String decryptByPublicKeyStr = new String(decryptByPublicKey);
        System.out.println("公钥解密后：" + decryptByPublicKeyStr);

        assertEquals(message, new String(decryptByPublicKey));
    }

    @Test
    void rsaUtils() throws Exception {
        Map<String, Object> initKey = RSAUtils.initKey();
        byte[] publicKey = RSAUtils.getPublicKey(initKey);
        byte[] privateKey = RSAUtils.getPrivateKey(initKey);

                /*
        公钥加密 私钥解密
         */
        byte[] encryptByPublicKey = RSAUtils.encryptByPublicKey(message.getBytes(StandardCharsets.UTF_8), publicKey);

        System.out.println("公钥加密后：" + new String(encryptByPublicKey));

        byte[] decryptByPrivateKey = RSAUtils.decryptByPrivateKey(encryptByPublicKey, privateKey);
        String decryptByPrivateKeyStr = new String(decryptByPrivateKey);
        System.out.println("私钥解密后：" + decryptByPrivateKeyStr);
        assertEquals(message, decryptByPrivateKeyStr);

        /*
        私钥加密，公钥解密
         */
        byte[] encryptByPrivateKey = RSAUtils.encryptByPrivateKey(message.getBytes(StandardCharsets.UTF_8), privateKey);
        System.out.println("私钥加密后：" + new String(encryptByPrivateKey));
        byte[] decryptByPublicKey = RSAUtils.decryptByPublicKey(encryptByPrivateKey, publicKey);
        String decryptByPublicKeyStr = new String(decryptByPublicKey);
        System.out.println("公钥解密后：" + decryptByPublicKeyStr);

        assertEquals(message, new String(decryptByPublicKey));

        /*
        公钥加密，公钥解密 报错
         */
        assertThrows(BadPaddingException.class, ()->{
            RSAUtils.decryptByPublicKey(encryptByPublicKey, publicKey);
        });

        /*
        私钥加密，私钥解密 报错
         */
        assertThrows(BadPaddingException.class, ()->{
            RSAUtils.decryptByPrivateKey(encryptByPrivateKey, privateKey);
        });
    }


    @Test
    void sha256Utils_1(){
        // sha256 同一个字符串，多次加密的值不一样？？？
        String st = "ed58fda863702b7cfed2b6be25a0ef69d9e17d718cb2782adae1a96503acb7f3";
        String sha256_1 = Sha256Utils.getSHA256(message);
        String sha256_2 = Sha256Utils.getSHA256(message);
        System.out.println("sha256 第一次加密：" + sha256_1);
        System.out.println("sha256 第二次加密：" + sha256_2);
        assertNotEquals(sha256_1, sha256_2);
    }

    @Test
    void sha256Utils(){

//        Sha256Entiy sha256Entiy = new Sha256Entiy();
//        sha256Entiy.setName("yd");
//        sha256Entiy.setAge(28);
//        sha256Entiy.setGender("男");
//        System.out.println(sha256Entiy.toString());
//
        String st = "{name='yd', age=18, gender='男'}";
        Sha256Entiy sha256Entiy = new Gson().fromJson(st, Sha256Entiy.class);
        String sign = getSign(sha256Entiy);
//        System.out.println(st + " 签名的值为： " + sign);
        sha256Entiy.setSign(sign);
        System.out.println("正确的参数：" + sha256Entiy);

        st = "{name='yd', age=98, gender='男', sign='938c92e2451a046036322fcc49c7d1499ef989f57ee55374f0825c1e19b1ce8e'}";
        System.out.println("篡改后参数：" + st);
        sha256Entiy= new Gson().fromJson(st, Sha256Entiy.class);
        String sign_1 = getSign(sha256Entiy);
        System.out.println("签名的值为： " + sign_1);

        if(sign_1.equals(sha256Entiy.getSign())){
            System.out.println("签名正确");
        }else {

            System.out.println("签名错误");
        }
        assertNotEquals(sign, sign_1);
//
//        sha256Entiy_1.setSign(sign_1);
//
//        System.out.println("正确的参数：" + sha256Entiy);
//
//        System.out.println("被篡改的参数：" + sha256Entiy_1);
    }

    private String getSign(Sha256Entiy sha256Entiy){
        /*
        自定义签名算法：name、age、gender对应的值合并后，在加上slat:test321
         */
        String sing = sha256Entiy.getName() + Integer.toString(sha256Entiy.getAge()) + sha256Entiy.getGender() + "test321";
        return Sha256Utils.getSHA256(sing);
    }
}
