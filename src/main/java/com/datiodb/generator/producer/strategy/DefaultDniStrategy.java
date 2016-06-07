package com.datiodb.generator.producer.strategy;

import java.security.SecureRandom;

public class DefaultDniStrategy implements DataProducerStrategy<String> {
	private static final String LETTER="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String DIGITS="0123456789";

	@Override
	public String create() {
		StringBuffer buffer=new StringBuffer();
		SecureRandom rnd=new SecureRandom();
		for(int i=0;i<8;i++) {
			buffer.append(DIGITS.charAt(rnd.nextInt(DIGITS.length())));
		}
		buffer.append(LETTER.charAt(rnd.nextInt(LETTER.length())));
		return buffer.toString();
	}

}
