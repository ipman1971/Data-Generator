package com.datiodb.generator.producer;

import com.datiodb.generator.data.AbstractData;
import com.datiodb.generator.data.TextAbstractBase;
import com.datiodb.generator.producer.strategy.DataProducerStrategy;

public class CountryCodeProducer implements DataProducer {
	
	private DataProducerStrategy<?> strategy;
	
	@Override
	public DataProducer setStrategy(DataProducerStrategy<?> strategy) {
		this.strategy=strategy;
		return this;
	}

	@Override
	public AbstractData createData() {
		// TODO Auto-generated method stub
		return new CountryField("COUNTRY CODE");
	}
	
	private class CountryField extends TextAbstractBase {

		public CountryField(String name) {
			super(name);
		}

		@Override
		public String getGenerateValue() {
			return (String) strategy.create();
		}

	}

}
