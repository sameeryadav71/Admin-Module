package com.cbic.microservices.tickerservice.config;

import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;

public class CryptoEncDec {
	
	@Autowired
	private TickerConfiguration tickerConfiguration;
	
	private static final String encryptAlgorithm = "AES/CBC/PKCS5Padding";
	private static final String secretKeyFactoryAlgorithm = "PBKDF2WithHmacSHA256";
	private static final String keyAlgorithm = "AES";
	private static final int pwdIterations = 65536;
	private static final int keySize = 256;
	private static String pass;
	private static final String secret = "HGHASBD@&%HYIOsnwu$@iwwj";
	private static IvParameterSpec ivspec;
	private static SecretKeySpec secretKey;
	
	
	
	private static String getPass(){
		byte bytes[] = new byte[] {'N','A','G','V','I','G','S','A','N','S','K','R','S','A','G','G','R','P','A','K'};
		String text = new String(bytes);
		return text;
	}

	public static synchronized String encrypt(String strToEncrypt) throws Exception
	{
		try
		{
			Cipher cipherEnc = Cipher.getInstance(encryptAlgorithm);
			cipherEnc.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
			byte[] encryptedText = cipherEnc.doFinal(strToEncrypt.getBytes("UTF-8"));
			String output = Base64.getUrlEncoder().encodeToString(encryptedText);
			 
			 return output;
		}
		catch (Exception e)
		{
			//logger.error("Error while encrypting: ", e);
			throw e;
		}
	}

	public static synchronized String decrypt(String strToDecrypt) throws Exception  {
		try
		{
			Cipher cipherDec = Cipher.getInstance(encryptAlgorithm);
			cipherDec.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
			strToDecrypt = strToDecrypt.replace(" ", "+");
			byte[] encryptTextBytes = Base64.getUrlDecoder().decode(strToDecrypt);
			byte[] decyrptTextBytes = null;
			decyrptTextBytes = cipherDec.doFinal(encryptTextBytes);
			String text = new String(decyrptTextBytes);
			return text;
		}
		catch (Exception e)
		{
			//logger.error("Error while encrypting: " , e);
			throw e;
		}
	}
	
	public static void init() throws Exception
	{
		pass = getPass();

		byte[] passBytes =pass.getBytes("UTF-8");
		byte[] iv = "BADPADDINGWHATTO".getBytes();
		ivspec = new IvParameterSpec(iv);
		SecretKeyFactory factory = SecretKeyFactory.getInstance(secretKeyFactoryAlgorithm);
		KeySpec spec = new PBEKeySpec(secret.toCharArray(), passBytes, pwdIterations, keySize);
		SecretKey tmp = factory.generateSecret(spec);
		secretKey = new SecretKeySpec(tmp.getEncoded(), keyAlgorithm);
	}
	
	public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
