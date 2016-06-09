package com.datiodb.generator.producer;

import com.datiodb.generator.data.AbstractData;
import com.datiodb.generator.data.Length;
import com.datiodb.generator.data.TextAbstractBase;
import com.datiodb.generator.producer.strategy.DataProducerStrategy;
import com.datiodb.generator.producer.strategy.DefaultDniStrategy;

public class DniProducer implements DataProducer {
	
	private DataProducerStrategy<?> strategy;
	
	public DniProducer() {
		this.strategy=new DefaultDniStrategy();
	}

	@Override
	public DataProducer setStrategy(DataProducerStrategy<?> strategy) {
		this.strategy=strategy;
		return this;
	}

	@Override
	public AbstractData createData() {
		return new DniField(10);
	}
	
	private class DniField extends TextAbstractBase implements Length {
		
		private static final String MASK="########-#";
		private int length;
		
		public DniField(int length) {
			super("DNI");
			this.length=length;
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

		@Override
		public int getLength() {
			return this.length;
		}

		@Override
		public void setLength(int length) {
			this.length=length;
		}
		
	}

}
