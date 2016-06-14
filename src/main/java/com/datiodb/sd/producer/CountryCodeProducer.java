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
import com.datiodb.sd.data.StringAbstractBase;
import com.datiodb.sd.producer.strategy.DataProducerStrategy;

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
	
	private class CountryField extends StringAbstractBase {

		public CountryField(String name) {
			super(name);
		}

		@Override
		public String getGenerateValue() {
			return (String) strategy.create();
		}

	}

}
