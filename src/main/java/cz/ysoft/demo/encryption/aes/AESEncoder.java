package cz.ysoft.demo.encryption.aes;

import cz.ysoft.demo.encryption.Encoder;

public class AESEncoder implements Encoder {

	private static final Encoder INSTANCE = new AESEncoder();

	public static Encoder getInstance() {
		return INSTANCE;
	}

	@Override
	public String encode(String c) {
		return "Not yet implemented";
	}

	@Override
	public String decode(String c) {
		return "Not yet implemented";
	}

}
