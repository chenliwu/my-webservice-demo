package com.chenlw.webservice.cert;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author chenlw 2020-10-21
 * @since
 */
public abstract class Coder {

    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key).replace("\r", "").replace("\n", "");
    }
}
