package com.datiodb.generator.producer.strategy;

import java.security.SecureRandom;

public class DefaultCountryCodeStrategy implements DataProducerStrategy<String> {
	
	private static final String[] COUNTRIES=new String[]{"854","124","208","250","428"};

	@Override
	public String create() {
		SecureRandom rnd=new SecureRandom();
		return COUNTRIES[rnd.nextInt(COUNTRIES.length)];
	}

}
