package cz.ysoft.demo.encryption;

public interface Encoder {
	public String encode(String c) throws Exception;
	public String decode(String c)  throws Exception;
}
