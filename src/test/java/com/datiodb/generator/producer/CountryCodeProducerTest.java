package com.datiodb.generator.producer;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.datiodb.generator.data.AbstractData;
import com.datiodb.generator.producer.strategy.CountryCodeStrategyFromFile;
import com.datiodb.generator.producer.strategy.DefaultCountryCodeStrategy;

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
		for(int i=0;i<100;i++) {
			AbstractData field=producer.createData();
			System.out.println(field.getName()+ ": " + field.getGenerateValue().toString());		
			assertThat(field,is(notNullValue()));
			assertThat(field.getGenerateValue(),is(instanceOf(String.class)));
		}
	}
	
	@Test
	public void testCreateDataFromSource() {
		DataProducer producer=new CountryCodeProducer();
		assertThat(producer,is(notNullValue()));
		producer.setStrategy(new CountryCodeStrategyFromFile(FILE_DAT));
		for(int i=0;i<100;i++) {
			AbstractData field=producer.createData();
			System.out.println(field.getName()+ ": " + field.getGenerateValue().toString());		
			assertThat(field,is(notNullValue()));
			assertThat(field.getGenerateValue(),is(instanceOf(String.class)));
		}
	}

}
