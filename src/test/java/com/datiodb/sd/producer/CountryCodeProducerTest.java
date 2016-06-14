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

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.datiodb.sd.data.AbstractData;
import com.datiodb.sd.producer.CountryCodeProducer;
import com.datiodb.sd.producer.DataProducer;
import com.datiodb.sd.producer.strategy.CountryCodeStrategyFromFile;
import com.datiodb.sd.producer.strategy.DefaultCountryCodeStrategy;

public class CountryCodeProducerTest {
	
	private static final String FILE_DAT="inputs/countries.dat";

	@Test
	public void testDefaultSetStrategy() {
		DataProducer producer=new CountryCodeProducer();
		producer.setStrategy(new DefaultCountryCodeStrategy());
		assertThat(producer,is(notNullValue()));
	}
	
	@Test
	public void testSetStrategyFromFile() {
		DataProducer producer=new CountryCodeProducer();
		producer.setStrategy(new CountryCodeStrategyFromFile(FILE_DAT));
		assertThat(producer,is(notNullValue()));
	}

	@Test
	public void testCreateData() {
		DataProducer producer=new CountryCodeProducer();
		assertThat(producer,is(notNullValue()));
		producer.setStrategy(new DefaultCountryCodeStrategy());
		AbstractData field=producer.createData();
		assertThat(field,is(notNullValue()));
		assertThat(field.getGenerateValue(),is(instanceOf(String.class)));
	}
	
	@Test
	public void testCreateDataFromSource() {
		DataProducer producer=new CountryCodeProducer();
		assertThat(producer,is(notNullValue()));
		producer.setStrategy(new CountryCodeStrategyFromFile(FILE_DAT));
		AbstractData field=producer.createData();
		assertThat(field,is(notNullValue()));
		assertThat(field.getGenerateValue(),is(instanceOf(String.class)));
	}

}
