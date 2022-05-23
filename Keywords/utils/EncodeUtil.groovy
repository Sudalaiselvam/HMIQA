package utils

import java.security.GeneralSecurityException

import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.PBEParameterSpec
import javax.xml.bind.DatatypeConverter



public class EncodeUtil {
	public static class Info {
		private String data;

		private String algorithm;

		private byte[] salt;

		private String privateKey;

		private int iteration = 20;

		private String encode = "UTF-8";
	}

	public static Info getDefault(String data) {
		return create("PBEwithSHA1AndDESede", data, "K@tal0n STudlO".getBytes(), "S3cReT K3i");
	}

	public static Info getDefault(String salt, String data) {
		return create("PBEwithSHA1AndDESede", data, salt.getBytes(), "S3cReT K3i");
	}

	public static Info create(String algorithm, String data, byte[] salt, String privateKey) {
		Info cryptoInfo = new Info();
		cryptoInfo.algorithm = algorithm;
		cryptoInfo.data = data;
		cryptoInfo.salt = salt;
		cryptoInfo.privateKey = privateKey;
		return cryptoInfo;
	}

	public static Info create(String algorithmn, String data, byte[] salt, String privateKey, int iteration) {
		Info cryptoInfo = create(algorithmn, data, salt, privateKey);
		cryptoInfo.iteration = iteration;
		return cryptoInfo;
	}

	public static Info create(String algorithmn, String data, byte[] salt, String privateKey, int iteration,
			String encode) {
		Info cryptoInfo = create(algorithmn, data, salt, privateKey, iteration);
		cryptoInfo.encode = encode;
		return cryptoInfo;
	}

	public static String encode(Info cryptoInfo) throws GeneralSecurityException, UnsupportedEncodingException {
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(cryptoInfo.algorithm);
		SecretKey key = keyFactory.generateSecret(new PBEKeySpec(cryptoInfo.privateKey.toCharArray()));
		Cipher pbeCipher = Cipher.getInstance(cryptoInfo.algorithm);
		pbeCipher.init(1, key, new PBEParameterSpec(cryptoInfo.salt, cryptoInfo.iteration));
		return DatatypeConverter.printBase64Binary(pbeCipher.doFinal(cryptoInfo.data.getBytes(cryptoInfo.encode)));
	}

	public static String decode(Info cryptoInfo) throws GeneralSecurityException, IOException {
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(cryptoInfo.algorithm);
		SecretKey key = keyFactory.generateSecret(new PBEKeySpec(cryptoInfo.privateKey.toCharArray()));
		Cipher pbeCipher = Cipher.getInstance(cryptoInfo.algorithm);
		pbeCipher.init(2, key, new PBEParameterSpec(cryptoInfo.salt, cryptoInfo.iteration));
		return new String(pbeCipher.doFinal(DatatypeConverter.parseBase64Binary(cryptoInfo.data)), cryptoInfo.encode);
	}
}
