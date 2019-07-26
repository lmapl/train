package com.train.utils;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSAUtils {

	public static final String KEY_ALGORITHM = "RSA";
	private static final int MAX_ENCRYPT_BLOCK = 117;
	private static final int MAX_DECRYPT_BLOCK = 128;
	public static final String ENCODING = "utf-8";

	/**
	 * 使用公钥进行加密
	 * 
	 * @param encodeStr
	 *            待加密的内容
	 * @param publicKey
	 *            公钥
	 * @return
	 * @throws Exception
	 */
	public static String encryptByPublicKey(String encodeStr, String publicKey) throws Exception {
		byte[] data = encodeStr.getBytes();
		byte[] keyBytes = Base64.decodeBase64(publicKey.getBytes(ENCODING));
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return new String(Base64.encodeBase64(encryptedData), "UTF-8");
	}

	/**
	 * 使用私钥进行解密
	 * 
	 * @param data
	 *            待解密的内容
	 * @param privateKey
	 *            私钥
	 * @return
	 * @throws Exception
	 */
	public static String decryptByPrivateKey(String data, String privateKey) throws Exception {
		byte[] encryptedData = Base64.decodeBase64(data);
		byte[] keyBytes = Base64.decodeBase64(privateKey.getBytes(ENCODING));
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return new String(decryptedData, "UTF-8");
	}

	public static void genKeyPair() throws NoSuchAlgorithmException {
		// KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		// 初始化密钥对生成器，密钥大小为96-1024位
		keyPairGen.initialize(1024,new SecureRandom());
		// 生成一个密钥对，保存在keyPair中
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
		String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
		// 得到私钥字符串
		String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
		// 将公钥和私钥保存到Map
		System.out.println("publicKeyString==="+publicKeyString);
		System.out.println("privateKeyString==="+privateKeyString);
	}

	public static void main(String[] args) throws Exception{

		RSAUtils.genKeyPair();


		String publicKeyString= "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCmxa0X0DMW/QFNxqeKIVgVGDfrpCUnOdwH54oK6u2Ay5DdBA/iAa/6XxxOgxdITff8J0k9Pmqk7ZhJC0gCbRW2RWa5ixnjDrJOdlfJ6PBd6Oeuke1FU/YQ4ytd8edUNr+m9yp5Q9EPCn56ZFNUZ7+wRTQLCca7Qv74eHq5v1mKiQIDAQAB";
		String privateKeyString="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKbFrRfQMxb9AU3Gp4ohWBUYN+ukJSc53Afnigrq7YDLkN0ED+IBr/pfHE6DF0hN9/wnST0+aqTtmEkLSAJtFbZFZrmLGeMOsk52V8no8F3o566R7UVT9hDjK13x51Q2v6b3KnlD0Q8KfnpkU1Rnv7BFNAsJxrtC/vh4erm/WYqJAgMBAAECgYBIE37vn8e007vQhV67UBXlaAYjDVoRTexObj824LmsxE3jd3H114zaxGhTdkyFr0zR6Zi5o1Qr25PJXdrNUZ/j5vMqXuu27hYOEbQu8gbrJgBuwq0v2qOgt7kKCLJ9TUyySDulW2Z5Zr6ML8tS9lVmi1FMb9tod0KqIQHmAAHLkQJBAOdlccCMHm0973anYucjapfkk1hjzepvMUhBMHDM+5NbFQMocOi7YOglFWMm04hC3UuJ3nKZlVInc46hvGzJIrsCQQC4gS2Y+BPcqhfaCImoac7dpsO0yIfdCmd5a86M9NZhbnrXyoX10kia9NOKIEt+/eH46C3PLcvJeqEdp50HlZ2LAkAGCoj4vO/CbF6HG4GihTMwOgB6y0hB+ZswxrrsBv3+b99RkMm52cKC7Qzs5MObCBvc8AGFvmq+lVcX/zL7KBknAkEAkCDA+NzZzyfEKBtBRaEZ6wYJnWCE2YP2HuC7YlskWMoQBh/7k3LoKrwTv7PIpfQ3oNPmbRBOQB6eW2cDANi8TwJBAIPKUBBFJNoTUPW1g4VmshBQv0oGLEydQw+zn3mKpE/He82gRsy5giwj8ydPiBrwXXw2NReLdGCJ9e6UcZX6Ku0=";


		Map<String,String> object = new HashMap<>();
		object.put("userId", "1");
		object.put("city", "北京");
		object.put("locatedCity", "北京");
		object.put("latitude", "135.1");
		object.put("longitude", "35.6");
		object.put("clientVersion", "1.0.0");
		object.put("token", "1sadasd");
		String ss = new Gson().toJson(object);
		ss = encryptByPublicKey(object.toString(), publicKeyString);
		System.out.println(ss);
		System.out.println(decryptByPrivateKey(ss,privateKeyString));
	}
}
