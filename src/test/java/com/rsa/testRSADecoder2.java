package com.rsa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.SimpleDateFormat;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import com.aaa.rsa.RSAUtils;


public class testRSADecoder2 {
	private static final int MAX_DECRYPT_BLOCK = 128;
	private final int MAX_ENCRYPT_BLOCK = 117;
	private RSAPublicKey publicKey;
	private static RSAPrivateKey privateKey;
	private Cipher cipher;
	@Test
	public void test() throws Exception {
		
		try {
			//加密
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			File pubFile = ResourceUtils.getFile("classpath:pub.key");
			System.out.println(pubFile.getAbsolutePath());
			FileInputStream pubfis = new FileInputStream(pubFile);
			ObjectInputStream pubbis = new ObjectInputStream(pubfis);
			Object objectpub = pubbis.readObject();
            pubbis.close();
            publicKey = (RSAPublicKey)objectpub;
            byte[] b=publicKey.getEncoded();
            Base64 b64 = new Base64();
            System.out.println(b64.encodeAsString(b));
            //String ming="78791adb-bd85-451c-9ce3-2bc219abe1cd&"+sdf.format(new Date());
            String ming="ocr.jd.com@"+System.currentTimeMillis();
            String mi = RSAUtils.encryptByPublicKey(ming, publicKey);
    		System.out.println("mi:"+mi); 
    		System.out.println(mi.length());
			//解密
			File priFile = ResourceUtils.getFile("classpath:pri.key");
			System.out.println(priFile.getAbsolutePath());
			FileInputStream fis = new FileInputStream(priFile);
			ObjectInputStream bis = new ObjectInputStream(fis);
			Object object = bis.readObject();
			bis.close();
			privateKey = (RSAPrivateKey)object;
			ming = RSAUtils.decryptByPrivateKey(mi, privateKey);
			System.err.println("ming:"+ming);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
