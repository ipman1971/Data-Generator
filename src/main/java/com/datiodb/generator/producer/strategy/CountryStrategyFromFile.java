package com.datiodb.generator.producer.strategy;

import java.security.SecureRandom;
import java.util.List;

import com.datiodb.generator.from.AbstractDataFromFile;

public class CountryStrategyFromFile extends AbstractDataFromFile implements DataProducerStrategy<String> {
	
	private List<String> countriesList;

	@SuppressWarnings("unchecked")
	public CountryStrategyFromFile(String pathToFile) {
		super(pathToFile);
		countriesList=(List<String>) this.getOptionList();
	}

	@Override
	public String create() {
		SecureRandom rnd=new SecureRandom();
		return countriesList.get(rnd.nextInt(countriesList.size())).substring(64,67).trim();
	}

}
