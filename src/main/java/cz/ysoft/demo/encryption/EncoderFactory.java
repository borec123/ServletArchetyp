package cz.ysoft.demo.encryption;

import cz.ysoft.demo.encryption.aes.AESEncoder;
import cz.ysoft.demo.encryption.des.DESEncoder;
import cz.ysoft.demo.encryption.morse.MorseEncoder;

public class EncoderFactory {

	public static Encoder createEncoder(String algorithm) {
		switch(algorithm) {
		case "AES":
			return AESEncoder.getInstance();
		case "DES":
			return DESEncoder.getInstance();
		case "Morse":
			return MorseEncoder.getInstance();
		}
		return null;
	}

}
