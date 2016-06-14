/*
 * Copyright (C) 2016 DatioBD 
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.datiodb.sd.producer;

import com.datiodb.sd.data.AbstractData;
import com.datiodb.sd.data.Length;
import com.datiodb.sd.data.StringAbstractBase;
import com.datiodb.sd.producer.strategy.DataProducerStrategy;
import com.datiodb.sd.producer.strategy.DefaultDniStrategy;

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
	
	private class DniField extends StringAbstractBase implements Length {
		
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
