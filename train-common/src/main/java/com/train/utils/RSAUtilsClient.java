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
public class RSAUtilsClient {
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
            byte[] code2 = RSAUtilsClient.encryptByPublicKey(data, keyBytes);
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
            byte[] decode2 = RSAUtilsClient.decryptByPrivateKey(Base64.decodeBase64(encodeStr), Base64.decodeBase64(privateKey));

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

        String  publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCG65AbyBmgXYgepKZHcTT1i/gSQLPZNvUwv/l7fvn8DH8BQChWCXJW7Ngr4PGun7dtQM/NH8MMtkHOfWsl/dpRWX07dfAb78tb595jJllMoLcc0VHYWa0rji3A171nDYUX1rMoQR6sorJm9f/VDHIe5EPbpRVbAxc9lwv6fSJ/ZQIDAQAB";
        //私钥
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIbrkBvIGaBdiB6kpkdxNPWL+BJAs9k29TC/+Xt++fwMfwFAKFYJclbs2Cvg8a6ft21Az80fwwy2Qc59ayX92lFZfTt18Bvvy1vn3mMmWUygtxzRUdhZrSuOLcDXvWcNhRfWsyhBHqyismb1/9UMch7kQ9ulFVsDFz2XC/p9In9lAgMBAAECgYEAhn3xJFB+gyZZVzqH6nWF9jN1sTRAU4n+Nn9XwWxc44zNWcDLtKAsE0x7XJoaMRlTLpxJyM8djuFrjdvl4HRBmBz7PAhBnFlX4Jk9mEac1DQ75OXDDWY5JF7wg1qYSHbPUJVNX1MbgTFp9vIz3K8KqpcV97p/hB0SpuO4uA/0meECQQDE2GtbLlyi2fqGtjjXZgiK6W23x92RBeGMExzcqsq3bWqEWTT5SpVz3LAhDmMQmr0FRNOVMJOIo4vb1A6OUGp9AkEAr3cnK6rHH1BCJ8qWH+wigJXt4qalzanMcX3S4uRr7dudXNR3uHBRNNVoOTa3G9TmO0UV5JyJc7V59b+j4+SVCQJAaFjlSBeiib2NfZ3ZMe3nt2OYguTTQk5gyvVSxnNPNL8uyOvVFhWAdkPVpiBPSX0NmF5s3tg6TSONP0IBWVWtrQJBAKribmGWtsqGTYeXQ1HflVKJsd300rFTVuqI0eNq9rn2EnGf8uDLcir0U8a0xOv0Ei1TARleYncwHJD7jM+bhJECQA/kr7IvQfeCJGUUVMk14CIoEum/nFCh1w+/yj/erl0p6c5ldRiqVU+MH+yWijSwDB5fBf3iQdjx69AjEIj9h5Y=";

        String uuid = "XEEANNnen==aaa=eee-xxxxa";

        String str = uuid;

        //乙方使用公钥对数据进行加密
        String code2 = RSAUtilsClient.encryptByPublicKey(str,publicKey);
        System.out.println("加密后的数据：" + code2);
        //甲方使用私钥对数据进行解密
        String decode2 = RSAUtilsClient.decryptByPrivateKey(code2, privateKey);
        System.out.println("甲方解密后的数据：" + decode2);

        decode2 = RSAUtilsClient.decryptByPrivateKey("" +
                "JXH53+Jj4JsQQWvymM2uawv7zI4+m3fPAQE4lOTirOFzkaaFCFiqMr3a8fjinszYEr1adTYyPGwJYK8PP+p8EelhARWEGwExuZ4/6Jf4izsmvk8yvdde5FIBB/ylObiin6/g7o2ecNS7+ggH53zKV0cQFqX8S0jkvDaUBYGV7+M=" +
                "", privateKey);
        System.out.println("甲方解密后的数据：" + decode2);

    }
}