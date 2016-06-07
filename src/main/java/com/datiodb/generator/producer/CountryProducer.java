package com.datiodb.generator.producer;

import com.datiodb.generator.field.AbstractField;
import com.datiodb.generator.field.TextFieldBase;
import com.datiodb.generator.producer.strategy.DataProducerStrategy;

public class CountryProducer implements DataProducer {
	
	private DataProducerStrategy<?> strategy;
	
	@Override
	public void setStrategy(DataProducerStrategy<?> strategy) {
		this.strategy=strategy;
	}

	@Override
	public AbstractField createData() {
		// TODO Auto-generated method stub
		return new CountryField(40);
	}
	
	private class CountryField extends TextFieldBase {

		public CountryField(int length) {
			super(length);
		}

		@Override
		public String getGenerateValue() {
			return (String) strategy.create();
		}
		
	}

}
