package com.datiodb.generator.producer.strategy;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class DefaultCountryStrategyTest {

	@Test
	public void testCreate() {
		DataProducerStrategy<?> strategy=new DefaultCountryStrategy();
		assertThat(strategy,is(notNullValue()));
		for(int i=0;i<100;i++)
			System.out.println("PAIS: "+strategy.create());
		assertThat(strategy.create(),is(instanceOf(String.class)));
	}

}
