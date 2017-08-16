package com.rsa;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

import org.junit.Test;

import com.aaa.rsa.RSAUtils;

public class testRSA {

	@Test
	public void test() throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = RSAUtils.getKeys();
		// 生成公钥和私钥
		RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
		RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");

		// 模
		String modulus = publicKey.getModulus().toString();
		// 公钥指数
		String public_exponent = publicKey.getPublicExponent().toString();
		// 私钥指数
		String private_exponent = privateKey.getPrivateExponent().toString();
		System.out.println(public_exponent);
		System.out.println(private_exponent);
		// 明文;
		String ming = "8ad0485e-5d42-11e7-ac17-507b9dce3529";
		// 使用模和指数生成公钥和私钥
		RSAPublicKey pubKey = RSAUtils.getPublicKey(modulus, public_exponent);
		RSAPrivateKey priKey = RSAUtils.getPrivateKey(modulus, private_exponent);
		// 加密后的密文
		String mi = RSAUtils.encryptByPublicKey(ming, pubKey);
		System.out.println(mi);
		System.out.println(mi.length());
		
		// 解密后的明文
		ming = RSAUtils.decryptByPrivateKey(mi, priKey);
		System.err.println(ming);
	}
}
