package cz.ysoft.demo.encryption;

import org.junit.Test;

import cz.ysoft.demo.encryption.morse.MorseEncoder;

public class MorseEncoderTest {

	private MorseEncoder INSTANCE = new MorseEncoder();

	@Test
	public void testLongEnglishText() {
		String str = "Older versions of Total Commander were packed with the EXE packer UPX. " + 
				"This makes the program itself much smaller. Unfortunately some virus " + 
				"scanners do not like packed executables. They either take an awful lot\r\n" + 
				"of time to scan the program each time you try to start it, or they\r\n" + 
				"report a suspicious file. " + 
				"Older versions of Total Commander were packed with the EXE packer UPX. " + 
				"This makes the program itself much smaller. Unfortunately some virus " + 
				"scanners do not like packed executables. They either take an awful lot\r\n" + 
				"of time to scan the program each time you try to start it, or they\r\n" + 
				"report a suspicious file. ";
		
		testEncodeAndDecode(str);
	}

	@Test
	public void testSlovakText() {
		String str = "\u010Co hovor\u00ED\u0161 kokot ? ";
		testEncodeAndDecode(str);
	}

	@Test
	public void testEmptyText() {
		String str = "";
		testEncodeAndDecode(str);
	}

	@Test
	public void testNull() {
		String str = null;
		testEncodeAndDecode(str);
	}

	private void testEncodeAndDecode(String str) {
		long start = System.nanoTime();
		String result = INSTANCE.encode(str);
		long end = System.nanoTime();
		System.out.println(result );
		System.out.println("Encode time (ms): " + (double)(end - start) / 1000000);
		
		str = result; //"--- .-.. -.. . .-. ...- . .-. ... .. --- -. ... --- ..-. - --- - .- .-.. -.-. --- -- -- .- -. -.. . .-. .-- . .-. . .--. .- -.-. -.- . -.. .-- .. - .... - .... . . -..- . .--. .- -.-. -.- . .-. ..- .--. -..- - .... .. ... -- .- -.- . ... - .... . .--. .-. --- --. .-. .- -- .. - ... . .-.. ..-. -- ..- -.-. .... ... -- .- .-.. .-.. . .-. ..- -. ..-. --- .-. - ..- -. .- - . .-.. -.-- ... --- -- . ...- .. .-. ..- ... ... -.-. .- -. -. . .-. ... -.. --- -. --- - .-.. .. -.- . .--. .- -.-. -.- . -.. . -..- . -.-. ..- - .- -... .-.. . ... - .... . -.-- . .. - .... . .-. - .- -.- . .- -. .- .-- ..-. ..- .-.. .-.. --- - --- ..-. - .. -- . - --- ... -.-. .- -. - .... . .--. .-. --- --. .-. .- -- . .- -.-. .... - .. -- . -.-- --- ..- - .-. -.-- - --- ... - .- .-. - .. - --- .-. - .... . -.-- .-. . .--. --- .-. - .- ... ..- ... .--. .. -.-. .. --- ..- ... ..-. .. .-.. . --- .-.. -.. . .-. ...- . .-. ... .. --- -. ... --- ..-. - --- - .- .-.. -.-. --- -- -- .- -. -.. . .-. .-- . .-. . .--. .- -.-. -.- . -.. .-- .. - .... - .... . . -..- . .--. .- -.-. -.- . .-. ..- .--. -..- - .... .. ... -- .- -.- . ... - .... . .--. .-. --- --. .-. .- -- .. - ... . .-.. ..-. -- ..- -.-. .... ... -- .- .-.. .-.. . .-. ..- -. ..-. --- .-. - ..- -. .- - . .-.. -.-- ... --- -- . ...- .. .-. ..- ... ... -.-. .- -. -. . .-. ... -.. --- -. --- - .-.. .. -.- . .--. .- -.-. -.- . -.. . -..- . -.-. ..- - .- -... .-.. . ... - .... . -.-- . .. - .... . .-. - .- -.- . .- -. .- .-- ..-. ..- .-.. .-.. --- - --- ..-. - .. -- . - --- ... -.-. .- -. - .... . .--. .-. --- --. .-. .- -- . .- -.-. .... - .. -- . -.-- --- ..- - .-. -.-- - --- ... - .- .-. - .. - --- .-. - .... . -.-- .-. . .--. --- .-. - .- ... ..- ... .--. .. -.-. .. --- ..- ... ..-. .. .-.. . "; 
		
		start = System.nanoTime();
		result = INSTANCE.decode(str);
		end = System.nanoTime();
		System.out.println(result );
		System.out.println("Decode time (ms): " + (double)(end - start) / 1000000);
	}

}
