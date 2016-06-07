package com.datiodb.generator.producer;

import com.datiodb.generator.field.AbstractField;
import com.datiodb.generator.field.TextFieldBase;
import com.datiodb.generator.producer.strategy.DataProducerStrategy;

public class DniProducer implements DataProducer {
	
	private DataProducerStrategy<?> strategy;

	@Override
	public void setStrategy(DataProducerStrategy<?> strategy) {
		this.strategy=strategy;
	}

	@Override
	public AbstractField createData() {
		return new DniField();
	}
	
	private class DniField extends TextFieldBase {
		
		private static final String MASK="########-#";
		
		public DniField() {
			super(9);
		}

		@Override
		public String getGenerateValue() {
			return this.apply((String)strategy.create(),MASK);
		}
		
		@Override
		public String apply(String value,String mask) {
			int index=0;
			StringBuffer buffer=new StringBuffer(); 
			for(int i=0;i<mask.length();i++) {
				char c=mask.charAt(i);
				if(c == '#') {
					buffer.append(value.charAt(index));
					index++;
				}
				else {
					buffer.append(c);
				}
			}
			return buffer.toString();
		}
		
	}

}
