package cz.ysoft.demo.encryption.des;

import cz.ysoft.demo.encryption.Encoder;

public class DESEncoder implements Encoder {

	private static final Encoder INSTANCE = new DESEncoder();

	public static Encoder getInstance() {
		return INSTANCE;
	}

	@Override
	public String encode(String c) {
		return null;
	}

	@Override
	public String decode(String c) {
		return null;
	}

}
