package com.datiodb.generator.producer.strategy;

import static org.junit.Assert.*;

import java.util.Date;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class DefaultDateStrategyTest {

	@Test
	public void testDefaultDateStrategy() {
		DataProducerStrategy<?> strategy=new DefaultDateStrategy(50);
		assertThat(strategy,is(notNullValue()));
	}

	@Test
	public void testCreate() {
		DataProducerStrategy<?> strategy=new DefaultDateStrategy(3);
		assertThat(strategy,is(notNullValue()));
		for(int i=0;i<10;i++)
			System.out.println("DATE: "+ strategy.create().toString());
		assertThat(strategy.create(),is(instanceOf(Date.class)));
	}

}
