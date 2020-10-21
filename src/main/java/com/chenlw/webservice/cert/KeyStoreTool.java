package com.chenlw.webservice.cert;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * 证书工具类
 *
 * @author chenlw 2020-10-21
 * @since
 */
public class KeyStoreTool {

    public static void main(String args[]) {
        // 公钥
        String strPublicKey = "";
        // 私钥
        String strPrivateKey = "";
        try {
            strPublicKey = KeyStoreTool.getStrPublicKey("d://leslie.keystore", "everygold", "123456");
            System.out.println("公钥 = 【" + strPublicKey + "】");

            strPrivateKey = KeyStoreTool.getStrPrivateKey("d://leslie.keystore", "everygold", "123456", "123456");
            System.out.println("\n私钥 = 【" + strPrivateKey + "】");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    /**
     * Java密钥库(Java Key Store，JKS)KEY_STORE
     */
    public static final String KEY_STORE = "JKS";

    public static final String X509 = "X.509";

    /**
     * 获得KeyStore
     *
     * @param keyStorePath
     * @param password
     * @return
     * @throws Exception
     * @version 2016-3-16
     */
    public static KeyStore getKeyStore(String keyStorePath, String password)
            throws Exception {

        FileInputStream is = new FileInputStream(keyStorePath);
        KeyStore ks = KeyStore.getInstance(KEY_STORE);
        ks.load(is, password.toCharArray());
        is.close();
        return ks;
    }

    /**
     * 由KeyStore获得私钥
     *
     * @param keyStorePath
     * @param alias
     * @param storePass
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String keyStorePath, String alias, String storePass, String keyPass) throws Exception {
        KeyStore ks = getKeyStore(keyStorePath, storePass);
        PrivateKey key = (PrivateKey) ks.getKey(alias, keyPass.toCharArray());
        return key;
    }

    /**
     * 由Certificate获得公钥
     *
     * @param keyStorePath KeyStore路径
     * @param alias        别名
     * @param storePass    KeyStore访问密码
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String keyStorePath, String alias, String storePass) throws Exception {
        KeyStore ks = getKeyStore(keyStorePath, storePass);
        PublicKey key = ks.getCertificate(alias).getPublicKey();
        return key;
    }

    /**
     * 从KeyStore中获取公钥，并经BASE64编码
     *
     * @param keyStorePath
     * @param alias
     * @param storePass
     * @return
     * @throws Exception
     */
    public static String getStrPublicKey(String keyStorePath, String alias, String storePass) throws Exception {
        PublicKey key = getPublicKey(keyStorePath, alias, storePass);
        String strKey = Coder.encryptBASE64(key.getEncoded());
        return strKey;
    }

    /*
     * 获取经BASE64编码后的私钥
     * @param keyStorePath
     * @param alias
     * @param storePass
     * @param keyPass
     * @return
     * @throws Exception
     */
    public static String getStrPrivateKey(String keyStorePath, String alias, String storePass, String keyPass) throws Exception {

        PrivateKey key = getPrivateKey(keyStorePath, alias, storePass, keyPass);
        String strKey = Coder.encryptBASE64(key.getEncoded());
        return strKey;
    }
}
