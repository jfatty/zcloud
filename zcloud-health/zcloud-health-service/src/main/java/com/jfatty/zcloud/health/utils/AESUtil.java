package com.jfatty.zcloud.health.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.security.Security;

/**
 * 描述 AES 加密解密
 *
 * @author jfatty on 2020/5/19
 * @email jfatty@163.com
 */
@Slf4j
public class AESUtil implements Serializable {


    /**
     * AES加密
     * @param contentBytes      由uuid&openid&hospitalId拼接的明文
     * @param keyBytes		开放平台分配的appSecret密钥
     * @return
     */
    public static String encrypt(byte[] contentBytes, byte[] keyBytes) {
        try {
            //添加一个安全管理器提供者
            Security.addProvider(new BouncyCastleProvider());
            //根据一个字节数组构造一个 SecretKey
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

            //设置加密类型
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, key); //用于将 Cipher 初始化为加密模式的常量。
            byte[] tmp = cipher.doFinal(contentBytes); //操作加密或解密数据

            //返回Base64后的加密串
            return new String(Base64.encodeBase64(tmp));

        } catch (Exception e) {
            log.error("AES加密出错 错误信息 [{}]",e.getMessage() );
        }
        return null;
    }

    /**
     * AES解密
     *
     * @param contentBytes 加密后的openId字符串
     * @param keyBytes     开放平台分配的appSecret密钥
     * @return
     */
    public static byte[] decrypt(byte[] contentBytes, byte[] keyBytes) {
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] tmp = cipher.doFinal(Base64.decodeBase64(contentBytes));
            return tmp;

        } catch (Exception e) {
            log.error("AES解密 错误信息 [{}]",e.getMessage() );
        }
        return null;
    }


}
