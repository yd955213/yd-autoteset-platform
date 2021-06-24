package com.yd.autotestplatform.util;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Base64;

/**
 * <p>
 *
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-24 12:55
 * @Email: 664720125@qq.com
 */
public class Base64Utils {

    /**
     * base 64 encode
     * @param bytes 待编码的byte[]
     * @return 编码后的base 64 code
     */
    public static String base64Encode(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * base 64 decode
     * @param base64Code 待解码的base 64 code
     * @return 解码后的byte[]
     * @throws Exception
     */
    public static byte[] base64Decode(String base64Code) throws Exception{
        return ObjectUtils.isEmpty(base64Code) ? null : Base64.getDecoder().decode(base64Code);
    }
}
