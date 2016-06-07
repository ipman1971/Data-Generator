package com.datiodb.generator.producer.strategy;

import java.security.SecureRandom;

public class DefaultCountryStrategy implements DataProducerStrategy<String> {
	
	private static final String[] COUNTRIES=new String[]{"USA","FRANCE","GERMANY","SPAIN","ITALY"};

	@Override
	public String create() {
		SecureRandom rnd=new SecureRandom();
		return COUNTRIES[rnd.nextInt(COUNTRIES.length)];
	}

}
