package com.train.utils;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.nio.charset.Charset;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;


/**
 * 非对称加密算法RSA算法组件
 * 非对称算法一般是用来传送对称加密算法的密钥来使用的，相对于DH算法，RSA算法只需要一方构造密钥，不需要
 * 大费周章的构造各自本地的密钥对了。DH算法只能算法非对称算法的底层实现。而RSA算法算法实现起来较为简单
 *
 * @author kongqz
 */
public class RSAUtils {
    //非对称密钥算法
    public static final String KEY_ALGORITHM = "RSA";


    /**
     * 密钥长度，DH算法的默认密钥长度是1024
     * 密钥长度必须是64的倍数，在512到65536位之间
     */
    private static final int KEY_SIZE = 1024;
    //公钥
    private static final String PUBLIC_KEY = "RSAPublicKey";

    //私钥
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * 初始化密钥对
     *
     * @return Map 甲方密钥的Map
     */
    public static Map<String, Object> initKey() throws Exception {
        //实例化密钥生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        //初始化密钥生成器
        keyPairGenerator.initialize(KEY_SIZE);
        //生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //甲方公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        //甲方私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        //将密钥存储在map中
        Map<String, Object> keyMap = new HashMap<String, Object>();
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;

    }

    /**
     * 公钥加密
     *
     * @param encodeStr 待加密数据
     * @param encodeStr  密钥
     * @return byte[] 加密数据
     */
    public static String encryptByPublicKey(String encodeStr, String publicKey)  {
        try{
            byte[] data = encodeStr.getBytes();
            byte[] keyBytes = Base64.decodeBase64(publicKey.getBytes());
            byte[] code2 = RSAUtils.encryptByPublicKey(data, keyBytes);
            return Base64.encodeBase64String(code2);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


    /**
     * 公钥加密
     *
     * @param data 待加密数据
     * @param key  密钥
     * @return byte[] 加密数据
     */
    public static byte[] encryptByPublicKey(byte[] data, byte[] key) throws Exception {

        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //初始化公钥
        //密钥材料转换
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
        //产生公钥
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);

        //数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        return cipher.doFinal(data);
    }

    /**
     * 私钥解密
     *
     * @param encodeStr 待解密数据
     * @param privateKey  密钥
     * @return byte[] 解密数据
     */
    public static String decryptByPrivateKey(String encodeStr, String privateKey) {
        try{
            byte[] decode2 = RSAUtils.decryptByPrivateKey(Base64.decodeBase64(encodeStr), Base64.decodeBase64(privateKey));

            return new String(decode2, Charset.forName("utf8"));
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 私钥解密
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return byte[] 解密数据
     */
    public static byte[] decryptByPrivateKey(byte[] data, byte[] key) throws Exception {
        //取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        //数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }


    /**
     * 取得私钥
     *
     * @param keyMap 密钥map
     * @return byte[] 私钥
     */
    public static byte[] getPrivateKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return key.getEncoded();
    }

    /**
     * 取得公钥
     *
     * @param keyMap 密钥map
     * @return byte[] 公钥
     */
    public static byte[] getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        String  publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCfZxysy2HTsaUngIkZrew8FWm0SUrJ34WnCWjJnRC1ng5iqrvsx1aMWRc1gYtDUpSg4eY5a7oFfek8RN7+jFT5VhRqUHg5MMwpUQG+vmdeTLgxtM/1rk0G8I1iGDNitXd/hxl4JRAngHlWrIZ7l3ks7m/Cop/bP1E9hUDccCtdIQIDAQAB";
        //私钥
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ9nHKzLYdOxpSeAiRmt7DwVabRJSsnfhacJaMmdELWeDmKqu+zHVoxZFzWBi0NSlKDh5jlrugV96TxE3v6MVPlWFGpQeDkwzClRAb6+Z15MuDG0z/WuTQbwjWIYM2K1d3+HGXglECeAeVashnuXeSzub8Kin9s/UT2FQNxwK10hAgMBAAECgYAe10xtAkzDMLPLmMrt9QCn/1ycTTHzLRQm5WMo3wLEoPgXjwEdJtRQA0zCRXY0aF3pYsuwgG9VcK8XwhuDFJO7+zYrcgQ2s2Ka1mLKBKgV25vOAd/c1X1rAGoPR8nPT3klBYUiferdqwclWACCqH6SP6ErQPHQDVHsOtPgWnjyoQJBAOl6Pwr/DcK0HzQj+DRm2kczwerT4ImRZENYeHdiTQLLIRLtnTdEj3YoUMDUs1oEm8JC1ASGppRkdIyahK9UabsCQQCux5Tl3SHoqCVjfvVjrkEUgSx8BC8zYqGW+iCqzwDWMn8bS4MA6EVjNrBV2kS/SbXfYySFSNURm6xy6fP4iSjTAkEAkkNi+yCNHkx4v9FIzIsicziZYuMY5xWOGiJyVVffpsBaF+GDe/wXY44eCK83LE12xlvXNn6kHJJR8UNbm/rlwQJADLPOm4Idw8XsqbWBahQxAKd+ryiysX5alhlppGBVBDw5RqePRtKasGI6IJMzad+WizyuW812RshUmSltpMN7JwJAU6Z6q2O/Rr5t5S0FwFUPtxql9sRyvlgmEAxTqDhGrmiXVqKaFG7t3Qr36fCI5Dvrsi5B1BG28yB6QIgcx3dkYA==";

        String uuid = "XEEANNnen==aaa=eee-xxxxa";

        //平台|uuid|服务器凭证|随机数|时间|随机数
        Long time = System.currentTimeMillis();
        String mobileToken = "1|XEEANNnen==aaa=eee-xxxxa|SLGyzQ71|12|" +time+"|13";

        //String mobile = "18911439763";

        String passwd = "123&123";

        //String mobileCode = "514028";
        time = System.currentTimeMillis();
        String loginToken = "1|6|XEEANNnen==aaa=eee-xxxxa|12|18911439763|" +
                time +
                "|15649850495781|12";

        String str = loginToken;

        //乙方使用公钥对数据进行加密
        String code2 = RSAUtils.encryptByPublicKey(str,publicKey);
        System.out.println("加密后的数据：" + code2);
        //甲方使用私钥对数据进行解密
        String decode2 = RSAUtils.decryptByPrivateKey(code2, privateKey);
        System.out.println("甲方解密后的数据：" + decode2);

        //decode2 = RSAUtils.decryptByPrivateKey("ezsKI79UjWoUh4CzfvXaDgIPaq6nMsDFHeuqaPLDeluYRyhgyNkeclbj7BoTeHdf6788AHxp02fcUh0O+hBi7OVqalgb8xnCdbiIo3FWgwuIKAv7GQ+CbeSdANvRdvXGBevrjRTTCIYEmkMdevjYsE2xIKApT9J72XKt0abioNY=", privateKey);
       // System.out.println("甲方解密后的数据：" + decode2);



    }
}