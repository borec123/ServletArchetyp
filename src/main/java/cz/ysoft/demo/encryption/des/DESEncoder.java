package cz.ysoft.demo.encryption.des;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import cz.ysoft.demo.encryption.Encoder;

public class DESEncoder implements Encoder {

	private static final Encoder INSTANCE = new DESEncoder();

    KeyGenerator keygenerator ;
    SecretKey myDesKey ;

    public static Encoder getInstance() {
		return INSTANCE;
	}

	@Override
	public String encode(String c) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
	    Cipher desCipher;

	    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
	    
	    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

	    byte[] text = c.getBytes();

	    byte[] textEncrypted = desCipher.doFinal(text);
	    
	    return "" + textEncrypted;

	}

	public DESEncoder() {
		try {
			keygenerator = KeyGenerator.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
			assert true;
		}
		myDesKey = keygenerator.generateKey();
	}

	@Override
	public String decode(String c) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
	    Cipher desCipher;

	    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
	    
	    desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

	    byte[] text = c.getBytes();

	    byte[] textEncrypted = desCipher.doFinal(text);
	    
	    return new String(textEncrypted);

	}

}
