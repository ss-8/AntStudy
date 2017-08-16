package com.rsa;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.Test;
import org.springframework.util.ResourceUtils;


public class testRSADecoder {
	private static final int MAX_DECRYPT_BLOCK = 128;
	private final int MAX_ENCRYPT_BLOCK = 117;
	private RSAPublicKey publicKey;
	private static RSAPrivateKey privateKey;
	private Cipher cipher;
	@Test
	public void test() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		try {
			//加密
			File pubFile = ResourceUtils.getFile("classpath:pub.key");
			FileInputStream pubfis = new FileInputStream(pubFile);
			ObjectInputStream pubbis = new ObjectInputStream(pubfis);
			Object objectpub = pubbis.readObject();
            pubbis.close();
            publicKey = (RSAPublicKey)objectpub;
            System.out.println(publicKey.getAlgorithm());
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] data="9cdf9a7a-e649-4721-910b-07d5375f900b".getBytes();
            System.out.println("data:"+new String(data));
            System.out.println("data.length:"+data.length);
            int inputLen1 = data.length;
            ByteArrayOutputStream out1 = new ByteArrayOutputStream();
            int offSet1 = 0;
            byte[] cache1;
            int i1 = 0;
            // 对数据分段加密
            while (inputLen1 - offSet1 > 0) {
                if (inputLen1 - offSet1 > MAX_ENCRYPT_BLOCK) {
                    cache1 = cipher.doFinal(data, offSet1, MAX_ENCRYPT_BLOCK);
                } else {
                    cache1 = cipher.doFinal(data, offSet1, inputLen1 - offSet1);
                }
                System.out.println("cache1.length:"+cache1.length);
                out1.write(cache1, 0, cache1.length);
                i1++;
                offSet1 = i1 * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out1.toByteArray();
            out1.close();
            System.out.println("encryptedData.length:"+encryptedData.length);
            
            System.out.println("encryptedData:"+new String(encryptedData));
			//解密
			File priFile = ResourceUtils.getFile("classpath:pri.key");
			System.out.println(priFile.getAbsolutePath());
			FileInputStream fis = new FileInputStream(priFile);
			ObjectInputStream bis = new ObjectInputStream(fis);
			Object object = bis.readObject();
			bis.close();
			privateKey = (RSAPrivateKey)object;
			cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            int inputLen = encryptedData.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            System.out.println(inputLen);
            // 对数据分段解密
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
            System.out.println(decryptedData.length);
            System.out.println(new String(decryptedData));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
