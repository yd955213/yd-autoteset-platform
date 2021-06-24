package com.yd.autotestplatform.util.encryptions;

import com.yd.autotestplatform.util.Base64Utils;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * <p>
 *  从证书获取中公钥和私钥
 * </p>
 * <p>
 *     1、生成证书，cd 到java 的bin目录，
 *     .\keytool.exe -genkeypair -alias yd -keypass 123456 -keyalg RSA -keysize 1024 -validity 365 -keystore E:\testingEnvironment\yd-alias.keystore -storepass 123456
 *     2、查看证书：
 *     .\keytool.exe -list -v -keystore E:\testingEnvironment\yd-alias.keystore
 *     或者
 *     .\keytool.exe -list -rfc -keystore E:\testingEnvironment\yd-alias.keystore
 * </p>
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-24 12:53
 * @Email: 664720125@qq.com
 */
public class ReadKeyStoreUtils {
    /**
     * Java密钥库(Java Key Store，JKS)KEY_STORE
     */
    public static final String KEY_STORE = "JKS";

    public static final String X509 = "X.509";


    /**
     * 获得KeyStore
     * @param keyStorePath
     * @param password
     * @return
     * @throws Exception
     */
    private static KeyStore getKeyStore(String keyStorePath, String password)

            throws Exception {

        FileInputStream is = new FileInputStream(keyStorePath);

        KeyStore ks = KeyStore.getInstance(KEY_STORE);

        ks.load(is, password.toCharArray());

        is.close();

        return ks;

    }

    /**
     * 由KeyStore获得私钥
     * @param keyStorePath
     * @param alias
     * @param storePass
     * @param keyPass
     * @return
     * @throws Exception
     */
    private static PrivateKey getPrivateKey(String keyStorePath, String alias, String storePass, String keyPass) throws Exception {

        KeyStore ks = getKeyStore(keyStorePath, storePass);

        PrivateKey key = (PrivateKey) ks.getKey(alias, keyPass.toCharArray());

        return key;

    }

    /**
     * 由Certificate获得公钥
     * @param keyStorePath
     * @param alias
     * @param storePass
     * @return
     * @throws Exception
     */
    private static PublicKey getPublicKey(String keyStorePath, String alias, String storePass) throws Exception {

        KeyStore ks = getKeyStore(keyStorePath, storePass);

        PublicKey key = ks.getCertificate(alias).getPublicKey();

        return key;

    }

    /**
     * 从KeyStore中获取公钥，并经BASE64编码
     * @param keyStorePath
     * @param alias
     * @param storePass
     * @return
     * @throws Exception
     */
    public static String getStrPublicKeyByBase64(String keyStorePath, String alias, String storePass) throws Exception {

        PublicKey key = getPublicKey(keyStorePath, alias, storePass);

        String strKey = Base64Utils.base64Encode(key.getEncoded());

        return strKey;

    }

    /**
     * 获取经BASE64编码后的私钥
     * @param keyStorePath
     * @param alias
     * @param storePass
     * @param keyPass
     * @return
     * @throws Exception
     */

    public static String getStrPrivateKeyByBase64(String keyStorePath, String alias, String storePass, String keyPass) throws Exception {

        PrivateKey key = getPrivateKey(keyStorePath, alias, storePass, keyPass);

        String strKey = Base64Utils.base64Encode(key.getEncoded());

        return strKey;

    }

}
