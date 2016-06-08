package com.datiodb.generator.producer.strategy;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class CountryStrategyFromFileTest {

	@Test
	public void testCountryStrategyFromFile() {
		DataProducerStrategy<?> strategy=new CountryCodeStrategyFromFile("countries.dat");
		assertThat(strategy,is(notNullValue()));
	}

	@Test
	public void testCreate() {
		DataProducerStrategy<?> strategy=new CountryCodeStrategyFromFile("countries.dat");
		assertThat(strategy,is(notNullValue()));
		for(int i=0;i<100;i++)
			System.out.println("PAIS: "+strategy.create());
		assertThat(strategy.create(),is(instanceOf(String.class)));
	}

}
