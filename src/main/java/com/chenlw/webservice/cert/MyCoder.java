package com.chenlw.webservice.cert;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author chenlw 2020-10-21
 * @since
 */
public class MyCoder extends Coder {

    public static void main(String[] args) {
        // 公钥
        String strPublicKey = "";
        // 私钥
        String strPrivateKey = "";

        try {
            strPublicKey = KeyStoreTool.getStrPublicKey("d://leslie.keystore", "everygold", "123456");
            strPrivateKey = KeyStoreTool.getStrPrivateKey("d://leslie.keystore", "everygold", "123456", "123456");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // 原文
        String originalText = "原文 = 虽然我穷，但是再穷也要去旅游！";
        System.out.println(originalText);

        try {
            // RSA算法 公钥加密随机数
            String secretText = MyCoder.encryptByPublicKey(strPublicKey, originalText);
            System.out.println("\n经RSA公钥加密后 = " + secretText);
            System.out.println("\n经RSA公钥加密后长度 = " + secretText.length());

            String text = MyCoder.decryptByPrivateKey(strPrivateKey, secretText);
            System.out.println("\n经RSA私钥解密后 = 【" + text + "】");
            System.out.println("\n经RSA私钥解密后长度 = 【" + text.length() + "】");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用公钥加密数据
     *
     * @param publicKey 公钥
     * @param srcData   要加密的数据
     * @return 加密后的数据
     * @throws Exception 异常
     */
    public static String encryptByPublicKey(String publicKey, String srcData) throws Exception {
        // 解密
        byte[] pk = Coder.decryptBASE64(publicKey);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(pk);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        // 获取公钥
        PublicKey pubKey = kf.generatePublic(spec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);

        byte[] doFinal = cipher.doFinal(srcData.getBytes());
        return encryptBASE64(doFinal);
    }


    /**
     * 使用私钥解密数据
     *
     * @param privateKey 私钥
     * @param data       要解密的密文
     * @return 解密后的数据
     * @throws Exception 异常
     */
    public static String decryptByPrivateKey(String privateKey, String data) throws Exception {
        // BASE64转码解密私钥
        byte[] pk = Coder.decryptBASE64(privateKey);
        // BASE64转码解密密文
        byte[] text = decryptBASE64(data);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(pk);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        // 获取私钥
        PrivateKey prvKey = kf.generatePrivate(spec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, prvKey);

        byte[] doFinal = cipher.doFinal(text);
        return new String(doFinal);
    }

}
